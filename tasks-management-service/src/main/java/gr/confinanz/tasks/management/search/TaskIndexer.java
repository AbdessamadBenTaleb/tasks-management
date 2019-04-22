
package gr.confinanz.tasks.management.search;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelperUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.QueryConfig;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicyOption;

import gr.confinanz.tasks.management.constants.ActionKeys;
import gr.confinanz.tasks.management.model.Task;
import gr.confinanz.tasks.management.service.TaskLocalService;
import gr.confinanz.tasks.management.service.permission.TaskPermissionChecker;

/**
 * @author Abdessamad Ben Taleb
 * 
 */
@Component(immediate = true, service = Indexer.class)
public class TaskIndexer extends BaseIndexer<Task> {

	public static final String CLASS_NAME = Task.class.getName();

	public TaskIndexer() {
		setDefaultSelectedFieldNames(
			Field.COMPANY_ID, Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK,
			Field.UID, _TASK_TITLE, Field.DESCRIPTION);

		setFilterSearch(true);
		setPermissionAware(true);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public boolean hasPermission(
			PermissionChecker permissionChecker, String entryClassName,
			long entryClassPK, String actionId)
		throws Exception {

		return TaskPermissionChecker.contains(
			permissionChecker, entryClassPK, ActionKeys.VIEW);
	}

	@Override
	public void postProcessContextBooleanFilter(
			BooleanFilter contextBooleanFilter, SearchContext searchContext)
		throws Exception {

		addStatus(contextBooleanFilter, searchContext);
	}

	@Override
	public void postProcessSearchQuery(
			BooleanQuery searchQuery, BooleanFilter fullQueryBooleanFilter,
			SearchContext searchContext)
		throws Exception {

		addSearchTerm(searchQuery, searchContext, Field.DESCRIPTION, true);
		addSearchTerm(searchQuery, searchContext, _TASK_TITLE, true);
	}

	protected void addDefaultHighlightFieldNames(QueryConfig queryConfig) {
		queryConfig.addHighlightFieldNames(Field.ASSET_CATEGORY_TITLES);

		if (queryConfig.isHighlightEnabled()) {
			queryConfig.addHighlightFieldNames(
				Field.CONTENT, Field.DESCRIPTION, _TASK_TITLE);
		}
	}

	@Override
	protected void doDelete(Task task) throws Exception {
		deleteDocument(task.getCompanyId(), task.getTaskId());
	}

	@Override
	protected Document doGetDocument(Task task) throws Exception {
		Document document = getBaseModelDocument(CLASS_NAME, task);

		document.addText(_TASK_TITLE, task.getTitle());
		document.addKeyword(_TASK_ID, task.getTaskId());
		document.addText(Field.DESCRIPTION, task.getDescription());

		return document;
	}

	@Override
	protected Summary doGetSummary(
			Document document, Locale locale, String snippet,
			PortletRequest portletRequest, PortletResponse portletResponse)
		throws Exception {

		Summary summary = createSummary(
			document, _TASK_TITLE, Field.DESCRIPTION);

		summary.setMaxContentLength(200);

		return summary;
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		Task task = _taskLocalService.getTask(classPK);

		doReindex(task);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);

		reindexTasks(companyId);
	}

	@Override
	protected void doReindex(Task task) throws Exception {
		Document document = getDocument(task);

		IndexWriterHelperUtil.updateDocument(
			getSearchEngineId(), task.getCompanyId(), document,
			isCommitImmediately());
	}

	protected void reindexTasks(long companyId) throws PortalException {
		if (_log.isDebugEnabled()) {
			_log.debug("Start reindexTasks() for companyId " + companyId);
		}

		final IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			_taskLocalService.getIndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setCompanyId(companyId);
		indexableActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Task>() {

				@Override
				public void performAction(Task task) {
					try {
						Document document = getDocument(task);

						indexableActionableDynamicQuery.addDocuments(document);
					}
					catch (PortalException pe) {
						if (_log.isWarnEnabled()) {
							_log.warn(
								"Unable to index task " + task.getTaskId(), pe);
						}
					}
				}

			});

		indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());

		indexableActionableDynamicQuery.performActions();

		if (_log.isDebugEnabled()) {
			_log.debug("End reindexTasks() for companyId " + companyId);
		}
	}

	private static final String _TASK_ID = "taskId";

	private static final String _TASK_TITLE = "taskTitle";

	private static final Log _log = LogFactoryUtil.getLog(TaskIndexer.class);

	@Reference(policyOption = ReferencePolicyOption.GREEDY)
	private TaskLocalService _taskLocalService;

}
package gr.confinanz.tasks.management.web.asset;

import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gr.confinanz.tasks.management.constants.ActionKeys;
import gr.confinanz.tasks.management.constants.TasksManagementPortletKeys;
import gr.confinanz.tasks.management.constants.TasksManagementWebKeys;
import gr.confinanz.tasks.management.model.Task;
import gr.confinanz.tasks.management.service.permission.TaskPermissionChecker;

/**
 * @author Abdessamad Ben Taleb
 *
 */
public class TaskAssetRenderer extends BaseJSPAssetRenderer<Task> {

	public TaskAssetRenderer(Task task) {
		_task = task;
	}

	@Override
	public Task getAssetObject() {
		return _task;
	}

	@Override
	public String getClassName() {
		return Task.class.getName();
	}

	@Override
	public long getClassPK() {
		return _task.getTaskId();
	}

	@Override
	public long getGroupId() {
		return _task.getGroupId();
	}

	@Override
	public String getJspPath(HttpServletRequest request, String template) {
		return "/asset/" + template + ".jsp";
	}

	@Override
	public String getSummary(
		PortletRequest portletRequest, PortletResponse portletResponse) {

		return HtmlUtil.extractText(_task.getDescription());
	}

	@Override
	public String getTitle(Locale locale) {
		return _task.getTitle();
	}

	@Override
	public PortletURL getURLEdit(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse)
		throws Exception {

		long plid = PortalUtil.getPlidFromPortletId(
			_task.getGroupId(), TasksManagementPortletKeys.TASKS_MANAGEMENT);

		PortletURL portletURL = PortletURLFactoryUtil.create(
			liferayPortletRequest, TasksManagementPortletKeys.TASKS_MANAGEMENT, plid,
			PortletRequest.RENDER_PHASE);

		portletURL.setParameter(
			"mvcRenderCommandName", "/tasks-management/task/edit");
		portletURL.setParameter("taskId", String.valueOf(_task.getTaskId()));

		return portletURL;
	}

	@Override
	public String getURLViewInContext(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse,
			String noSuchEntryRedirect)
		throws Exception {

		try {
			long plid = PortalUtil.getPlidFromPortletId(
				_task.getGroupId(), TasksManagementPortletKeys.TASKS_MANAGEMENT);

			PortletURL portletURL = PortletURLFactoryUtil.create(
				liferayPortletRequest, TasksManagementPortletKeys.TASKS_MANAGEMENT,
				plid, PortletRequest.RENDER_PHASE);

			portletURL.setParameter("mvcPath", "/view_task.jsp");
			portletURL.setParameter(
				"taskId", String.valueOf(_task.getTaskId()));

			String currentUrl = PortalUtil.getCurrentURL(liferayPortletRequest);

			portletURL.setParameter("redirect", currentUrl);

			return portletURL.toString();
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		return noSuchEntryRedirect;
	}

	@Override
	public long getUserId() {
		return _task.getUserId();
	}

	@Override
	public String getUserName() {
		return _task.getUserName();
	}

	@Override
	public String getUuid() {
		return _task.getUuid();
	}

	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker)
		throws PortalException {

		return TaskPermissionChecker.contains(
			permissionChecker, _task, ActionKeys.UPDATE);
	}

	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker)
		throws PortalException {

		return TaskPermissionChecker.contains(
			permissionChecker, _task, ActionKeys.VIEW);
	}

	@Override
	public boolean include(
			HttpServletRequest request, HttpServletResponse response,
			String template)
		throws Exception {

		request.setAttribute(TasksManagementWebKeys.TASK, _task);

		return super.include(request, response, template);
	}

	private static Log _log = LogFactoryUtil.getLog(TaskAssetRenderer.class);

	private Task _task;
	
}
	


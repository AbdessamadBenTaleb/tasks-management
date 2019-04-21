package gr.confinanz.tasks.management.web.portlet.rendercmd;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import gr.confinanz.tasks.management.constants.TasksManagementPortletKeys;
import gr.confinanz.tasks.management.constants.TasksManagementWebKeys;
import gr.confinanz.tasks.management.model.Task;
import gr.confinanz.tasks.management.service.TaskService;

/**
 * @author Abdessamad Ben Taleb
 *
 */
@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + TasksManagementPortletKeys.TASKS_MANAGEMENT,
			"mvc.command.name=/tasks-management/task/edit"
		},
		service = MVCRenderCommand.class
	)
	public class EditTaskRenderCommand implements MVCRenderCommand {

		@Override
		public String render(
				RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

			Task task = null;

			long taskId = ParamUtil.getLong(renderRequest, "taskId");

			if (taskId > 0) {
				try {
					task = _taskService.getTask(taskId);
				}
				catch (Exception e) {
					_log.error(e);
				}
			}

			renderRequest.setAttribute(TasksManagementWebKeys.TASK, task);

			return "/edit_task.jsp";
		}

		private static Log _log = LogFactoryUtil.getLog(
			EditTaskRenderCommand.class);

		@Reference(cardinality = ReferenceCardinality.MANDATORY)
		private TaskService _taskService;

}

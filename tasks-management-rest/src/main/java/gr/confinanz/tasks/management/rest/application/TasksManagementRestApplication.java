package gr.confinanz.tasks.management.rest.application;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyService;
import com.liferay.portal.kernel.service.GroupService;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicyOption;

import gr.confinanz.tasks.management.model.Task;
import gr.confinanz.tasks.management.service.TaskService;


/**
 * @author Abdessamad Ben Taleb
 * 
 */
@ApplicationPath("/tasks-management")
@Component(immediate = true, 	service = Application.class
)
public class TasksManagementRestApplication extends Application {

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}
	
	@GET
	@Path("/task/{taskId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getTask(@PathParam("taskId") long taskId) {
		try {
			return JSONFactoryUtil.serialize(_taskService.getTask(taskId));
		}
		catch (Exception e) {
			_log.error(e, e);

			return "{}";
		}
	}

	@GET
	@Path("/tasks")
	@Produces(MediaType.APPLICATION_JSON)
	public String getTasks() {
		Company company;
		List<Task> tasks = new ArrayList<>();

		try {
			company = _companyService.getCompanyById(
				PortalUtil.getDefaultCompanyId());

			List<Group> groups = _groupService.getGroups(
				company.getCompanyId(), 0, true);

			for (Group group : groups) {
				tasks.addAll(
					_taskService.getTasks(
						company.getCompanyId(), group.getGroupId(),
						QueryUtil.ALL_POS, QueryUtil.ALL_POS));
			}

			return JSONFactoryUtil.serialize(tasks);
		}
		catch (PortalException pe) {
			_log.error(pe, pe);

			return "[{}]";
		}
	}

	private static Log _log = LogFactoryUtil.getLog(TasksManagementRestApplication.class);

	@Reference(policyOption = ReferencePolicyOption.GREEDY)
	private CompanyService _companyService;

	@Reference(policyOption = ReferencePolicyOption.GREEDY)
	private GroupService _groupService;

	@Reference(policyOption = ReferencePolicyOption.GREEDY)
	private TaskService _taskService;
	
	// Generated example
//	@GET
//	@Produces("text/plain")
//	public String working() {
//		return "It works!";
//	}
//
//	@GET
//	@Path("/morning")
//	@Produces("text/plain")
//	public String hello() {
//		return "Good morning!";
//	}
//
//	@GET
//	@Path("/morning/{name}")
//	@Produces("text/plain")
//	public String morning(
//		@PathParam("name") String name,
//		@QueryParam("drink") String drink) {
//
//		String greeting = "Good Morning " + name;
//
//		if (drink != null) {
//			greeting += ". Would you like some " + drink + "?";
//		}
//
//		return greeting;
//	}

}
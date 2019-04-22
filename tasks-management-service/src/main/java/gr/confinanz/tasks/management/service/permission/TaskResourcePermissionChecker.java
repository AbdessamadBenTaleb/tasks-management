package gr.confinanz.tasks.management.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseResourcePermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.ResourcePermissionChecker;

import org.osgi.service.component.annotations.Component;

/**
 * @author Abdessamad Ben Taleb
 *
 */
@Component(
		immediate = true,
		property = {"resource.name=" + TaskResourcePermissionChecker.RESOURCE_NAME},
		service = ResourcePermissionChecker.class
	)
public class TaskResourcePermissionChecker
		extends BaseResourcePermissionChecker {

		public static final String RESOURCE_NAME = "gr.confinanz.tasks.management";
		
		public static final String TASKS_MANAGEMENT_PORTLET_KEY = 
				"gr_confinanz_tasks_management_web_portlet_TasksManagementPortlet";
		
		public static void check(
				PermissionChecker permissionChecker, long groupId, String actionId)
			throws PortalException {

			if (!contains(permissionChecker, groupId, actionId)) {
				throw new PrincipalException.MustHavePermission(
					permissionChecker, RESOURCE_NAME, groupId, actionId);
			}
		}

		public static boolean contains(
			PermissionChecker permissionChecker, long groupId, String actionId) {

			return contains(
				permissionChecker, RESOURCE_NAME,
				TASKS_MANAGEMENT_PORTLET_KEY, groupId, actionId);
		}

		@Override
		public Boolean checkResource(
			PermissionChecker permissionChecker, long classPK, String actionId) {

			return contains(permissionChecker, classPK, actionId);
		}

	}
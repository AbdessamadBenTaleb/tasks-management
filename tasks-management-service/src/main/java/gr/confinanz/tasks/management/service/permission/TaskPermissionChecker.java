package gr.confinanz.tasks.management.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

/**
 * @author Abdessamad Ben Taleb
 *
 */
public class TaskPermissionChecker implements BaseModelPermissionChecker {

	@Override
	public void checkBaseModel(PermissionChecker permissionChecker, 
			long groupId, long primaryKey, String actionId)
			throws PortalException {
		// TODO Auto-generated method stub

	}

}

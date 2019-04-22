/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package gr.confinanz.tasks.management.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;

import aQute.bnd.annotation.ProviderType;
import gr.confinanz.tasks.management.constants.ActionKeys;
import gr.confinanz.tasks.management.model.Task;
import gr.confinanz.tasks.management.service.base.TaskServiceBaseImpl;
import gr.confinanz.tasks.management.service.permission.TaskPermissionChecker;
import gr.confinanz.tasks.management.service.permission.TaskResourcePermissionChecker;

/**
 * The implementation of the task remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link gr.confinanz.tasks.management.service.TaskService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Abdessamad Ben Taleb
 * @see TaskServiceBaseImpl
 * @see gr.confinanz.tasks.management.service.TaskServiceUtil
 */
@ProviderType
public class TaskServiceImpl extends TaskServiceBaseImpl {
	
	
	public Task addTask(
			String title, String description, int expirationDateMonth,
			int expirationDateDay, int expirationDateYear, long taskUserId,
			boolean completed, ServiceContext serviceContext)
		throws PortalException {

		TaskResourcePermissionChecker.check(
				getPermissionChecker(), serviceContext.getScopeGroupId(),
				ActionKeys.ADD_TASK);
		
		return taskLocalService.addTask(
			getUserId(), title, description, expirationDateMonth,
			expirationDateDay, expirationDateYear, taskUserId, completed,
			serviceContext);
	}

	public Task deleteTask(long taskId) throws PortalException {
		TaskPermissionChecker.check(
				getPermissionChecker(), taskId, ActionKeys.DELETE);
		return taskLocalService.deleteTask(taskId);
	}

	public Task getTask(long taskId) throws PortalException {
		TaskPermissionChecker.check(
				getPermissionChecker(), taskId, ActionKeys.VIEW);
		return taskLocalService.getTask(taskId);
	}

	public List<Task> getTasks(
		long companyId, long groupId, int start, int end) {

		return taskPersistence.findByC_G(companyId, groupId, start, end);
	}

	public List<Task> getTasks(
		long companyId, long groupId, int status, int start, int end) {

		return taskPersistence.findByC_G_S(
			companyId, groupId, status, start, end);
	}

	public int getTasksCount(long companyId, long groupId) {
		return taskPersistence.countByC_G(companyId, groupId);
	}

	public int getTasksCount(long companyId, long groupId, int status) {
		return taskPersistence.countByC_G_S(companyId, groupId, status);
	}

	public Task updateTask(
			long taskId, String title, String description,
			int expirationDateMonth, int expirationDateDay,
			int expirationDateYear, long taskUserId, boolean completed,
			ServiceContext serviceContext)
		throws PortalException {


		TaskPermissionChecker.check(
			getPermissionChecker(), taskId, ActionKeys.UPDATE);

		return taskLocalService.updateTask(
			getUserId(), taskId, title, description, expirationDateMonth,
			expirationDateDay, expirationDateYear, taskUserId, completed,
			serviceContext);
	}
}
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

package gr.confinanz.tasks.management.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TaskService}.
 *
 * @author Abdessamad Ben Taleb
 * @see TaskService
 * @generated
 */
@ProviderType
public class TaskServiceWrapper implements TaskService,
	ServiceWrapper<TaskService> {
	public TaskServiceWrapper(TaskService taskService) {
		_taskService = taskService;
	}

	@Override
	public gr.confinanz.tasks.management.model.Task addTask(
		java.lang.String title, java.lang.String description,
		int expirationDateMonth, int expirationDateDay, int expirationDateYear,
		long taskUserId, boolean completed,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _taskService.addTask(title, description, expirationDateMonth,
			expirationDateDay, expirationDateYear, taskUserId, completed,
			serviceContext);
	}

	@Override
	public gr.confinanz.tasks.management.model.Task deleteTask(long taskId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _taskService.deleteTask(taskId);
	}

	@Override
	public gr.confinanz.tasks.management.model.Task getTask(long taskId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _taskService.getTask(taskId);
	}

	@Override
	public gr.confinanz.tasks.management.model.Task updateTask(long taskId,
		java.lang.String title, java.lang.String description,
		int expirationDateMonth, int expirationDateDay, int expirationDateYear,
		long taskUserId, boolean completed,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _taskService.updateTask(taskId, title, description,
			expirationDateMonth, expirationDateDay, expirationDateYear,
			taskUserId, completed, serviceContext);
	}

	@Override
	public int getTasksCount(long companyId, long groupId) {
		return _taskService.getTasksCount(companyId, groupId);
	}

	@Override
	public int getTasksCount(long companyId, long groupId, int status) {
		return _taskService.getTasksCount(companyId, groupId, status);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _taskService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<gr.confinanz.tasks.management.model.Task> getTasks(
		long companyId, long groupId, int start, int end) {
		return _taskService.getTasks(companyId, groupId, start, end);
	}

	@Override
	public java.util.List<gr.confinanz.tasks.management.model.Task> getTasks(
		long companyId, long groupId, int status, int start, int end) {
		return _taskService.getTasks(companyId, groupId, status, start, end);
	}

	@Override
	public TaskService getWrappedService() {
		return _taskService;
	}

	@Override
	public void setWrappedService(TaskService taskService) {
		_taskService = taskService;
	}

	private TaskService _taskService;
}
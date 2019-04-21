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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Task. This utility wraps
 * {@link gr.confinanz.tasks.management.service.impl.TaskServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Abdessamad Ben Taleb
 * @see TaskService
 * @see gr.confinanz.tasks.management.service.base.TaskServiceBaseImpl
 * @see gr.confinanz.tasks.management.service.impl.TaskServiceImpl
 * @generated
 */
@ProviderType
public class TaskServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link gr.confinanz.tasks.management.service.impl.TaskServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static gr.confinanz.tasks.management.model.Task addTask(
		java.lang.String title, java.lang.String description,
		int expirationDateMonth, int expirationDateDay, int expirationDateYear,
		long taskUserId, boolean completed,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addTask(title, description, expirationDateMonth,
			expirationDateDay, expirationDateYear, taskUserId, completed,
			serviceContext);
	}

	public static gr.confinanz.tasks.management.model.Task deleteTask(
		long taskId) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteTask(taskId);
	}

	public static gr.confinanz.tasks.management.model.Task getTask(long taskId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTask(taskId);
	}

	public static gr.confinanz.tasks.management.model.Task updateTask(
		long taskId, java.lang.String title, java.lang.String description,
		int expirationDateMonth, int expirationDateDay, int expirationDateYear,
		long taskUserId, boolean completed,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateTask(taskId, title, description, expirationDateMonth,
			expirationDateDay, expirationDateYear, taskUserId, completed,
			serviceContext);
	}

	public static int getTasksCount(long companyId, long groupId) {
		return getService().getTasksCount(companyId, groupId);
	}

	public static int getTasksCount(long companyId, long groupId, int status) {
		return getService().getTasksCount(companyId, groupId, status);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<gr.confinanz.tasks.management.model.Task> getTasks(
		long companyId, long groupId, int start, int end) {
		return getService().getTasks(companyId, groupId, start, end);
	}

	public static java.util.List<gr.confinanz.tasks.management.model.Task> getTasks(
		long companyId, long groupId, int status, int start, int end) {
		return getService().getTasks(companyId, groupId, status, start, end);
	}

	public static TaskService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TaskService, TaskService> _serviceTracker = ServiceTrackerFactory.open(TaskService.class);
}
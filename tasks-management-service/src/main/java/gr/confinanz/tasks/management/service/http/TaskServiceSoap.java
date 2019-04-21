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

package gr.confinanz.tasks.management.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import gr.confinanz.tasks.management.service.TaskServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link TaskServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link gr.confinanz.tasks.management.model.TaskSoap}.
 * If the method in the service utility returns a
 * {@link gr.confinanz.tasks.management.model.Task}, that is translated to a
 * {@link gr.confinanz.tasks.management.model.TaskSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Abdessamad Ben Taleb
 * @see TaskServiceHttp
 * @see gr.confinanz.tasks.management.model.TaskSoap
 * @see TaskServiceUtil
 * @generated
 */
@ProviderType
public class TaskServiceSoap {
	public static gr.confinanz.tasks.management.model.TaskSoap addTask(
		java.lang.String title, java.lang.String description,
		int expirationDateMonth, int expirationDateDay, int expirationDateYear,
		long taskUserId, boolean completed,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			gr.confinanz.tasks.management.model.Task returnValue = TaskServiceUtil.addTask(title,
					description, expirationDateMonth, expirationDateDay,
					expirationDateYear, taskUserId, completed, serviceContext);

			return gr.confinanz.tasks.management.model.TaskSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static gr.confinanz.tasks.management.model.TaskSoap deleteTask(
		long taskId) throws RemoteException {
		try {
			gr.confinanz.tasks.management.model.Task returnValue = TaskServiceUtil.deleteTask(taskId);

			return gr.confinanz.tasks.management.model.TaskSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static gr.confinanz.tasks.management.model.TaskSoap getTask(
		long taskId) throws RemoteException {
		try {
			gr.confinanz.tasks.management.model.Task returnValue = TaskServiceUtil.getTask(taskId);

			return gr.confinanz.tasks.management.model.TaskSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static gr.confinanz.tasks.management.model.TaskSoap[] getTasks(
		long companyId, long groupId, int start, int end)
		throws RemoteException {
		try {
			java.util.List<gr.confinanz.tasks.management.model.Task> returnValue =
				TaskServiceUtil.getTasks(companyId, groupId, start, end);

			return gr.confinanz.tasks.management.model.TaskSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static gr.confinanz.tasks.management.model.TaskSoap[] getTasks(
		long companyId, long groupId, int status, int start, int end)
		throws RemoteException {
		try {
			java.util.List<gr.confinanz.tasks.management.model.Task> returnValue =
				TaskServiceUtil.getTasks(companyId, groupId, status, start, end);

			return gr.confinanz.tasks.management.model.TaskSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getTasksCount(long companyId, long groupId)
		throws RemoteException {
		try {
			int returnValue = TaskServiceUtil.getTasksCount(companyId, groupId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getTasksCount(long companyId, long groupId, int status)
		throws RemoteException {
		try {
			int returnValue = TaskServiceUtil.getTasksCount(companyId, groupId,
					status);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static gr.confinanz.tasks.management.model.TaskSoap updateTask(
		long taskId, java.lang.String title, java.lang.String description,
		int expirationDateMonth, int expirationDateDay, int expirationDateYear,
		long taskUserId, boolean completed,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			gr.confinanz.tasks.management.model.Task returnValue = TaskServiceUtil.updateTask(taskId,
					title, description, expirationDateMonth, expirationDateDay,
					expirationDateYear, taskUserId, completed, serviceContext);

			return gr.confinanz.tasks.management.model.TaskSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(TaskServiceSoap.class);
}
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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import gr.confinanz.tasks.management.service.TaskServiceUtil;

/**
 * Provides the HTTP utility for the
 * {@link TaskServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Abdessamad Ben Taleb
 * @see TaskServiceSoap
 * @see HttpPrincipal
 * @see TaskServiceUtil
 * @generated
 */
@ProviderType
public class TaskServiceHttp {
	public static gr.confinanz.tasks.management.model.Task addTask(
		HttpPrincipal httpPrincipal, java.lang.String title,
		java.lang.String description, int expirationDateMonth,
		int expirationDateDay, int expirationDateYear, long taskUserId,
		boolean completed,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(TaskServiceUtil.class,
					"addTask", _addTaskParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, title,
					description, expirationDateMonth, expirationDateDay,
					expirationDateYear, taskUserId, completed, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (gr.confinanz.tasks.management.model.Task)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static gr.confinanz.tasks.management.model.Task deleteTask(
		HttpPrincipal httpPrincipal, long taskId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(TaskServiceUtil.class,
					"deleteTask", _deleteTaskParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, taskId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (gr.confinanz.tasks.management.model.Task)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static gr.confinanz.tasks.management.model.Task getTask(
		HttpPrincipal httpPrincipal, long taskId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(TaskServiceUtil.class,
					"getTask", _getTaskParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, taskId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (gr.confinanz.tasks.management.model.Task)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<gr.confinanz.tasks.management.model.Task> getTasks(
		HttpPrincipal httpPrincipal, long companyId, long groupId, int start,
		int end) {
		try {
			MethodKey methodKey = new MethodKey(TaskServiceUtil.class,
					"getTasks", _getTasksParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					companyId, groupId, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<gr.confinanz.tasks.management.model.Task>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<gr.confinanz.tasks.management.model.Task> getTasks(
		HttpPrincipal httpPrincipal, long companyId, long groupId, int status,
		int start, int end) {
		try {
			MethodKey methodKey = new MethodKey(TaskServiceUtil.class,
					"getTasks", _getTasksParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					companyId, groupId, status, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<gr.confinanz.tasks.management.model.Task>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int getTasksCount(HttpPrincipal httpPrincipal,
		long companyId, long groupId) {
		try {
			MethodKey methodKey = new MethodKey(TaskServiceUtil.class,
					"getTasksCount", _getTasksCountParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					companyId, groupId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int getTasksCount(HttpPrincipal httpPrincipal,
		long companyId, long groupId, int status) {
		try {
			MethodKey methodKey = new MethodKey(TaskServiceUtil.class,
					"getTasksCount", _getTasksCountParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					companyId, groupId, status);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static gr.confinanz.tasks.management.model.Task updateTask(
		HttpPrincipal httpPrincipal, long taskId, java.lang.String title,
		java.lang.String description, int expirationDateMonth,
		int expirationDateDay, int expirationDateYear, long taskUserId,
		boolean completed,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(TaskServiceUtil.class,
					"updateTask", _updateTaskParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(methodKey, taskId,
					title, description, expirationDateMonth, expirationDateDay,
					expirationDateYear, taskUserId, completed, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (gr.confinanz.tasks.management.model.Task)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(TaskServiceHttp.class);
	private static final Class<?>[] _addTaskParameterTypes0 = new Class[] {
			java.lang.String.class, java.lang.String.class, int.class, int.class,
			int.class, long.class, boolean.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteTaskParameterTypes1 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getTaskParameterTypes2 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getTasksParameterTypes3 = new Class[] {
			long.class, long.class, int.class, int.class
		};
	private static final Class<?>[] _getTasksParameterTypes4 = new Class[] {
			long.class, long.class, int.class, int.class, int.class
		};
	private static final Class<?>[] _getTasksCountParameterTypes5 = new Class[] {
			long.class, long.class
		};
	private static final Class<?>[] _getTasksCountParameterTypes6 = new Class[] {
			long.class, long.class, int.class
		};
	private static final Class<?>[] _updateTaskParameterTypes7 = new Class[] {
			long.class, java.lang.String.class, java.lang.String.class,
			int.class, int.class, int.class, long.class, boolean.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
}
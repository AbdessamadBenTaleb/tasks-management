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

import com.liferay.exportimport.kernel.lar.PortletDataContext;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import gr.confinanz.tasks.management.model.Task;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for Task. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Abdessamad Ben Taleb
 * @see TaskLocalServiceUtil
 * @see gr.confinanz.tasks.management.service.base.TaskLocalServiceBaseImpl
 * @see gr.confinanz.tasks.management.service.impl.TaskLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface TaskLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaskLocalServiceUtil} to access the task local service. Add custom service methods to {@link gr.confinanz.tasks.management.service.impl.TaskLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Adds the task to the database. Also notifies the appropriate model listeners.
	*
	* @param task the task
	* @return the task that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Task addTask(Task task);

	@Indexable(type = IndexableType.REINDEX)
	public Task addTask(long userId, java.lang.String title,
		java.lang.String description, int expirationDateMonth,
		int expirationDateDay, int expirationDateYear, long taskUserId,
		boolean completed, ServiceContext serviceContext)
		throws PortalException;

	/**
	* Creates a new task with the primary key. Does not add the task to the database.
	*
	* @param taskId the primary key for the new task
	* @return the new task
	*/
	public Task createTask(long taskId);

	/**
	* Deletes the task from the database. Also notifies the appropriate model listeners.
	*
	* @param task the task
	* @return the task that was removed
	* @throws PortalException
	*/
	@Indexable(type = IndexableType.DELETE)
	public Task deleteTask(Task task) throws PortalException;

	/**
	* Deletes the task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taskId the primary key of the task
	* @return the task that was removed
	* @throws PortalException if a task with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public Task deleteTask(long taskId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Task fetchTask(long taskId);

	/**
	* Returns the task matching the UUID and group.
	*
	* @param uuid the task's UUID
	* @param groupId the primary key of the group
	* @return the matching task, or <code>null</code> if a matching task could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Task fetchTaskByUuidAndGroupId(java.lang.String uuid, long groupId);

	/**
	* Returns the task with the primary key.
	*
	* @param taskId the primary key of the task
	* @return the task
	* @throws PortalException if a task with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Task getTask(long taskId) throws PortalException;

	/**
	* Returns the task matching the UUID and group.
	*
	* @param uuid the task's UUID
	* @param groupId the primary key of the group
	* @return the matching task
	* @throws PortalException if a matching task could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Task getTaskByUuidAndGroupId(java.lang.String uuid, long groupId)
		throws PortalException;

	/**
	* Updates the task in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param task the task
	* @return the task that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Task updateTask(Task task);

	@Indexable(type = IndexableType.REINDEX)
	public Task updateTask(long userId, long taskId, java.lang.String title,
		java.lang.String description, int expirationDateMonth,
		int expirationDateDay, int expirationDateYear, long taskUserId,
		boolean completed, ServiceContext serviceContext)
		throws PortalException;

	/**
	* Returns the number of tasks.
	*
	* @return the number of tasks
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTasksCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTasksCount(long companyId, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTasksCount(long companyId, long groupId, int status);

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link gr.confinanz.tasks.management.model.impl.TaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link gr.confinanz.tasks.management.model.impl.TaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns a range of all the tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link gr.confinanz.tasks.management.model.impl.TaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tasks
	* @param end the upper bound of the range of tasks (not inclusive)
	* @return the range of tasks
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Task> getTasks(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Task> getTasks(long companyId, long groupId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Task> getTasks(long companyId, long groupId, int status,
		int start, int end);

	/**
	* Returns all the tasks matching the UUID and company.
	*
	* @param uuid the UUID of the tasks
	* @param companyId the primary key of the company
	* @return the matching tasks, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Task> getTasksByUuidAndCompanyId(java.lang.String uuid,
		long companyId);

	/**
	* Returns a range of tasks matching the UUID and company.
	*
	* @param uuid the UUID of the tasks
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of tasks
	* @param end the upper bound of the range of tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching tasks, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Task> getTasksByUuidAndCompanyId(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Task> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	public void deleteGroupTasks(long companyId, long groupId)
		throws PortalException;

	public void deleteUserTasks(long companyId, long userId)
		throws PortalException;

	public void updateAsset(long userId, Task task, long[] assetCategoryIds,
		java.lang.String[] assetTagNames, long[] assetLinkEntryIds,
		java.lang.Double priority) throws PortalException;
}
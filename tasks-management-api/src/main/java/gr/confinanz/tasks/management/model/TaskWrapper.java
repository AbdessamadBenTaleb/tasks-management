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

package gr.confinanz.tasks.management.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Task}.
 * </p>
 *
 * @author Abdessamad Ben Taleb
 * @see Task
 * @generated
 */
@ProviderType
public class TaskWrapper implements Task, ModelWrapper<Task> {
	public TaskWrapper(Task task) {
		_task = task;
	}

	@Override
	public Class<?> getModelClass() {
		return Task.class;
	}

	@Override
	public String getModelClassName() {
		return Task.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("taskId", getTaskId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("expirationDate", getExpirationDate());
		attributes.put("taskUserId", getTaskUserId());
		attributes.put("completed", getCompleted());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long taskId = (Long)attributes.get("taskId");

		if (taskId != null) {
			setTaskId(taskId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date expirationDate = (Date)attributes.get("expirationDate");

		if (expirationDate != null) {
			setExpirationDate(expirationDate);
		}

		Long taskUserId = (Long)attributes.get("taskUserId");

		if (taskUserId != null) {
			setTaskUserId(taskUserId);
		}

		Boolean completed = (Boolean)attributes.get("completed");

		if (completed != null) {
			setCompleted(completed);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	/**
	* Returns the completed of this task.
	*
	* @return the completed of this task
	*/
	@Override
	public boolean getCompleted() {
		return _task.getCompleted();
	}

	/**
	* Returns <code>true</code> if this task is approved.
	*
	* @return <code>true</code> if this task is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _task.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _task.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this task is completed.
	*
	* @return <code>true</code> if this task is completed; <code>false</code> otherwise
	*/
	@Override
	public boolean isCompleted() {
		return _task.isCompleted();
	}

	/**
	* Returns <code>true</code> if this task is denied.
	*
	* @return <code>true</code> if this task is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _task.isDenied();
	}

	/**
	* Returns <code>true</code> if this task is a draft.
	*
	* @return <code>true</code> if this task is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _task.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _task.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this task is expired.
	*
	* @return <code>true</code> if this task is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _task.isExpired();
	}

	/**
	* Returns <code>true</code> if this task is inactive.
	*
	* @return <code>true</code> if this task is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _task.isInactive();
	}

	/**
	* Returns <code>true</code> if this task is incomplete.
	*
	* @return <code>true</code> if this task is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _task.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _task.isNew();
	}

	/**
	* Returns <code>true</code> if this task is pending.
	*
	* @return <code>true</code> if this task is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _task.isPending();
	}

	/**
	* Returns <code>true</code> if this task is scheduled.
	*
	* @return <code>true</code> if this task is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _task.isScheduled();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _task.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<gr.confinanz.tasks.management.model.Task> toCacheModel() {
		return _task.toCacheModel();
	}

	@Override
	public gr.confinanz.tasks.management.model.Task toEscapedModel() {
		return new TaskWrapper(_task.toEscapedModel());
	}

	@Override
	public gr.confinanz.tasks.management.model.Task toUnescapedModel() {
		return new TaskWrapper(_task.toUnescapedModel());
	}

	@Override
	public int compareTo(gr.confinanz.tasks.management.model.Task task) {
		return _task.compareTo(task);
	}

	/**
	* Returns the status of this task.
	*
	* @return the status of this task
	*/
	@Override
	public int getStatus() {
		return _task.getStatus();
	}

	@Override
	public int hashCode() {
		return _task.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _task.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new TaskWrapper((Task)_task.clone());
	}

	/**
	* Returns the description of this task.
	*
	* @return the description of this task
	*/
	@Override
	public java.lang.String getDescription() {
		return _task.getDescription();
	}

	/**
	* Returns the status by user name of this task.
	*
	* @return the status by user name of this task
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _task.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this task.
	*
	* @return the status by user uuid of this task
	*/
	@Override
	public java.lang.String getStatusByUserUuid() {
		return _task.getStatusByUserUuid();
	}

	/**
	* Returns the task user uuid of this task.
	*
	* @return the task user uuid of this task
	*/
	@Override
	public java.lang.String getTaskUserUuid() {
		return _task.getTaskUserUuid();
	}

	/**
	* Returns the title of this task.
	*
	* @return the title of this task
	*/
	@Override
	public java.lang.String getTitle() {
		return _task.getTitle();
	}

	/**
	* Returns the user name of this task.
	*
	* @return the user name of this task
	*/
	@Override
	public java.lang.String getUserName() {
		return _task.getUserName();
	}

	/**
	* Returns the user uuid of this task.
	*
	* @return the user uuid of this task
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _task.getUserUuid();
	}

	/**
	* Returns the uuid of this task.
	*
	* @return the uuid of this task
	*/
	@Override
	public java.lang.String getUuid() {
		return _task.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _task.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _task.toXmlString();
	}

	/**
	* Returns the create date of this task.
	*
	* @return the create date of this task
	*/
	@Override
	public Date getCreateDate() {
		return _task.getCreateDate();
	}

	/**
	* Returns the expiration date of this task.
	*
	* @return the expiration date of this task
	*/
	@Override
	public Date getExpirationDate() {
		return _task.getExpirationDate();
	}

	/**
	* Returns the modified date of this task.
	*
	* @return the modified date of this task
	*/
	@Override
	public Date getModifiedDate() {
		return _task.getModifiedDate();
	}

	/**
	* Returns the status date of this task.
	*
	* @return the status date of this task
	*/
	@Override
	public Date getStatusDate() {
		return _task.getStatusDate();
	}

	/**
	* Returns the company ID of this task.
	*
	* @return the company ID of this task
	*/
	@Override
	public long getCompanyId() {
		return _task.getCompanyId();
	}

	/**
	* Returns the group ID of this task.
	*
	* @return the group ID of this task
	*/
	@Override
	public long getGroupId() {
		return _task.getGroupId();
	}

	/**
	* Returns the primary key of this task.
	*
	* @return the primary key of this task
	*/
	@Override
	public long getPrimaryKey() {
		return _task.getPrimaryKey();
	}

	/**
	* Returns the status by user ID of this task.
	*
	* @return the status by user ID of this task
	*/
	@Override
	public long getStatusByUserId() {
		return _task.getStatusByUserId();
	}

	/**
	* Returns the task ID of this task.
	*
	* @return the task ID of this task
	*/
	@Override
	public long getTaskId() {
		return _task.getTaskId();
	}

	/**
	* Returns the task user ID of this task.
	*
	* @return the task user ID of this task
	*/
	@Override
	public long getTaskUserId() {
		return _task.getTaskUserId();
	}

	/**
	* Returns the user ID of this task.
	*
	* @return the user ID of this task
	*/
	@Override
	public long getUserId() {
		return _task.getUserId();
	}

	@Override
	public void persist() {
		_task.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_task.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this task.
	*
	* @param companyId the company ID of this task
	*/
	@Override
	public void setCompanyId(long companyId) {
		_task.setCompanyId(companyId);
	}

	/**
	* Sets whether this task is completed.
	*
	* @param completed the completed of this task
	*/
	@Override
	public void setCompleted(boolean completed) {
		_task.setCompleted(completed);
	}

	/**
	* Sets the create date of this task.
	*
	* @param createDate the create date of this task
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_task.setCreateDate(createDate);
	}

	/**
	* Sets the description of this task.
	*
	* @param description the description of this task
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_task.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_task.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_task.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_task.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the expiration date of this task.
	*
	* @param expirationDate the expiration date of this task
	*/
	@Override
	public void setExpirationDate(Date expirationDate) {
		_task.setExpirationDate(expirationDate);
	}

	/**
	* Sets the group ID of this task.
	*
	* @param groupId the group ID of this task
	*/
	@Override
	public void setGroupId(long groupId) {
		_task.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this task.
	*
	* @param modifiedDate the modified date of this task
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_task.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_task.setNew(n);
	}

	/**
	* Sets the primary key of this task.
	*
	* @param primaryKey the primary key of this task
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_task.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_task.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this task.
	*
	* @param status the status of this task
	*/
	@Override
	public void setStatus(int status) {
		_task.setStatus(status);
	}

	/**
	* Sets the status by user ID of this task.
	*
	* @param statusByUserId the status by user ID of this task
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_task.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this task.
	*
	* @param statusByUserName the status by user name of this task
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_task.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this task.
	*
	* @param statusByUserUuid the status by user uuid of this task
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_task.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this task.
	*
	* @param statusDate the status date of this task
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_task.setStatusDate(statusDate);
	}

	/**
	* Sets the task ID of this task.
	*
	* @param taskId the task ID of this task
	*/
	@Override
	public void setTaskId(long taskId) {
		_task.setTaskId(taskId);
	}

	/**
	* Sets the task user ID of this task.
	*
	* @param taskUserId the task user ID of this task
	*/
	@Override
	public void setTaskUserId(long taskUserId) {
		_task.setTaskUserId(taskUserId);
	}

	/**
	* Sets the task user uuid of this task.
	*
	* @param taskUserUuid the task user uuid of this task
	*/
	@Override
	public void setTaskUserUuid(java.lang.String taskUserUuid) {
		_task.setTaskUserUuid(taskUserUuid);
	}

	/**
	* Sets the title of this task.
	*
	* @param title the title of this task
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_task.setTitle(title);
	}

	/**
	* Sets the user ID of this task.
	*
	* @param userId the user ID of this task
	*/
	@Override
	public void setUserId(long userId) {
		_task.setUserId(userId);
	}

	/**
	* Sets the user name of this task.
	*
	* @param userName the user name of this task
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_task.setUserName(userName);
	}

	/**
	* Sets the user uuid of this task.
	*
	* @param userUuid the user uuid of this task
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_task.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this task.
	*
	* @param uuid the uuid of this task
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_task.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaskWrapper)) {
			return false;
		}

		TaskWrapper taskWrapper = (TaskWrapper)obj;

		if (Objects.equals(_task, taskWrapper._task)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _task.getStagedModelType();
	}

	@Override
	public Task getWrappedModel() {
		return _task;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _task.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _task.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_task.resetOriginalValues();
	}

	private final Task _task;
}
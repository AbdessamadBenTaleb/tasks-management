<%@ include file="init.jsp" %>

<aui:button-row>
			<liferay-portlet:renderURL var="addTaskURL">
				<liferay-portlet:param name="mvcPath" value="/edit_task.jsp" />
				<liferay-portlet:param name="redirect" value="<%= currentURL %>" />
			</liferay-portlet:renderURL>

<aui:button href="<%= addTaskURL %>" icon="icon-plus" value="add-task" />
		
	</aui:button-row>
	
<liferay-ui:success key="taskAdded" message="task-added" />
<liferay-ui:success key="taskUpdated" message="task-updated" />

<liferay-ui:search-container
	delta="10"
	emptyResultsMessage="no-tasks-were-found"
	total="<%= TaskServiceUtil.getTasksCount(company.getCompanyId(), scopeGroupId) %>"
>
	<liferay-ui:search-container-results
		results="<%= TaskServiceUtil.getTasks(company.getCompanyId(), scopeGroupId, searchContainer.getStart(), searchContainer.getEnd()) %>"
	/>

	<liferay-ui:search-container-row
		className="gr.confinanz.tasks.management.model.Task"
		keyProperty="taskId"
		modelVar="task"
	>
		<liferay-ui:search-container-column-text
			cssClass="table-cell-content"
			name="title"
			value="<%= HtmlUtil.escape(task.getTitle()) %>"
		/>

		<liferay-ui:search-container-column-text
			cssClass="table-cell-content"
			name="description"
			value="<%= HtmlUtil.escape(task.getDescription()) %>"
		/>

		<liferay-ui:search-container-column-text
			name="expiration-date"
			value="<%= dateFormat.format(task.getExpirationDate()) %>"
		/>

		<liferay-ui:search-container-column-text
			name="task-user"
			value="<%= HtmlUtil.escape(task.getUserName()) %>"
		/>

		<liferay-ui:search-container-column-text
			name="completed"
			property="completed"
		/>

		<liferay-ui:search-container-column-jsp
			path="/task_action.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator markupView="lexicon" />
</liferay-ui:search-container>
<%@ include file="init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Task task = (Task)row.getObject();

long taskId = task.getTaskId();

%>


<liferay-ui:icon-menu markupView="lexicon">
	<c:if test="<%= TaskPermissionChecker.contains(permissionChecker, task, ActionKeys.UPDATE) %>">
		<liferay-portlet:renderURL var="updateTaskURL">
			<liferay-portlet:param name="mvcRenderCommandName"
				value="/tasks-management/task/edit"
			/>
			<liferay-portlet:param name="redirect" value="<%= currentURL %>" />
			<liferay-portlet:param name="taskId" value="<%= String.valueOf(taskId) %>" />
		</liferay-portlet:renderURL>

		<liferay-ui:icon message="edit" url="<%= updateTaskURL %>" />
	</c:if>

	<c:if test="<%= TaskPermissionChecker.contains(permissionChecker, task, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="gr.confinanz.tasks.management.model.Task"
			modelResourceDescription="<%= task.getTitle() %>"
			resourcePrimKey="<%= String.valueOf(taskId) %>"
			var="permissionsURL"
			windowState="<%= LiferayWindowState.POP_UP.toString() %>"
		/>

		<liferay-ui:icon
			message="permissions"
			method="get"
			url="<%= permissionsURL %>"
			useDialog="<%= true %>"
		/>
	</c:if>

	<c:if test="<%= TaskPermissionChecker.contains(permissionChecker, task, ActionKeys.DELETE) %>">
		<liferay-portlet:actionURL name="deleteTask" var="deleteTaskURL">
			<liferay-portlet:param name="redirect" value="<%= currentURL %>" />
			<liferay-portlet:param name="taskId" value="<%= String.valueOf(taskId) %>" />
		</liferay-portlet:actionURL>

		<liferay-ui:icon-delete url="<%= deleteTaskURL %>" />
	</c:if>
</liferay-ui:icon-menu>
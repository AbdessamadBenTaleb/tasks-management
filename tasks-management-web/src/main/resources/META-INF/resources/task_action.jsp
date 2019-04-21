<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ include file="init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Task task = (Task)row.getObject();

long taskId = task.getTaskId();

%>

<liferay-ui:icon-menu markupView="lexicon">
		<liferay-portlet:renderURL var="updateTaskURL">
			<liferay-portlet:param name="mvcRenderCommandName"
				value="/tasks-management/task/edit"
			/>
			<liferay-portlet:param name="redirect" value="<%= currentURL %>" />
			<liferay-portlet:param name="taskId" value="<%= String.valueOf(taskId) %>" />
		</liferay-portlet:renderURL>

		<liferay-ui:icon message="edit" url="<%= updateTaskURL %>" />


		<liferay-portlet:actionURL name="deleteTask" var="deleteTaskURL">
			<liferay-portlet:param name="redirect" value="<%= currentURL %>" />
			<liferay-portlet:param name="taskId" value="<%= String.valueOf(taskId) %>" />
		</liferay-portlet:actionURL>
		<liferay-ui:icon-delete url="<%= deleteTaskURL %>" />
		
</liferay-ui:icon-menu>
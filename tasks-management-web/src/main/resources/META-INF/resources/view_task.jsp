<%@ include file="init.jsp" %>

<%
long taskId = ParamUtil.getLong(request, "taskId");
Task task = TaskServiceUtil.getTask(taskId);
%>

<liferay-ui:header title="<%= task.getTitle() %>" />

<%= task.getDescription() %>
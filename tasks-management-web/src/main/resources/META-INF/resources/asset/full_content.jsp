
<%@ include file="../init.jsp" %>

<%
Task task = (Task)request.getAttribute(TasksManagementWebKeys.TASK);
%>

<%= task.getDescription() %>
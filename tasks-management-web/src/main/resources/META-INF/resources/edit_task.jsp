<%@ include file="init.jsp" %>

<%
Task task = (Task)request.getAttribute(TasksManagementWebKeys.TASK);
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%= task != null ? task.getTitle() : "new-task" %>'
/>

<liferay-portlet:actionURL name="updateTask" var="updateTaskURL">
	<liferay-portlet:param name="mvcPath" value="/edit_task.jsp" />
</liferay-portlet:actionURL>

<aui:form action="<%= updateTaskURL %>" method="post" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="taskId" type="hidden" value='<%= task == null ? "" : String.valueOf(task.getTaskId()) %>' />

	<aui:model-context bean="<%= task %>" model="<%= Task.class %>" />

	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset>
			<liferay-ui:error
				exception="<%= TaskTitleException.class %>"
				message="please-enter-a-valid-title"
			/>

			<aui:input name="title" />

			<aui:input name="description" />

			<aui:input name="expirationDate" />

			<aui:select label="task-user" name="taskUserId">

				<%

				// TODO: improve using server side logic

				List<User> users = UserServiceUtil.getGroupUsers(scopeGroupId);

				for (User user2 : users) {
					if (user2.isDefaultUser()) {
						continue;
					}
				%>

					<aui:option label="<%= user2.getFullName() %>" value="<%= user2.getUserId() %>" />

				<%
				}
				%>

			</aui:select>

			<aui:input name="completed" />
		</aui:fieldset>
	</aui:fieldset-group>

	<aui:button-row>
		<aui:button cssClass="btn-lg" type="submit" />

		<aui:button cssClass="btn-lg" href="<%= redirect %>" type="cancel" />
	</aui:button-row>
</aui:form>
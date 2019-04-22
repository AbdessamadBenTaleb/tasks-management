<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %><%@
taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %><%@
page import="com.liferay.portal.kernel.model.User" %><%@
page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %><%@
page import="com.liferay.portal.kernel.service.UserServiceUtil" %><%@
page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil" %><%@
page import="com.liferay.portal.kernel.util.HtmlUtil" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>


<%@page import="gr.confinanz.tasks.management.service.TaskServiceUtil"%>
<%@page import="gr.confinanz.tasks.management.model.Task"%>
<%@page import="gr.confinanz.tasks.management.exception.TaskTitleException"%>
<%@page import="gr.confinanz.tasks.management.constants.TasksManagementWebKeys"%>
<%@page import="gr.confinanz.tasks.management.service.permission.TaskPermissionChecker"%>
<%@page import="gr.confinanz.tasks.management.service.permission.TaskResourcePermissionChecker"%>
<%@page import="gr.confinanz.tasks.management.constants.ActionKeys"%>



<%@ page import="java.text.Format" %>

<%@ page import="java.util.List" %>

<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
String redirect = ParamUtil.getString(request, "redirect");
Format dateFormat = FastDateFormatFactoryUtil.getDate(locale, timeZone);
%>
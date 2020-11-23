<%@ page import="by.itClass.constants.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="main__menu">
  <nav class="menu">
    <div class="menu__list">
  <c:if test="${not empty user}">
    <a class="profile__link" href="<c:url value="<%=Constants.HOME_JSP%>"/>">Profile</a>
  </c:if>
        <a class="profile__link" href="JavaScript:sendSectionForm('today')">Today</a>
        <a class="profile__link" href="JavaScript:sendSectionForm('tomorrow')">Tomorrow</a>
        <a class="profile__link" href="JavaScript:sendSectionForm('soon')">Soon</a>
        <a class="profile__link" href="JavaScript:sendSectionForm('passed')">Passed</a>
        <a class="profile__link" href="JavaScript:sendSectionForm('all')">All</a>
    </div>
  </nav>
</div>


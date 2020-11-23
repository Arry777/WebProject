<%@ page import="by.itClass.constants.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Header</title>
<header class="header">
  <div class="header__inner">
    <div class="profile">
      <c:choose>
        <c:when test="${not empty user}">
          User:<a class="profile__link" href="<c:url value="<%=Constants.HOME_JSP%>"/>">${user.login}</a>
        </c:when>
        <c:otherwise>
          <h3>User: Guest</h3>
        </c:otherwise>
      </c:choose>
    </div>
    <div class="header__logo">Site</div>
    <div class="sing__in">
      <c:choose>
        <c:when test="${not empty user}">
          <a class="profile__link" href="<c:url value='<%=Constants.LOGOUT_CONT%>'/>">Log Out</a>
        </c:when>
        <c:otherwise>
          <a class="profile__link" href="<c:url value='<%=Constants.LOGIN_JSP%>'/>">Log In</a>
          <a class="profile__link" href="<c:url value='<%=Constants.REGISTRATION_JSP%>'/>">Registration</a>
        </c:otherwise>
      </c:choose>
    </div>
  </div>
</header>

<form id="sectionForm" method="post" action='<c:url value="/confCont"/>'>
  <input type="hidden" name="<%= Constants.SECTION_LABEL %>">
</form>


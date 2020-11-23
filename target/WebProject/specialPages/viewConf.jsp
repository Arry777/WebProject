<%@ page import="by.itClass.constants.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="table__viewconf">
  <table class="table__inner">
    <tr>
      <th>Title</th>
      <th>Description</th>
      <th>Place</th>
      <th>Date</th>
      <th></th>
    </tr>
    <c:forEach var="conference" items="${conferences}">
      <tr>
        <td>${conference.title}</td>
        <td>${conference.description}</td>
        <td>${conference.place}</td>
        <td>${conference.date}</td>
        <td><a class="table__viewconf__link" href="JavaScript:sendActionForm('view', '${conference.id}')">View</a></td>
      </tr>
    </c:forEach>
  </table>
</div>

<form id="actionForm" method="post" action='<c:url value="/actionConfCont"/>'>
</form>
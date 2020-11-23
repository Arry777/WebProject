<%@ page import="by.itClass.constants.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <link rel="stylesheet" href="css/style.css">
  <link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&family=Quicksand:wght@300&display=swap" rel="stylesheet">
  <script type="application/javascript" src="js/main.js"></script>
  <title>Conference</title>
</head>
<body>
<div class="wrapper">
  <c:import url="specialPages/header.jsp"/>
  <c:import url="specialPages/navMenu.jsp"/>
    <div class="conf__container">
      <div class="conf">
        <div class="conf__inner">
          <div class="conf__up__container">
            <div class="conf__info__container">
              <h2 class="conf__title">${conference.title}</h2>
              <h3 class="conf__item">
                <span class="name__info">Author : </span>
                <span>${conference.author}</span></h3>
              <h3 class="conf__item">
                <span class="name__info">Place : </span>
                <span>${conference.place}</span></h3>
              <h3 class="conf__item">
                <span class="name__info">Date : </span>
                <span>${conference.date}</span></h3>
              <h3 class="conf__item">
                <span class="name__info">State : </span>
                <c:if test='${conference.state == true}'>
                <span>Coming soon</span></h3>
                </c:if>
              <c:if test='${conference.state == false}'>
                <span>Finished</span></h3>
              </c:if>
              <div class="conf__desc__container">
                <div class="conf__desc">
                  <h2 class="conf__title__desc">Description</h2>
                  <p class="desc">${conference.description}</p>
                </div>
              </div>
            </div>
            <div class="events__table__container">

              <c:if test="${not empty conference.events}">
              <table class="events__table">
                  <h2 class="events__title">Events</h2>
                  <tr>
                    <th>Title</th>
                    <th>Time</th>
                  </tr>
                  <c:forEach var="event" items="${conference.events}">
                    <tr>
                      <td>${event.title}</td>
                      <td>${event.time}</td>
                    </tr>
                  </c:forEach>
              </table>
              </c:if>

            </div>
          </div>
          <div class="conf__down__container">
            <div class="conf__buttons__container">
              <div class="conf__buttons">
                <c:choose>
                  <c:when test="${not empty user}">
                    <a class="conf__link" href='<c:url value="<%= Constants.HOME_JSP %>"/>'>Back Profile</a>
                  </c:when>
                  <c:otherwise>
                    <a class="conf__link" href='<c:url value="<%= Constants.INDEX_JSP %>"/>'>Back</a>
                  </c:otherwise>
                </c:choose>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
</div>
</body>
</html>

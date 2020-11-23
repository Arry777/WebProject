<%@ page import="by.itClass.constants.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&family=Quicksand:wght@300&display=swap" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="css/style.css">
  <script type="application/javascript" src="js/main.js"></script>
    <title>Home</title>
</head>
<body>
<div class="wrapper">
  <c:import url="specialPages/header.jsp"/>
  <c:import url="specialPages/navMenu.jsp"/>
  <div class="container">
    <div class="home">
      <div class="home__inner">
        <div class="home__up">
          <div class="photo__cont">
            <div class="home__photo" data-title="Edit photo">
              <img class="img" src="css/images/profile.png" alt="profilePhoto">
            </div>
          </div>
          <div class="home__info__block">
            <h3 class="home__info">Nickname: ${user.login}</h3>
            <h3 class="home__info">Username: ${user.name}</h3>
            <h3 class="home__info">Surname: ${user.surname}</h3>
            <h3 class="home__info">Age: ${user.age}</h3>
            <h3 class="home__info">Email: ${user.email}</h3>
            <h3 class="home__info">Phone: ${user.phone}</h3>
          </div>
        </div>
        <div class="home__down">
          <div class="home__links">
            <ul class="user__actions">
              <li class="action">
                <a class="conf__link" href="<c:url value="/newConference.jsp"/>">Create Conference</a>
              </li>
              <li class="action">
                <a class="conf__link" href="Javascript:sendSectionForm('home')">My conferences</a>
              </li>
              <li class="action">
                <a class="conf__link" href="Javascript:sendActionForm('delete', '${conference.id}')">Delete conferences</a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
  <c:if test="${not empty conferences}">
    <c:import url="specialPages/viewUserConf.jsp"/>
  </c:if>
</div>
</body>
</html>
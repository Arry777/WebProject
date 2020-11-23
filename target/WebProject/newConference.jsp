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
  <div class="conf__container">
    <div class="conf">
      <div  class="conf__inner new__conf__inner">
        <h2 class="login__title newconf__title">New conference</h2>
        <form id="newConfForm" method="post" action="<c:url value="<%= Constants.CREATE_CONFERENCE_CONT%>"/>" autocomplete="off">

          <div class="login__field">
            <input class="login__input" autocomplete="off" type="text" name="<%= Constants.CONF_TITLE_LABEL%>" placeholder="Title"> <br>
          </div>

          <div class="login__field">
            <input class="login__input" autocomplete="off" type="text" name="<%= Constants.DESCRIPTION_LABEL%>" placeholder="Description"> <br>
          </div>

          <div class="login__field">
            <input class="login__input" autocomplete="off" type="text" name="<%= Constants.PLACE_LABEL%>" placeholder="Place"> <br>
          </div>

          <div class="login__field">
            <input class="login__input" autocomplete="off" type="date" name="<%= Constants.DATE_LABEL%>"> <br>
          </div>
        </form>
          <div class="new__conf__links">
            <div class="new__conf__links__event">
              <a class="conf__link" href="#" onclick="JavaScript:addEvent()">Add event</a>
              <a class="conf__link" href="#" onclick="JavaScript:removeEvent()">Remove event</a>
            </div>
            <div class="new__conf__links__main">
              <input class="conf__link" autocomplete="off" form="newConfForm" type="submit" value="Create">
              <a class="conf__link" href='<c:url value="<%=Constants.HOME_JSP%>"/>'>Back</a>
            </div>
          </div>

      </div>
    </div>
  </div>
</div>
</body>
</html>
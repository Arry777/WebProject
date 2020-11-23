<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="by.itClass.constants.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&family=Quicksand:wght@300&display=swap" rel="stylesheet">
    <script type="application/javascript" src="js/main.js"></script>
</head>
<body>
  <div class="wrapper">
    <c:import url="specialPages/header.jsp"/>
    <c:import url="specialPages/navMenu.jsp"/>
    <div class="container">
      <div class="login">
        <div class="login__inner">
          <h1 class="login__title">Login</h1>
          <h2 class="login__subtitle">Please, fill in the form below:</h2>
          <form method="post" action='<c:url value="/loginCont"/>'>
            <div class="login__fields">
              <div class="login__field">
                <input class="login__input" name="<%= Constants.LOGIN_LABEL%>" type="text" autocomplete="off"
                       placeholder="Login"/><br>
              </div>
              <div class="login__field">
                <input class="login__input" name="<%= Constants.PASSWORD_LABEL%>" type="password" autocomplete="off"
                       placeholder="Password"/>
              </div>
            </div>
            <div class="login__links">
              <button class="login__link" type="submit" >Log In</button>
              <a class="login__link" type="submit" href="<c:url value="/index.jsp"/>">Back</a>
            </div>
            <c:import url="specialPages/message.jsp"/>
          </form>
        </div>
      </div>
    </div>
  </div>
</body>
</html>
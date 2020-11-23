<%@ page import="by.itClass.constants.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <title>Registration</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
  <link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&family=Quicksand:wght@300&display=swap" rel="stylesheet">
  <script type="application/javascript" src="js/main.js"></script>
</head>
<body>
  <div class="wrapper">
    <c:import url="specialPages/header.jsp"/>
    <c:import url="specialPages/navMenu.jsp"/>
    <div class="container">
      <div class="registration">
        <div class="registration__inner">
          <h1 class="registration__title">Registration</h1>
          <h2 class="registration__subtitle">Please, fill in the form below:</h2>
          <form method="post" action='<c:url value= "<%= Constants.REGISTRATION_CONT%>"/>'>
            <div class="registration__field">
              <input class="registration__input" type="text" name= '<%= Constants.NAME_LABEL%>' autocomplete="off" placeholder="Name"/> <br>
            </div>
            <div class="registration__field">
              <input class="registration__input" type="text" name= '<%= Constants.SURNAME_LABEL%>' autocomplete="off" placeholder="Surname"/> <br>
            </div>
            <div class="registration__field">
              <input class="registration__input" type="text" name= '<%= Constants.AGE_LABEL%>' autocomplete="off" placeholder="Age"/><br>
            </div>
            <div class="registration__field">
              <input class="registration__input" type="text" name= '<%= Constants.LOGIN_LABEL%>' autocomplete="off" placeholder="Login"/> <br>
            </div>
            <div class="registration__field">
              <input class="registration__input" type="password" name= '<%= Constants.PASSWORD_LABEL%>' autocomplete="off" placeholder="Password"/> <br>
            </div>
            <div class="registration__field">
              <input class="registration__input" type="email" name= '<%= Constants.EMAIL_LABEL%>' autocomplete="off" placeholder="Email"/> <br>
            </div>
            <div class="registration__field">
              <input class="registration__input" type="text" name= '<%= Constants.PHONE_LABEL%>' autocomplete="off" placeholder="Phone"/> <br>
            </div>
            <div class="registration__links">
              <button class="registration__link" type="submit">Registration</button>
              <a class="registration__link" href="index.jsp">Back</a>
            </div>
            <c:import url="specialPages/message.jsp"/>
          </form>
        </div>
      </div>
    </div>
  </div>
</body>
</html>

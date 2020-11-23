<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <title>Start page</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
  <link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&family=Quicksand:wght@300&display=swap" rel="stylesheet">
  <script type="application/javascript" src="js/main.js"></script>
</head>
<body>
  <div class="wrapper">
    <c:import url="specialPages/header.jsp"/>
    <c:import url="specialPages/navMenu.jsp"/>
    <c:if test="${not empty conferences}">
      <c:import url="specialPages/viewConf.jsp"/>
    </c:if>
  </div>
</body>
</html>



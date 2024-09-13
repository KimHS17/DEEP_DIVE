<%--
  Created by IntelliJ IDEA.
  User: hwansu
  Date: 9/5/24
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h1>퀴즈 결과</h1>
<h2>당신의 점수 : ${score}</h2>
<form action="/restart" method="post">
  <button type="submit">재시작</button>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: hwansu
  Date: 9/5/24
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Quiz</title>
</head>
<body>
  <h1>Quiz</h1>
  <h2>현재 문제 : ${id}</h2>
  <h2>점수 : ${score}</h2>
    <p>문제 : ${quiz}</p>
    <form action="/quiz" method="post">
        정답 : <input type="text" name="answer"><br>
        <button type="submit">제출</button>
    </form>
</body>
</html>

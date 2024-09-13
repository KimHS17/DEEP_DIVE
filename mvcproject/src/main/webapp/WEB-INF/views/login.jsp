<%--
  Created by IntelliJ IDEA.
  User: hwansu
  Date: 9/3/24
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
  <form action="/user/login" method="post">
    이메일 : <input type="text" name="email" /><br>
    비밀번호 : <input type="password" name="password"/><br>
    <button type="submit">로그인</button>
  </form>
  <h2>${message}</h2>
</body>
</html>

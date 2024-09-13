<%--
  Created by IntelliJ IDEA.
  User: hwansu
  Date: 9/3/24
  Time: 2:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
  <form:form modelAttribute="login">
    이메일 : <form:input path="email" /><br>
    비밀번호 : <form:password path="password" /><br>
    <input type="submit" value="로그인" />
  </form:form>
</body>
</html>

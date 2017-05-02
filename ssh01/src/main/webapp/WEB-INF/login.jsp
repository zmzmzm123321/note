<%--
  Created by IntelliJ IDEA.
  User: TM
  Date: 2017-4-23
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Login</title>
</head>
<body>
<c:url var "url" value="/message/login.action"/>
<form action="${url}" method="post" >
    <div>用户：<input name="username" type="text"></div>
    <div>密码：<input name="password" type="password"></div>
    <div><input type="submit" value="登录"></div>
</form>
</body>
</html>
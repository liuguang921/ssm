<%--
  Created by IntelliJ IDEA.
  User: gg176
  Date: 2019/12/1
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<h1>用户注册</h1>
<form action="${pageContext.request.contextPath}/register" method="post">
    帐号：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit" value="确定">
    <input type="reset" value="重置">
    <a href="login.jsp">返回登录</a>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: gg176
  Date: 2019/11/26
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/book/upload" method="post" enctype="multipart/form-data">
    上传文件：<input type="file" name="file">
    <button type="submit">上传</button>
</form>
</body>
</html>

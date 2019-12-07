<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/guang"  prefix="z"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>书籍</title>
</head>
<body>
<h2>书籍</h2>
<br>
<form action="${pageContext.request.contextPath}/book/list" method="post">
	<!--用户设置查询 一页20条记录  -->
	<!-- 	<input type="hidden" name="rows" value="20"/> -->
	<!--用户设置不分页  -->
	<!-- <input type="hidden" name="pagination" value="false"/> -->
	书名：<input type="text" name="bname"> <input type="submit"
											   value="确定">
</form>
<a href="${pageContext.request.contextPath}/book/preSave">增加</a>
<table border="1" width="100%">
	<tr>
		<td>编号</td>
		<td>名称</td>
		<td>价格</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${bookList}" var="b">
		<tr>
			<td>${b.bid }</td>
			<td>${b.bname }</td>
			<td>${b.price }</td>
			<td>
				<a href="${pageContext.request.contextPath}/book/preSave?bid=${b.bid}">修改</a>
				<a href="${pageContext.request.contextPath}/book/del/${b.bid}">删除</a>
			</td>
		</tr>
	</c:forEach>
</table>
<z:page pageBean="${pagebean}"></z:page>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
	<li><a href="${root}/admin/register.do">상품 등록</a></li>
	<li><a href="${root}/admin/list.do">상품 목록</a></li>
	<li><a href="">상품 소감</a></li>
	<li><a href="">유저 목록</a></li>
</ul>
</body>
</html>
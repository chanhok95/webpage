<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
	<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
	<a href="${root }/member/login.do">로그인</a>&nbsp;&nbsp;
	<a href="${root }/member/register.do">회원가입</a>&nbsp;&nbsp;
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>날짜를 문자열로 반환(Format)</h3>
	<%-- Date date=new Date(); --%>
	<jsp:useBean id="date" class="java.util.Date"></jsp:useBean>
	<c:set var="today" value="${date}" />
	<c:out value="${today}" />
	
	날짜:<fmt:formatDate value="${date}" type="date"/>
	<br/><br/>
	시간:<fmt:formatDate value="${date}" type="time"/>
	<br/><br/>
	날짜+시간:<fmt:formatDate value="${date}" type="both"/>
	<br/><br/>
	
	패턴:<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
	<br/><br/>
	
	<h3>문자열을 날짜로 반환</h3>
	<c:set var="myBirthDay" value="1980-12-25 00:00:10"/>
	<fmt:parseDate var="now" value="${myBirthDay}" pattern="yyyy-MM-dd HH:mm:ss" />
	날짜:<fmt:formatDate value="${now}" type="date" />
	
</body>
</html>
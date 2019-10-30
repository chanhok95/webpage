<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>import: 웹 어플리케이션 내부의 자원과 외부자원(HTTP,FTP)도 가져온다.</h3>
	
	내부자원:<c:import url="core01.jsp" /> <br/>
	
	외부자원:<c:import url="https://www.naver.com" /><br/> 
	<%--파싱 외부 라이브러리를 가지고올때 보통 구글같은경우는 방화벽없이 open되서 저장이되지만 
	그외 기상청 같은경우는 방화벽 때문에 proxiy작업을 해줘야됨 --%>
</body>
</html>
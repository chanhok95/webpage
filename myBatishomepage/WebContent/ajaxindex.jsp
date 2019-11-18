<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>사원리스트 -hr 계정(UNPOOL설정)</h3>
	<a href="${root }/sawon/list.do">사원리스트</a>
	<br/><br/><br/><br/>
	
	<h3>실시간 댓글</h3>
	<a href="${root }/reply/replyList.do">실시간 한줄 댓글</a>
		<br/><br/><br/><br/>
	
	<h3>JSON</h3>
	<a href="${root }/json.do?msg=obj">JSON - OBJECT</a>&nbsp;&nbsp;
	<a href="${root }/json.do?msg=array">JSON - Array</a>&nbsp;&nbsp;
	<a href="${root }/json.do?msg=objArray">JSON - ObjArray</a>
	
	<h3>parsing</h3>
	<a href="${root }/parsing.do">기상청</a>
</body>
</html>
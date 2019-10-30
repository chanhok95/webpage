<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>	<%--%@페이지 지시어 --%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JAVA(JSP) Standard Tag Library</title>
</head>
<body>
	<h3>출력</h3>
	<div>
		<c:out value="JSTL 연습입니다" />
		<br/>
		<c:out value="10" />
	</div>
	
	<h3>변수 선언</h3>
	<div>
	<%--page 생략가능 request,session application --%>
	
	<c:set var="name" value="길찬호" scope ="page" />
	<c:set var="age" value="25" />
	
	<%--이렇게는 값이 안뽑힘 --%>
	<c:out value="name" /> <br/>
	<c:out value="age" /> <br/>
	
	<%--EL(Expression Language --%>
	<c:out value="${name}" /> <br/>						<%-- ${오로지연산} EL --%>
	<c:out value="${age}" /> <br/>
	<c:out value="${age+10}" /> <br/>
	<c:out value="${age>10}" /> <br/>
	</div>
	
	<%--EL은 출력기능도있는데 c:out도 사용가능 --%>
	<h3>${age},${name}</h3>
	
	<h3>변수 제거</h3>
	<c:remove var="name"/>
	이름:<c:out value="${name}" /> <%--EL은 NULL ERROR를 발생시키지 않는다. --%>
	<br/><br/>
	
	<h3>if</h3>
	<c:set var="fruit" value="apple" />		<%-- fruit 변수선언  키,값  --%>
	<c:if test="${fruit == 'apple' }" >
	<c:out value="사과 입니다." />
	</c:if>
	<c:if test="${fruit !='apple' }" >
	<c:out value="사과가 아닙니다" />
	</c:if>
	
	<h3>if ~ else</h3>
	<c:choose>
	<c:when test="${fruit=='apple' }">	<%--choose ~ when --%>
		${"사과입니다"}
	</c:when>
	
	<c:when test="${friut=='banana'}">
		${"바나나입니다. "}
	</c:when>
	
	<c:when test="${fruit=='orange'}">
		${"오렌지 입니다." }
	</c:when>
	
	<c:otherwise>기타등등</c:otherwise>
	</c:choose>
</body>
</html>
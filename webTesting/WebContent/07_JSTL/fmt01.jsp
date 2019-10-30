<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- 데이터 숫자(정,실),문자열(문자) / 날짜 (Date,date) --%>
	<h3>문자열을 숫자로 변환</h3>
	<c:set var="suStr" value="${'100'}" /> <%-- 이렇게 쓰일 일은 없지만 이해를돕기위해 --%>
	<c:out value="${suStr}" />
	
	<fmt:parseNumber var="pNum" value="${suStr}" />
	<c:out value="${suStr}" />
	
	<fmt:parseNumber var="su" value="55.7" integerOnly="true" />
	<c:out value="${su}" />
	
	<c:set var="a" value="55.5" />
	<c:set var="b" value="55.7" />
	<c:set var="r" value="${a+b}" />
	<fmt:parseNumber var="pr" value="${r}" integerOnly="true" />
	
	<h3>숫자 패턴</h3>
	<c:set var="num" value="12345" />
	<fmt:formatNumber value="${num}" type="number" /> <%-- format 패턴변경 3자리씩 콤마 --%>
	<br/><br/>
	<fmt:formatNumber value="${num}" type="currency" /> <%-- format  ￦표시--%>
	<br/><br/>
	<fmt:formatNumber value="${num}" type="currency" currencySymbol="$" /> <%-- format $표시 --%>
	<br/><br/>
	<fmt:formatNumber value="${num}" type="percent" /> <%-- format % --%>
	<br/><br/>
	<fmt:formatNumber value="${num}" pattern="0.000"  /> 
	<br/><br/>
	
	
	<c:set var="fnum" value="12345.789" />
	<fmt:formatNumber value="${fnum}" pattern="0.00" /> <%--format형태 --%>
	<br/><br/>
	<fmt:formatNumber value="${fnum}" pattern="0.0000" /> 
	<br/><br/>
	<fmt:formatNumber value="${fnum}" pattern="#.##" />	 <%-- #하고 0의 차이  뒤의 0이 채워지는지 --%>
	<br/><br/>
	<fmt:formatNumber value="${fnum}" pattern="#.####" />
	<br/><br/>
	<fmt:formatNumber value="${fnum}" pattern="#,##,##,##" />
	<br/><br/>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 예제입니다.</title>
</head>
<body>
	<h3>for문</h3>

	<c:forEach var="i" begin="1" end="10" step="2"> <%-- var변수 begin시작 end끝 step 2씩증가 --%>
		<c:out value="${i}" />
	</c:forEach>
	<br />
	
	<c:forEach var="j" begin="1" end="10">
		<c:if test="${j%2==0}">
			<c:out value="${j}" />
		</c:if>
	</c:forEach>
	<br/>
	<%--
		ArrayList<String> arrayList = new ArrayList<String>();
		데이터가 들어가있는 가정
		arrList.add("사과");
		.
		.
		.
		for(int i=0; i<arrList.size(); i++){
			String str =(String)arrList.get(i);
			system.out.println(str)
		 	}
		 	
		 <c:forEach var="str" items="${arrList}"      var=str에 arrList에 0번지부터 5번지의값이 들어가있다고 가정하에 마지막값까지 돌고 끝남> 
		 	<c:out var = "${str}" />
		 </c:forEach>	
	 --%>
	 
	 <h3>forTokens</h3>
	 <c:set var="city" value="서울,인천,대구,부산,광주,제주도" />
	 <c:forTokens var="data" items="${city}" delims=",">
	 	<c:out value="${data}" />
	 </c:forTokens>
	<br/><br/>
	<c:set var="traffic" value="비행기,자동차,승합차 | 자전거.오토바이" />
	<c:forTokens var="data" items="${traffic}" delims=",|.">
		<c:out value="${data}" />
	</c:forTokens>
</body>
</html>
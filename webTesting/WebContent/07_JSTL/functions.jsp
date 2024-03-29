<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="str1" value="Funtion태그를 사용합니다." />
	<c:set var="str2" value="사용" />
	<c:set var="str3" value="1,2,3,4,5,6,7,8,9,10" />
	<div>
		str1:<c:out value="${str1 }" /><br/>
		str2:<c:out value="${str2 }" /><br/>
		str3:<c:out value="${str3 }" /><br/>
	</div>


	<div>
	문자열 길이 : ${fn:length(str1) }<br/>	
	대문자 : ${fn:toUpperCase(str1) }<br/>
	소문자 : ${fn:toLowerCase(str1) }<br/>
	문자열 추출 : ${fn:substring(str1,3,6) }<br/>
	문자열 치환 : ${fn:replace(str1," ","-") }<br/>
	문자열 위치 : ${fn:indexOf(str1,"t") }<br/>
	
	문자열 1에서 문자열 2에 포함되어 있는 문자열 이후 : ${fn:substringAfter(str1,str2) } <br/>
	문자열 1에서 문자열 2에 포함되어 있는 문자열 이전 : ${fn:substringBefore(str1,str2) } <br/>
	시작 문자열 :${fn:startsWith(str1,'Fun') }<br/>
	시작 문자열 :${fn:startsWith(str1,'abc') }<br/>
	끝 문자열 :${fn:endsWith(str1,'사용합니다.') }<br/>
	문자열1에 문자열2가 포함되면 참  :${fn:contains(str1,str2) }<br/>
	문자열1에 문자열2가 포함되면 참(대소문자 구분안함)  :${fn:containsIgnoreCase(str1,str2) }<br/>
	
	문자열 분리해서 배열로 반환
	<c:set var="array" value="${fn:split(str3,',')}" />
	
	<c:forEach var="i" items="${array }"  >
	<c:out value="${i }" />
	</c:forEach>
	<br/>
	
	문자열 합치기 : join(array,"*") : ${fn:join(array,"*") } <br/>
	</div>



</body>
</html>
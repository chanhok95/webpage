	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴 페이지</title>
</head>
<body>
<c:set var="root" value="${pageContext.request.contextPath}" /> 
	
	<c:if test="${check > 0 }">
	<c:remove var="id" scope="session" />
	<c:remove var="memberLevel" scope="session"/>
		<script type="text/javascript">
		alert("탈퇴되었습니다");
		location.href="${root}/member/main.do";
		</script>
	</c:if>

	<c:if test="${check == 0 }">
		<script type="text/javascript">
		alert("탈퇴되지 않았습니다. 다시 시도해주세요");
		location.href="${root}/member/delete.do";
		</script>
	</c:if>

</body>
</html>
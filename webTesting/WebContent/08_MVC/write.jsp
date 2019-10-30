<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>write page</h3>
	
	<c:out value="${checl }"/>
	
	<%-- <c:if test="${check > 0 } ">
		<script type="text/javascript">
			alert("글작성이 되었습니다");
			//location.href="url.jsp";
		</script>
	</c:if> --%>
	
	<c:if test="${check==0 }">
		<script type="text/javascript">
			alert("글작성이 되지 않았습니다");
		</script>
	</c:if>
</body>
</html>
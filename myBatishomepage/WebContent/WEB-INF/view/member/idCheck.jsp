<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}" /> <!-- 현재페이지경로  -->
<html>
<head>
<meta charset="UTF-8">
<title>idCheck</title>
</head>
<body>
	<%-- <h3>${check },${id }</h3> --%>
	<c:if test="${check > 0 }">
		<div align="center">
			이미사용중인아이디입니다

			<form action="${root }/member/idCheck.do" method="post">
				<input type="text" name="id" /> 
				<input type="submit" value="확인" />
			</form>
		</div>
	</c:if>
	<c:if test="${check==0 }">
		<div align="center">
		사용가능한 아이디 입니다.
		<br/><br/><br/>
		</div>
	</c:if>
<script type="text/javascript">
	opener.creatForm.id.value ="${id}";
	</script>
<div align="center">
	<a href="javascript:self.close()">닫기</a>
</div>
</body>
</html>





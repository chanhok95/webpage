<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${root}/css/guest/write.css" rel="stylesheet" />
</head>
<body>
	<div align="center" style="margin: 100px auto;">
	<form class="form" action="${root}/guest/updateOk.do" method="get">
		<input type="hidden" name="num" value="${guestDto.num}">
		<input type="hidden" name="pageNumber" value="${pageNumber}">
				<div class="title">
					<span>이름</span>
					<input type="text" name="irum" size="12" value="${guestDto.name}" disabled="disabled" />
					<span style="margin-left: 50px;">비밀번호</span> 
					<input type="password" name="pwd" size="12" value="${guestDto.password}" />
				</div>
				<div class="content">
					<textarea rows="5" cols="53" name="message" >${guestDto.message}</textarea>
				</div>
				<div class="title" style="text-align: right;">
					<input type="submit" value="수정"> <input type="reset" value="취소">
				</div>
			
			</form>
			</div>
</body>
</html>
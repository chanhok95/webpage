<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${root}/css/board/style.css" rel="stylesheet">
<script type="text/javascript" src="${root }/javascript/board/write.js"></script>
</head>
<body>
	<h3>boardNumber : ${boardNumber }, groupNumber : ${groupNumber },
		sequenceNumber : ${sequenceNumber }, sequenceLevel : ${sequenceLevel }
	</h3>
	<div align="center">글쓰기</div>
	<div align="center" style="margin: 0px 0px 0px 450px;">
		<a href="${root }/fileboard/list.do">글목록</a>
	</div>
	<div class="content" style="height: 450px;">
		<form method="post" action="${root }/fileboard/updateOk.do"
			onsubmit="return boardForm(this)"
			enctype="multipart/form-data"
			>

				<input type="hidden" name="boardNumber"value="${boardDto.boardNumber}" /> 
				<input type="hidden"name="groupNumber" value="${boardDto.groupNumber}" /> 
				<input type="hidden" name="sequenceNumber"value="${boardDto.sequenceNumber}" /> 
				<input type="hidden"name="sequenceLevel" value="${boardDto.sequenceLevel}" />

			<div class="sub">작성자</div>
			<div class="type">
				<input type="text" name="writer" value="${boardDto.writer}"
					disabled="disabled">
			</div>
			<div class="sub">제목</div>
			<div class="type">
				<input type="text" size="50" name="subject"
					value="${boardDto.subject}">
			</div>
			<div class="sub">이메일</div>
			<div class="type">
				<input type="text" size="50" name="email" value="${boardDto.email}">
			</div>
			<div class="sub">내용</div>
			<div class="type" style="border-bottom: 0px;">
				<textarea rows="13" cols="50" name="content">${boardDto.content}</textarea>
			</div>
			<div class="sub"
				style="border-bottom: 0px; border-right: solid 2px; height: 33px;">비밀번호</div>
			<div class="type"
				style="border-top: solid 2px black; margin: 0px 0px 0px 0px; border-left: 0px;">
				<input type="password" name="password" value="${boardDto.password}"
					disabled="disabled">
			</div>
			
			<c:if test="${boardDto.filename != null}">
				
					<div class="sub" >파일명</div>	${boardDto.filename}
					<div class="type">
						<input type="file" name="file" size="40">
					</div>
			</c:if>

			<c:if test="${boardDto.filename == null}">
					<div class="sub">파일명</div>
					<div class="type">
						<input type="file" name="file" size="40">
					</div>	
			</c:if>

			<div align="center">
				<input type="submit" value="수정하기"> <input type="reset"
					value="다시작성"> <input type="button" value="목록보기"
					onclick="location.href='${root}/fileboard/list.do'" />
			</div>
		</form>
	</div>
</body>
</html>
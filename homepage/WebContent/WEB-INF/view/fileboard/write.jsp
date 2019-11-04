<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
<link href="${root}/css/board/style.css" rel="stylesheet">
<script type="text/javascript" src="${root }/javascript/board/write.js"></script>
</head>
<body>
	<h3>
	boardNumber  :   ${boardNumber },
	groupNumber :  ${groupNumber },
	sequenceNumber :   ${sequenceNumber },
	sequenceLevel  :  ${sequenceLevel }
	</h3>
	<div align="center">글쓰기</div>
	<div align="center" style="margin: 0px 0px 0px 450px;"><a href="${root }/fileboard/list.do">글목록</a></div>
	<div class="content" style="height: 420px;">
		
		<form method="post"	action ="${root}/fileboard/writeOk.do" onsubmit="return boardForm(this)"
			enctype="multipart/form-data">				<%-- application/x-www-form-urlkencoded: 텍스트 전송(기본값(디폴트) , 생략가능) --%>
		
		<input type="hidden" name="boardNumber" value="${boardNumber}" />
		<input type="hidden" name="groupNumber" value="${groupNumber}" />
		<input type="hidden" name="sequenceNumber" value="${sequenceNumber}" />
		<input type="hidden" name="sequenceLevel" value="${sequenceLevel}" />
		
			<div class="sub">작성자</div>
			<div class="type">
				<input type="text" name="writer">
			</div >
			<div class="sub">제목</div>
			<div class="type">
				<input type="text" size="50" name="subject">
			</div>
			<div class="sub">이메일</div>
			<div class="type">
				<input type="text" size="50" name="email">
			</div>
			<div class="sub">내용</div>
			<div class="type" style="border-bottom: 0px;">
				<textarea rows="13" cols="50" name="content"></textarea>
			</div>
			<div class="sub" style="border-bottom: 0px; border-right: solid 2px; height: 33px;"  >비밀번호</div>
			<div class="type" style="border-top: solid 2px black; margin: 0px 0px 0px 0px; border-left: 0px;">
				<input type="password" name="password">
			</div>
			<div class="sub" style="border-bottom: 0px; border-right: solid 2px; height: 33px;"  >파일명</div>
			<div class="type" style="border-top: solid 0px black; margin: 0px 0px 0px 0px; border-left: 0px;">
				<input type="file" name="file">
			</div>
			<div align="center">
				<input type="submit" value="글쓰기"> <input type="reset"
					value="다시작성"> <input type="button" value="목록보기"
					onclick="location.href='${root}/fileboard/list.do'" />
			</div>
		</form>
	</div>
</body>
</html>
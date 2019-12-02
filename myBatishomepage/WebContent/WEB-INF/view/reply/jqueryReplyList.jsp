<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${root }/css/reply/reply.css">
<script type="text/javascript" src="${root }/xhr/jquery-3.4.1.js"></script>
<script type="text/javascript" src="${root }/javascript/jqueryReply/replyWrite.js"></script>
<script type="text/javascript" src="${root }/javascript/jqueryReply/replyDelete.js"></script>
<script type="text/javascript" src="${root }/javascript/jqueryReply/replyUpdate.js"></script>
</head>
<body>

	<!-- 새로운 댓글 -->
	<div>한줄 댓글이 가능합니다.</div>
	
	<div>
		<input type="text" name="value" id="writeReply" size="45" />
		<input type="button" value="한줄답글 작성" onclick="writeToServer('${root}')" /> <!-- onclick="writeToServer('${root}')" js에서 root값 던져줌 js에서 ${root} 안되서  -->
	</div>
	<div id="listAllDiv"></div>
	
		
	<!-- 기존 댓글 -->
	<c:forEach var="replyDto" items="${replyList}">
		<div class="replyDiv" id="${replyDto.bunho }">
			<span class="cssBunho">${replyDto.bunho}</span>
			<span class="cssReply">${replyDto.line_reply}</span>
			<span class="cssUpDel">
				<a href="javascript:deleteToServer('${replyDto.bunho}','${root}')">삭제</a>&nbsp;
				<a href="javascript:UpdateToServer('${replyDto.bunho}','${root}')">수정</a>
			</span>
		</div>
	</c:forEach>
</body>
</html>
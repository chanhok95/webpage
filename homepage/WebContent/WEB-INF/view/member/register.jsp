<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
	<c:set var="root" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="${root }/css/member/register.css" />  <!--${root }  -->
<script type="text/javascript" src="${root }/javascript/member/register.js"></script>
</head>
<body>
	<jsp:include page="../../../index.jsp" />
	<br/><br/>
	<h3>${root }</h3>
	<div align="center">회원가입 (*필수 입력사항 입니다.)</div>
	<div class="content">
		<form action="${root}/member/registerOk.do" method="post" onsubmit="return registerForm(this)" name="creatForm">
			<div class="sub">아이디</div>
			<div class="type">
				*<input type="text" name="id"> <input type="button" value="아이디중복" onclick="idCheck(creatForm,'${root}')">
			</div>
			<div class="sub" >비밀번호</div>
			<div class="type">
				*<input type="password" name="password">
			</div>
			<div class="sub">비밀번호확인</div>
			<div class="type">
				*<input type="password" name="passwordCheck">
			</div>
			<div class="sub">이름</div>
			<div class="type">
				*<input type="text" name="name">
			</div>
			<div class="sub">주민번호</div>
			<div class="type">
				*<input type="tel" name="jumin1">-<input type="password" name="jumin2">
			</div>
			<div class="sub">이메일</div>
			<div class="type">
				<input type="text" style="margin-left: 5px;" name="email">  
			</div>
			<div class="sub">우편번호</div>
			<div class="type"><input type="text" name="zipcode"  placeholder="우편번호" style="margin-left: 5px;"> <input type="button" value="우편번호검색" onclick="zipcodeRead('${root}')">
			</div>
			<div class="sub" >주소</div>
			<div class="type">
				<input type="text" size="40" style="margin-left: 5px;" name="address">
			</div>
			<div class="sub">직업</div>
			<div class="type">
				<select style="margin-left: 5px;" name="job">
				<option>&nbsp;&nbsp;</option>
				<option>변호사</option>
				<option>약사</option>
				</select>
			</div>
			<div class="sub">메일수신</div>
			<div class="type">
				<input type="radio" name="mailing" value="yes">yes<input type="radio" name="mailing" value="no">no
			</div>
			<div class="sub">관심분야</div>
			<div class="type">
				<input type="checkbox" name="interestValue" value="경제"> 경제 <input type="checkbox" name="interestValue" value="IT">
				IT <input type="checkbox" name="interestValue" value="음악"> 음악 <input type="checkbox" name="interestValue" value="미술">
				미술 <input type="hidden" name="interest" />
			</div>
			<div align="center" ><input type="submit" value="가입"><input type="reset" value="취소" style="margin-left: 5px;"> </div>
		</form>
	</div>
</body>
</html>
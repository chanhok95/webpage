<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${root }/css/member/register.css">
<script type="text/javascript" src="${root }/javascript/member/register.js"></script>
</head>
<body style="font-size: 12px; background-color: #f5f6f7">
	<div align="center" style="margin-right: 50px;">
		<img alt="" src="../images/Tulips.jpg" width="300px" height="100px">
	</div>
	<div class="content">
		<form action="${root}/member/registerOk.do" method="post" onsubmit="return registerForm(this)"
		name="creatForm">
			<div class="title">아이디 </div>
			<div class="ps_box">
				<input type="text" name="id" maxlength="10">
				<input type="button" value="ID중복체크" onclick="idCheck(creatForm,'${root}')" style="width: 90px;">
			</div>
			
			
			<div class="title">비밀번호</div>
			<div class="ps_box">
				<input type="password" name="password" maxlength="10">
			</div>
			<div class="title">비밀번호 재확인</div>
			<div class="ps_box">
				<input type="password" name="passwordCheck">
			</div>
			<div class="title">이름</div>
			<div class="ps_box">
				<input type="text" name="name">
			</div>
			<div class="title">생년월일</div>


			<div class="ps_box">
				<input type="tel" style="width: 182px;" placeholder="년(4자)"
					maxlength="4" name="born"> <select name="month">
					<option value="none">월</option>
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
					<option>6</option>
					<option>7</option>
					<option>8</option>
					<option>9</option>
					<option>10</option>
					<option>11</option>
					<option>12</option>
				</select> <input type="tel" style="width: 182px; padding-left: 10px;"
					placeholder="일자)" maxlength="2" name="year">
			</div>

			<div class="title">성별</div>
			<div class="ps_box">
				<select style="width: 430px; height: 29px;" name="gender">
					<option value="nonee">성별</option>
					<option>남자</option>
					<option>여자</option>
				</select>
			</div>
			<div class="title">본인 확인 이메일(선택)</div>
			<div class="ps_box">
				<input type="text" name="email">
			</div>
			<!-- 휴대전화제외 -->
			<div class="ps_box"
				style="margin-top: 15px; text-align: center; background-color: green;">
				<input type="submit" value="가입하기"
					style="background-color: green; color: white;">
			</div>
			<div style="margin-top: 15px;">이용약관 | 개인정보처리방침 | 책임의 한계와 법적고지 |
				회원정보 관리센터</div>
			<div align="center">chanho</div>
		</form>
	</div>
</body>
</html>
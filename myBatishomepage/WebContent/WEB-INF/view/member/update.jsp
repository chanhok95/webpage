<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
	<c:set var="root" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="UTF-8">
<title>회원수정</title>
<link rel="stylesheet" href="${root }/css/member/register.css" />  <!--${root }  -->
<script type="text/javascript" src="${root }/javascript/member/register.js"></script>
</head>
<body>
	<jsp:include page="../../../index.jsp" />
	<br/><br/>
	<h3>${root }</h3>
	<div align="center">회원수정</div>
	<div class="content">
		<form action="${root}/member/updateOk.do" method="post" onsubmit="return registerForm(this)" name="creatForm">
		
		<input type="hidden" value="${memberDto.num }" name="num" />
			<div class="sub">아이디</div>
			<div class="type">
				*<input type="text" name="id" value = "${memberDto.id }" disabled="disabled"> 
			</div>
			<div class="sub" >비밀번호</div>
			<div class="type">
				*<input type="password" name="password" value = "${memberDto.password }">
			</div>
			<div class="sub">비밀번호확인</div>
			<div class="type">
				*<input type="password" name="passwordCheck" value = "${memberDto.password }">
			</div>
			<div class="sub">이름</div>
			<div class="type">
				*<input type="text" name="name" disabled="disabled"value = "${memberDto.name }" >
			</div>
			<div class="sub">주민번호</div>
			<div class="type">
				*<input type="tel" name="jumin1" disabled="disabled" value = "${memberDto.jumin1 }">-<input type="password" name="jumin2" disabled="disabled" value = "${memberDto.jumin2 }">
			</div>
			<div class="sub">이메일</div>
			<div class="type">
				<input type="text" style="margin-left: 5px;" name="email" value = "${memberDto.email }">  
			</div>
			<div class="sub">우편번호</div>
			<div class="type"><input type="text" name="zipcode" value = "${memberDto.zipcode }" placeholder="우편번호" style="margin-left: 5px;"> <input type="button" value="우편번호검색" onclick="zipcodeRead('${root}')">
			</div>
			<div class="sub" >주소</div>
			<div class="type">
				<input type="text" size="40" style="margin-left: 5px;" name="address" value = "${memberDto.address }">
			</div>
			<div class="sub">직업</div>
			<div class="type">
				${memberDto.job }
				<select style="margin-left: 5px;" name="job" >
				<option>&nbsp;&nbsp;</option>
				<option>변호사</option>
				<option>약사</option>
				</select>
				<script type="text/javascript">
				creatForm.job.value="${memberDto.job }"
				
				</script>
			</div>
			${memberDto.mailing }
			<div class="sub">메일수신</div>
			<div class="type">
				<input type="radio" name="mailing" value="yes">yes<input type="radio" name="mailing" value="no">no
			</div>
			<script type="text/javascript">
			for(var i=0; i<creatForm.mailing.length; i++){
				if(creatForm.mailing[i].value=="${memberDto.mailing }"){
					creatForm.mailing[i].checked=true;
				}
			}
			
			</script>
			${memberDto.interest }
			<div class="sub">관심분야</div>
			<div class="type">
				<input type="checkbox" name="interestValue" value="경제"> 경제 <input type="checkbox" name="interestValue" value="IT">
				IT <input type="checkbox" name="interestValue" value="음악"> 음악 <input type="checkbox" name="interestValue" value="미술">
				미술 <input type="hidden" name="interest" />
			</div>
			  <c:forTokens var="interest" items="${memberDto.interest }" delims=",">
			<script type="text/javascript">
				for(var i=0; i<creatForm.interestValue.length;i++){
					if(creatForm.interestValue[i].value=="${interest}"){
						creatForm.interestValue[i].checked=true;
					}
				}			
			
			</script>
			</c:forTokens>
			<!-- <script type="text/javascript">
				var arr = "${memberDto.interest }".split(",");
				for(var i=0; i<arr.length; i++){
					for(var j=0; j<creatForm.interestValue.length; j++){
						if(creatForm.interestValue[j].value==arr[i]){
							creatForm.interestValue[j].checked=true;
						}
					}
				}
			
			</script> -->
			
			<div align="center" ><input type="submit" value="가입"><input type="reset" value="취소" style="margin-left: 5px;"> </div>
		</form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkForm(){
		
	/* Id, tagName, className, name -> 모든 속성에서 id클래스 붙여서 가능 */
	
	
		
	/*  	var createForm = document.getElementById("createForm");
		
		if(createForm.irum.value==""){
			alert("이름을 입력하세여");
			createForm.irum.focus();
			return false;
		} 
	
		//같은 결과 다른 방식으로 풀어냄
	var form = document.getElementsByTagName("form");
	var input = form[0].getElementsByTagName("input");
	
	if(input[0].value==""){
		alert("이름을 입력하세요");
		input[0].focus();
		return false;
	} */
	
	var fruit = document.getElementsByName("fruit");
	alert("fruit" + fruit.length);
	
	var interest = document.getElementsByClassName("interest");
	alert("interest" + interest.length);
}
</script>
</head>
<body>
<form action="#" method="get" onsubmit="return checkForm()" ID="createForm">
													  <!-- 기본값 return : true -->	
	
	<!-- 클릭해서 들어가는 건 get, 웹의 시작은 get or post로 자바의 메인과 똑같다, post는 데이터를 던져줄 떄 -->
	<!-- ★★★★★★★★★★★★onsubmit 이벤트에 대해 알기★★★★★★★★★★★★★★ -->
		<label>이름을 입력하세요</label>
		<br></br>
		<input type="text" name="irum"/>
		<br></br>
		
		<label>이동할 사이트 선택</label>
		<br></br>
		<select name="siteurl" id="siteUrl">
			<option></option>
			<option value="https://www.naver.com">ㄴㅇㅂ</option>
			<option value="https://www.daum.com">ㄷㅇ</option>
			<option value="https://www.nate.com">ㄴㅇㅌ</option>
		</select>
		<br></br>
		
		
		<!-- radiotype, checkbox는 DOM에서 ID속성을 못 사용한다. 그래서 네임많이씀 -->
		<label>좋아하는 과일</label>
		<br></br>
		<input type="radio" name="fruit" value="바나나"/>
		<label>바나나</label>
		
		<input type="radio" name="fruit" value="사과"/>
		<label>사과</label>
		
		<input type="radio" name="fruit" value="딸기"/>
		<label>딸기</label>
		
		<input type="radio" name="fruit" value="파인애플"/>
		<label>파인애플</label>
		<br></br>
		
		<label>관심사체크</label> <!-- db는 배열이없어서 문자열로 보내야한다 -->
		<br></br>
		<input type="checkbox" name="interest" value="경제" class="interest"/>
		<label>경제</label>
		
		<input type="checkbox" name="interest" value="IT" class="interest"/>
		<label>IT</label>
		
		<input type="checkbox" name="interest" value="음악" class="interest"/>
		<label>음악</label>
		
		<input type="checkbox" name="interest" value="미술" class="interest"/>
		<label>미술</label>
		<br></br>
		
		<input type="hidden" name="result" />
		
		<input type="submit" value="전송"/> 
		<input type="reset" value="취소"/>
		
	</form>
</body>
</html>
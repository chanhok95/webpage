<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function test(){
	//	alert("ok");
	
	//태그로 가져오는법 -> '클릭'을 누르면 div에 데이터를 넣어라
	var div = document.getElementsByTagName("div"); //document는 body내용을 뜻함
	div[0].innerHTML="apple";
	div[1].innerHTML="banana";
	}
</script>

<!-- 정적이동이 dom -->

</head>
<body>
	<div></div>
	<div></div>

	<input type="button" value="클릭" onclick="test()" />

</body>
</html>
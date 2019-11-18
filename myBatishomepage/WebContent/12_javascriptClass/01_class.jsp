<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="01_class.js"></script>
<script type="text/javascript">
function instanceFruit() {
	// alert("ok");
	var fruit = new Fruit();
	fruit.taste();
	fruit.disp("하하하");
}

function instanceApple(){
	var apple = new Apple();
	apple.taste();
	apple.abc();
}

function instanceOrange(){
	var orange = new Orange();
	orange.taste();
	orange.ef();
}
</script>
</head>
<body>
	<label>과일</label>
	<input type="button" value="과일" onclick="instanceFruit()">
	<br/><br/>
	
	
	<label>사과</label>
	<input type="button" value="사과" onclick="instanceApple()">
	<br/><br/>
	
	
	<label>오렌지</label>
	<input type="button" value="오렌지" onclick="instanceOrange()">
	<br/><br/>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function sub(){
		var myForm = document.getElementById("myForm");
		var input = myForm.getElementsByTagName("input");
		
		var msg = document.getElementById("msg");
		for(var i=0; i<input.length; i++){
			if(input[i].checked == true){
				//alert(input[i].value);
			
				msg.innerHTML="<img width='150',height='200' src='../images/"+input[i].value+".jpg'/>";
				str=input[i].value;
			}
		}
		
		var div=document.getElementById("text");
		div.innerHTML=str;
		div.style.color="red";
	}
</script>
</head>
<body>
	<div id="text"></div>
	<br/><br/>
	
	<form id="myForm">
		<input type="radio" name="select" value="498ce38d69f59a1f3978ff0166784567" onchange="sub()"/>
		<label>사과</label>
		
		<input type="radio" name="select" value="Penguins" onchange="sub()"/>
		<label>딸기</label>
		
		<input type="radio" name="select" value="Jellyfish" onchange="sub()"/>
		<label>귤귤뀰</label>
		
		<input type="radio" name="select" value="Tulips" onchange="sub()"/>
		<label>바나나</label>
	</form>
	
	<br/><br/>
	
	<div id="msg"></div>
	
</body>
</html>
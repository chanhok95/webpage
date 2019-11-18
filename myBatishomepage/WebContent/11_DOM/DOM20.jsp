<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function sub() {
	var formNode = document.createElement("form");
	formNode.setAttribute("id","createForm");
	formNode.setAttribute("action", "#");
	formNode.setAttribute("method", "post");
	formNode.setAttribute("onsubmit", "return abc()");
	//formNode.onsubmit="return abc()"; // error
	formNode.onsubmit=function(){ //이벤트함수를 사용할때만 생각하면됨 그냥 왠만하면 익명함수로
		abc();
		return true;
	}
	
	
	var labelNode = document.createElement("label");
	labelNode.innerHTML="이름";
	
	var nameInput =document.createElement("input");
	nameInput.type = "text";
	nameInput.name = "irum";
	nameInput.size = "12";
	
	var brNode=document.createElement("br");
	
	var submitInput = document.createElement("input");
	submitInput.setAttribute("type", "submit");
	submitInput.setAttribute("value", "전송");
	
	formNode.appendChild(labelNode);
	formNode.appendChild(nameInput);
	formNode.appendChild(brNode);
	formNode.appendChild(submitInput);
	
document.body.appendChild(formNode);
}


function abc() {
	var createForm=document.getElementById("createForm");
	
	if(createForm.irum.value==""){
		alert("입력하세요");
		createForm.irum.focus();
		return false;
	}
	
	
}
</script>

</head>
<body onload="sub()">

</body>
</html>
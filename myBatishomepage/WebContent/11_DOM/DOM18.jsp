<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function sub() {
	var array = new Array();

	var divNode = document.createElement("div");
	divNode.align="center";			//setAlign
	divNode.style.color="blue";
	divNode.innerHTML="반가워요";
	
	array.push(divNode.align) //getAlign
	
	var div =document.createElement("div");
	div.setAttribute("align", "center");
	div.setAttribute("style", "color:red");
	div.innerHTML="반가워요";
	array.push(div.getAttribute("align"));
	
	
	alert(array.join("\n"));
	document.body.appendChild(divNode);
	document.body.appendChild(div);
	
}


</script>

</head>
<body onload="sub()">


</body>
</html>
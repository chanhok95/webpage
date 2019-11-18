<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function sub() {
	var divNode =document.createElement("div");
	var str="banana";
	
	for(var i=0; i<3; i++){
		var inputNode=document.createElement("input");
		/* inputNode.type="button";
		inputNode.value="클릭"+(i+1);
		inputNode.onclick=xyz;
		 */
		 
		 inputNode.setAttribute("type", "button");
		 inputNode.setAttribute("value", "클릭"+(i+1));
		 //inputNode.setAttribute("onclick", "xyz()");
		//inputNode.setAttribute("onclick", "abc('apple')");
		 //inputNode.setAttribute("onclick", "abc('"+str+"')");
		 
		 inputNode.onclick=function(){  //익명함수
			abc(str); 
			 
		 }
		 
		 divNode.appendChild(inputNode);
	}
	document.body.appendChild(divNode);
}

function abc(str) {
	alert(str);
}

function xyz() {
	alert("생성");
}

</script>
</head>
<body onload="sub()">

</body>
</html>
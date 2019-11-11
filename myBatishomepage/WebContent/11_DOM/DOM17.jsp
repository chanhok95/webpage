<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function sub() {
	var divNode = document.createElement("div");
	divNode.align="center";
	
	for(var i=0; i<10; i++){
		var spanNode= document.createElement("span");
		spanNode.innerHTML="내용"+(i+1);
		
		var brNode=document.createElement("br");
		
		divNode.appendChild(spanNode);
		divNode.appendChild(brNode);
		divNode.removeChild(brNode);
		
	}
	document.body.appendChild(divNode);
}

	function fun() {
		document.body.removeChild(document.getElementById("aLabel"));
		document.getElementById("bLabel").innerHTML="";  /* 삭제시 잘삭제해야됨 태그전체가 삭제 될수도 있기 때문에 */
		
	}

</script>
</head>
<body onload="sub()">

	<a href="#" onclick="fun()">클릭</a>
	
	<div id = "aLabel"> 공부하자 </div>
	<div id = "bLabel">공부하기 싫으면 IT 하지마</div>

</body>
</html>
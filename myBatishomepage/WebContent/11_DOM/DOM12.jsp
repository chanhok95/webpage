<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function sub() {
	
	// Tag , Element , Node - 생성,추가(appendChild)치환(replace),삭제
	//
	//
	var divNode= document.createElement("div");
	divNode.align= "center";
	divNode.id="apple";
	divNode.style.color="red";
	divNode.innerHTML="안녕하세요";
	
	
	var spanNode1 = document.createElement("span");
	spanNode1.id="banana";
	spanNode1.style.color="blue";
	spanNode1.innerHTML="hi";
	
	var spanNode2 = document.createElement("span");
	spanNode2.id="strawbarry";
	spanNode2.style.color="blue";
	spanNode2.innerHTML="딸기";

	var spanNode3 = document.createElement("span");
	spanNode3.id = "waterMelon";
	spanNode3.style.color="blue";
	spanNode3.innerHTML="수박";

	var brNode=document.createElement("br");
	
	divNode.appendChild(brNode);
	
	
	divNode.appendChild(spanNode1);
	divNode.appendChild(spanNode2);
	divNode.appendChild(spanNode3);
	document.body.appendChild(divNode);
	

}


</script>
</head>
<body onload="sub()">

</body>
</html>
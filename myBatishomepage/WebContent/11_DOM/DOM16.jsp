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
	
	var spanNode = document.createElement("span");
	spanNode.innerHTML="반가워요";
	
	var bNode = document.createElement("b");
	bNode.innerHTML="안녕하세요";
	
	divNode.appendChild(spanNode);
	divNode.appendChild(document.createElement("br"));
	divNode.appendChild(bNode);
	
	document.body.appendChild(divNode);
	
	var fontNode=document.createElement("font");
	fontNode.innerHTML="공부하자";
	
	divNode.replaceChild(fontNode,spanNode)
	
}

function disp() {
	var disp = document.getElementById("disp");
	disp.innerHTML="싫어";
}

</script>
</head>
<body onclick="sub()">
	<a href="#" onclick="fun()">클릭</a>
	<br/><br/>
	
 <div id="disp">공부 꼭하자!! ~~</div>

<div id = "abc">
<span>가</span>
<span>나</span>
<span>다</span>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function sub() {
	
	var dauther = document.getElementById("dauther");
	var olderBrother = dauther.previousSibling;
	var olderValue = getpreviousSibling(olderBrother)
	
	
	var youngerBrother = dauther.nextSibling;
	var youngerValue = getYoungerBrother(youngerBrother);
}


function getpreviousSibling(node) {
	if(node.nodeType==1){
		return node.childNodes[0].nodeValue;
		
	}
	if(node.nodeType==3){
		return node.previousSibling.childNodes[0].nodeValue;
	}
	
}

function getYoungerBrother(node) {
	if(node.nodeType==1){
		return node.childNodes[0].nodeValue;
		
	}
	if(node.nodeType==3){
		return node.nextSibling.childNodes[0].nodeValue;
	}
}

</script>
</head>
<body onload="sub()">
<div id="grandfather"> <%--div태그가 몇개안될때 div태그를 전체 ,firstSon를 뽑으려면 father를 기준 , grandfather를 기준 3가지 방법 --%>
		<div id = father> <%--어떻게 뽑아올지 생각해봐야됨  챠일드node->챠일드value span태그를 뽑아서--%>
			<span id="firstSon">첫번째</span>
			<span id="dauther">두번째</span>
			<span id="secondSon">세번째</span>
		</div>
	</div>
	
	<div id = "disp" style="color: blue;"></div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
var array = new Array();

/*  var firstSon =document.getElementById("firstSon");
 array.push(firstSon.childNodes.nodeValue);
 */
var father = document.getElementById("father");
var fatherSon = father.getElementsByTagName("span");
array.push(fatherSon[0].childNodes[0].nodeValue);

var grandfather=document.getElementById("grandfather");
var grandfatherDiv=grandfather.getElementsByTagName("div");
var grandfatherSpan=grandfatherDiv[0].getElementsByTagName("span");
array.push(grandfatherSpan[0].childNodes[0].nodeValue); 

alert(array.join("\n"));




</script>
</head>
<body>
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
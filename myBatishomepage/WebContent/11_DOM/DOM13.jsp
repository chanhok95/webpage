<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function sub() {
	var aDiv=document.createElement("div");
	var bDiv=document.createElement("div");
	
	var aSpan1=document.createElement("span");
	aSpan1.innerHTML="가";
	var aSpan2=document.createElement("span");
	aSpan2.innerHTML="나";
	var aSpan3=document.createElement("span");
	aSpan3.innerHTML="다";	
	
	var bSpan1=document.createElement("span");
	var bSpan2=document.createElement("span");
	var bSpan3=document.createElement("span");
	
	aDiv.appendChild(aSpan1);
	aDiv.appendChild(aSpan2);
	aDiv.appendChild(aSpan3);
	var bDiv=document.createElement("div");
	
	var bSpan1=document.createElement("span");
	bSpan1.innerHTML="A";
	var bSpan2=document.createElement("span");
	bSpan2.innerHTML="B";
	var bSpan3=document.createElement("span");
	bSpan3.innerHTML="C";
	
	bDiv.appendChild(bSpan1);
	bDiv.appendChild(bSpan2);
	bDiv.appendChild(bSpan3);
	
	var disp = document.getElementById("disp");
	disp.appendChild(aDiv);
	disp.appendChild(bDiv);
	
}

</script>
</head>
<body>
	<div onclick="sub()">클릭</div>
<div id="disp"></div>

</body>
</html>
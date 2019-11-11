<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function sub() {
	var aLabel=document.createElement("label");
	aLabel.innerHTML="이름을 입력하세요.";
	var bLabel=document.createElement("label");
	bLabel.innerHTML="이동할 사이트 선택";
	var cLabel=document.createElement("label");
	cLabel.innerHTML="좋아하는 과일 선택";
	var dLabel=document.createElement("label");
	dLabel.innerHTML="관심사체크";
	

	var aInput=document.createElement("input");
	aInput.type="text";
	aInput.name="irum";
	
	var aSelect=document.createElement("select");
	aSelect.name="siteurl";
	
	var aOption=document.createElement("option");
	aOption.innerHTML="네이버";
	aOption.value="https://www.naver.com";
	
	var bOption=document.createElement("option");
	bOption.innerHTML="다음";
	bOption.value="https://www.naver.com";
	
	var cOption=document.createElement("option");
	cOption.innerHTML="네이트";
	cOption.value="https://www.naver.com";
	
	var frultInput1=document.createElement("input");
	frultInput1.type="radio";
	frultInput1.name="fruit";
	frultInput1.value="바나나";
	
	var frultLabel1=document.createElement("label");
	frultLabel1.innerHTML="바나나";
	
	var frultInput2=document.createElement("input");
	frultInput2.type="radio";
	frultInput2.name="fruit";
	frultInput2.value="사과";

	var frultLabel2=document.createElement("label");
	frultLabel2.innerHTML="사과";
	
	
	var frultInput3=document.createElement("input");
	frultInput3.type="radio";
	frultInput3.name="fruit";
	frultInput3.value="딸기";
	
	var frultLabel3=document.createElement("label");
	frultLabel3.innerHTML="딸기";
	
	
	var frultInput4=document.createElement("input");
	frultInput4.type="radio";
	frultInput4.name="fruit";
	frultInput4.value="파인애플";
	
	var frultLabel4=document.createElement("label");
	frultLabel4.innerHTML="파인애플";
	

	var interest1 =document.createElement("input");
	interest1.type="checkbox";
	interest1.name="interset";
	interest1.value="경제";
	
	var interestlabel1=document.createElement("label");
	interestlabel1.innerHTML="경제";
	
	
	var interest2 =document.createElement("input");
	interest2.type="checkbox";
	interest2.name="interset";
	interest2.value="IT";
	
	var interestlabel2=document.createElement("label");
	interestlabel2.innerHTML="IT";
	
	var interest3 =document.createElement("input");
	interest3.type="checkbox";
	interest3.name="interset";
	interest3.value="음악";
	
	var interestlabel3=document.createElement("label");
	interestlabel3.innerHTML="음악";
	
	var interest4 =document.createElement("input");
	interest4.type="checkbox";
	interest4.name="interset";
	interest4.value="미술";
	
	var interestlabel4=document.createElement("label");
	interestlabel4.innerHTML="미술";
	
	
	var submit = document.createElement("input");
	submit.type="submit";
	submit.value="전송";
			
	var reset = document.createElement("input");
	reset.type="reset";
	reset.value="취소";

	
	var brNode1=document.createElement("br");
	var brNode2=document.createElement("br");
	var brNode3=document.createElement("br");
	var brNode4=document.createElement("br");
	var brNode5=document.createElement("br");
	
	
	
	aLabel.appendChild(aInput);
	aLabel.appendChild(brNode1);
	
	
	bLabel.appendChild(aSelect);
	bLabel.appendChild(brNode2);
	
	cLabel.appendChild(brNode3);
	
	dLabel.appendChild(brNode4);
	
	cLabel.appendChild(frultInput1);
	cLabel.appendChild(frultLabel1);
	cLabel.appendChild(frultInput2);
	cLabel.appendChild(frultLabel2);
	cLabel.appendChild(frultInput3);
	cLabel.appendChild(frultLabel3);
	cLabel.appendChild(frultInput4);
	cLabel.appendChild(frultLabel4);
	cLabel.appendChild(brNode3);
	
	dLabel.appendChild(interest1);
	dLabel.appendChild(interestlabel1);
	dLabel.appendChild(interest2);
	dLabel.appendChild(interestlabel2);
	dLabel.appendChild(interest3);
	dLabel.appendChild(interestlabel3);
	dLabel.appendChild(interest4);
	dLabel.appendChild(interestlabel4);
	dLabel.appendChild(brNode4);
	
	
	
	aSelect.appendChild(aOption);
	aSelect.appendChild(bOption);
	aSelect.appendChild(cOption);
	
	
	
	
	
	
	var disp = document.getElementById("disp");
	disp.appendChild(aLabel);
	disp.appendChild(bLabel);
	disp.appendChild(cLabel);
	disp.appendChild(dLabel);
	disp.appendChild(submit);
	disp.appendChild(reset);
	
}

</script>
</head>
<body>
	<div onclick="sub()">클릭</div>
	<div id="disp"></div>
</body>
</html>
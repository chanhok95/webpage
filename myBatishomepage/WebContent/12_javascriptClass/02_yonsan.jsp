<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="02_yonsan.js"></script>
<script type="text/javascript">
function result(){
	var su = document.getElementById("su").value;
	var buho=document.getElementById("buho").value;
	var value=document.getElementById("value").value;
	// alert(su +"\n"+buho +"\n"+ value)

	var y = new Younsan(su,buho,value);
	
	y.calculate();
	y.disp();
}

</script>
</head>
<body>
<label>수</label>
<input type="text" name="su" id="su"><br/><br/>

<label>부호</label>
<input type="text" name="buho" id="buho"><br/><br/>

<label>수</label>
<input type="text" name="value" id="value"><br/><br/>

<input type="button" value="전송" onclick="result()" /><br/><br/>
<input type="reset" value="취소" />

<br/><br/>
<span>결과</span>
<span id="result"></span>

</body>
</html>
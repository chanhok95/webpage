<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../xhr.js"></script>
<script type="text/javascript">
	function toServer(){
		var inputText=document.getElementById("msg").value;
		//alert(inputText);
		var params="msg=" + inputText;
		
		sendRequest("GET","server.jsp",fromServer,params);
		
	
		
	}
	
	function fromServer(){
		if(xhr.readyState==4 && xhr.status==200){
			var dispDiv=document.getElementById("disp");
			dispDiv.innerHTML=xhr.responseText;
		}
	}

</script>
</head>
<body>
<h3>POST / GET</h3>

<form action="">
	<input type="text" name="msg" id="msg">
	<input type="button" value="입력" onclick="toServer()">
</form>
<br/><br/>
<div id="disp"></div>
</body>
</html>
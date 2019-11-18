<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}" /> 
<html>
<head>
<meta charset="UTF-8">
<title>AJAX DB</title>
<script type="text/javascript" src="${root }/xhr/xhr.js"></script>
<script type="text/javascript">

	var array = new Array();
function toServer(root){

	var form=document.getElementById("createForm");
	var selectText=form.departmentName.value;
	array.push(selectText);
	
	alert(array.join("\n"));
	
	var url=root+"/sawon/listOk.do";

	if(selectText !="부서선택하세요."){
	var params="departmentName="+selectText;	 //= 빼먹어서 null값이 나옴
	sendRequest("POST",url,fromServer,params);
		
	}
	
}
function fromServer(){
	if(xhr.readyState==4 && xhr.status==200){
		document.getElementById("resultDisplay").innerHTML=xhr.responseText;
		
	}
	
}


</script>
</head>
<body>
	<form id="createForm">
		<select onchange="toServer('${root}')" name="departmentName">
			<option>부서 선택하세요.</option>
			<option value="Marketing">Marketing</option>
			<option value="IT">IT</option>
			<option value="Sales">Sales</option>
		</select>
	</form>
</body>
<div id="resultDisplay"></div>
</html>
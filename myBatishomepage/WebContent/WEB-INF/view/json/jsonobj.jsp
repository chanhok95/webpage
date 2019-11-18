<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${root }/xhr/xhr.js"></script>
<script type="text/javascript">
function toServer(root){
//	alert(root);
	
	var url=root+"/json/jsonobject.do";
	
	sendRequest("GET",url,fromServer,null);
	
}
function fromServer(){
	if(xhr.readyState==4 && xhr.status==200){
		// alert(xhr.responseText);		
		 var obj= JSON.parse(xhr.responseText);
		spanBunho=document.createElement("span");
		spanBunho.innerHTML=obj.bunho;
		
		spanName=document.createElement("span");
		spanName.innerHTML=obj.name;
		
		spanAverage=document.createElement("span");
		spanAverage.innerHTML=obj.average;
		
		var disp = document.getElementById("disp");
		disp.appendChild(spanBunho);
		disp.appendChild(spanName);
		disp.appendChild(spanAverage);
		
		
		
	}
	
}

</script>
</head>
<body onload="toServer('${root}')">
<div id="disp"></div>

</body>
</html>
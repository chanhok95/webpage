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
	
	var url=root+"/json/jsonobjArray.do";
	
	sendRequest("GET",url,fromServer,null);
	
}
function fromServer(){
	if(xhr.readyState==4 && xhr.status==200){
		// alert(xhr.responseText);		
		var obj=JSON.parse(xhr.responseText);
		//alert(obj.bunho+","+obj.name+","+obj.averge+","+obj.reply.length+","
				//+obj.reply[0].line_reply);
		for(var i=0; i<obj.reply.length; i++){
			var reply = obj.reply[i];
			var subreply = reply;
			var divNode=document.createElement("div");
			
			for(var j=0; j<subreply.length; j++){
				var spanNode=document.createElement("span");
				
				spanNode.innerHTML=subreply;
				divNode.appendChild(spanNode);
			}
		}
		document.getElementById("disp").appendChild(divNode);
		
		
	}
	
}

</script>
</head>
<body onload="toServer('${root}')">
<div id="disp"></div>

</body>
</html>
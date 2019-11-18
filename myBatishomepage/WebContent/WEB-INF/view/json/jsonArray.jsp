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
	
	// alert(root);
	var url=root+"/json/jsonoArr.do";
	
	sendRequest("GET",url,formServer,null);
}


function formServer(){
	if(xhr.readyState==4 && xhr.status==200){
		//alert(xhr.responseText);
		var obj = JSON.parse(xhr.responseText);
		//alert(obj.length);
		var div = document.createElement("div");
		
		for(var i=0; i<obj.length; i++){
		var ulNode = document.createElement("ul");
			ulNode.innerHTML=obj.bunho[i];
		var	liNode = document.createElement("li");
			liNode.innerHTML=obj.line_reply[i];
			
			ulNode.appendChild(liNode);
			
			div.appendChild(ulNode);
		}
		document.getElementById("disp").appendChild(div);
	}
}
	/* 	for(var i=0; i<obj.length; i++){
			//alert(obj[i].bunho + obj[i].line_reply);
			var objL = obj.length[i];
			for(var j=0; j<objL; j++){
				
				var disp = document.getElementById("disp");
				var spanNode =document.createElement("span");
				spanNode.appendChild.obj[i].bunho;
				spanNode.appendChild.obj[i].line_reply;
				disp.appendChild(spanNode);
					
			}
			
			
		}
		document.getElementById(disp).appendChild.spanNode;
	}
} */
</script>
</head>
<body onload="toServer('${root}')">
	<div id="disp"></div>
</body>
</html>
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
		sendRequest("GET","json02.txt",fromServer,null);
		
		
	}
	
	function fromServer(){ 
		if(xhr.readyState==4 && xhr.status==200){
		//	alert(xhr.responseText);
			var obj=JSON.parse(xhr.responseText); //숫자를0001 을 못불러오는 웹페이지가 있음
			
			var divNode=document.createElement("div");
			for(var i=0; i<obj.member.length; i++){
				
				var ulNode=document.createElement("ul");
				
				var liNumber=document.createElement("li");
				liNumber.innerHTML=obj.member[i].stdNumber;
				var liName=document.createElement("li");
				liName.innerHTML=obj.member[i].stdName;
				var liScore=document.createElement("li");
				liScore.innerHTML=obj.member[i].score;
				
				ulNode.appendChild(liNumber);
				ulNode.appendChild(liName);
				ulNode.appendChild(liScore);
				
				divNode.appendChild(ulNode);
			}
			document.getElementById("disp").appendChild(divNode);
		}
		
	}

</script>
</head>
<body onload="toServer()">
	<div id ="disp"></div>
</body>
</html>
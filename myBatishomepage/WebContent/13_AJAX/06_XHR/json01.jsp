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
	sendRequest("GET","json01.txt",fromServer,null);
}

function fromServer(){
	if(xhr.readyState==4 && xhr.status==200){
		//alert(xhr.responseText);
		var obj=JSON.parse(xhr.responseText); //obj가 가지고있는 key value
		alert(obj.name + "," + obj.age + "," + obj.ki);
		
		var ulNode =document.createElement("ul");
		var nameLiNode=document.createElement("li");
		nameLiNode.innerHTML=obj.name;
		
		var ageLiNode=document.createElement("li");
		ageLiNode.innerHTML=obj.age;
		
		var kiLiNode=document.createElement("li");
		kiLiNode.innerHTML=obj.ki;

		ulNode.appendChild(nameLiNode);
		ulNode.appendChild(ageLiNode);
		ulNode.appendChild(kiLiNode);
		
		var disp = document.getElementById("disp").appendChild(ulNode);
		
	}
}

</script>
</head>
<body onload="toServer()">
<!-- 
	<pre>
		JSON(JavaScript Object Notation) / 자바 스크립트 객체표기법
		다른 프로그래밍 언어간에 데이터를 교환하기 위한 기법	
		JSON은 사람이 읽을 수 있는 텍스트 기반의 데이터 교환 표준입니다.
		이러한 JSON은 XML의 대안으로서 좀 더 쉽게 데이터를 교환하고 저장하기 위하여 고안되었습니다.
		1) { } 중괄호로 시작해서   
		2) {key : value}  / {"firstName":"John","LastName":"Kim"} String = ""
		3) 배열 형태로 저장
			{"irumList":
					[
						{"key":"value","key":"value"},		
						{"key":"value","key":"value"},		
						{"key":"value","key":"value"}		
					]
			}
			
			{
				"name":"John",
				"age":30,
				"cars": [
					{"key":"value","key":"value"},
					{"key":"value","key":"value"},
					{"key":"value","key":"value"}
				]
				
				
			}
	</pre>
	 -->
	 <div id="disp"></div>
</body>
</html>
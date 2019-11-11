<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function sub(){
		var array = new Array();
		var div = document.getElementsByTagName("div");
	
		array.push("노드 이름 : " + div[0].nodeName);
		array.push("노드 값 : " + div[0].nodeValue);	//div태그내에 value가 없으므로 null값나옴
		array.push("노드 이름 : " + div[0].childNodes[0].nodeName);
		array.push("노드 값 : " + div[0].childNodes[0].nodeValue);
		
		var span = div[1].getElementsByTagName("span");
		array.push("span 개수 : " + span.length);
		array.push("span 개수 : " + div[1].childNodes.length); //div내 자식은 span 3개지만 실제론 공백까지 포함한다, 엔터를 4번 눌렀기 때문에 3+4해서 7이 출력되니 들여쓰기 및 엔터 입력 주의하자
		
 		alert(array.join("\n")); 
		
	}
</script>
</head>
<body>
	<div>가</div>
	
	<div>
	
		<span>가</span>  <!-- div[1].childNodes 로접근시 length는 7개 가,나,다,enter 4-->
		<span>나</span>
		<span>다</span>
	
	</div>
	
	<input type="button" value="클릭" onclick="sub()"/>
		
</body>
</html>
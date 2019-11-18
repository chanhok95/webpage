<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${root }/xhr/xhr.js"></script>
<script type="text/javascript">
	function toServer(root){
	// var url="http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108";
	var url =root+"/pXML.do";
	sendRequest("GET",url,fromServer,null);
		
	}
	function fromServer(){
		// alert(xhr.readyState+","+xhr.status);
		if(xhr.readyState==4 && xhr.status==200){
			var xmlDoc = xhr.responseXML;
			alert(xhr.responseText);
			
			//6. 받아온 xml파일은 다른 xml과 같이 for문을 이용하여 루프를 돌려 값을 가져오면 된다.

			//7. 나왔던 문제: 가져온 xml값을 이용하여 location안의 city값과 첫번째 data의 wf값을 불러오기
			
			
		}
		
		
	}

</script>

</head>
<body onload="toServer('${root}')">

</body>
</html>
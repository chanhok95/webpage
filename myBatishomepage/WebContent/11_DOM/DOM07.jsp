<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function sub(){
		var arr = new Array();
		
		var melon = document.getElementById("melon");
		
		arr.push(melon.nodeName);
		arr.push("nodeValue ->"+melon.nodeValue); /* tag는 null값이기 때문에 변수명만 써있을시 아무것도 나오지않고 문자열을포함한 아무값이 있을경우 null로 출력 */
		arr.push(melon.childNodes.length);
		
		for(var i=0; i<melon.childNodes.length; i++){
			arr.push(melon.childNodes[i].nodeName);
		}
		
		var span = melon.getElementsByTagName("span");
		
		for(var i=0; i<melon.childNodes.length; i++){
			
		}
		
		alert(arr.join("\n"));
	}
	
	function fun(){
		var array = new Array();
		var apple = document.getElementById("apple");
		var appleChild = apple.childNodes;
	
		for(var i=0; i<appleChild.length; i++){
			/* array.push(appleChild[i].nodeName);
			array.push(appleChild[i].nodeValue);
			array.push(appleChild[i].nodeType); */
			
			// 1 : 태그 , 2 : 속성 , 3 : 텍스트
		}
		
		//★★★★★★★★★★★★★★★★★★★★★ 이거중요함
		for(var i=0; i<appleChild.length; i++){
			if(appleChild[i].nodeType == 1){
				array.push(appleChild[i].childNodes[0].nodeValue);
			}
		}
		//★★★★★★★★★★★★★★★★★★★★★
		alert(array.join("\n"));

	}
</script>
</head>
<body>
	<div id="melon">
		<span>가</span>   
		<span>나</span>
		<span>다</span>
	</div>
	<br/><br/>
	
	<input type="button" value="확인" onclick="sub()"/>
	
	<div id="apple">
		<span>a</span>
		<i>b</i>
		<label>c</label>
	</div>
	
	<input type="button" value="확인" onclick="fun()"/>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function sub() {
	/* var array = new Array();
	
	var data = document.getElementById("data");
	var dataSon=data.getElementsByTagName("span");
	
	var disp = document.getElementById("disp");
	
	for(var i=0; i<data.length; i++){
			
		disp.appendChild(data);
	}
	 */
	 
	 var data =document.getElementById("data").childNodes;
	 var div = document.getElementById("disp");
	 
		for(var i=0; i<data.length; i++){
			if(data[i].nodeType==1){
				var value=data[i].childNodes[0].nodeValue;
				var span = document.createElement("span");
				
				span.innerHTML=value;
				div.appendChild(span);
			}
		}
		document.body.appendChild(div);
}




</script>
</head>
<body>

 <a href="#" onclick="sub()"> 클릭 </a>
 <br/><br/>
 
 <div id="data">
 	<span>1</span>
 	<span>2</span>
 	<span>3</span>
 	<span>4</span>
 	<span>5</span>
 	<span>6</span>
 	<span>7</span>
 	<span>8</span>
 	<span>9</span>
 	<span>10</span>
 
 
 </div><br/><br/>
 <div id="disp"></div>



</body>
</html>
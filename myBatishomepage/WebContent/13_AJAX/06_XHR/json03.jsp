<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../xhr.js"></script>
<script type="text/javascript">
	function toServer() {
		sendRequest("GET", "json03.txt", fromServer, null);

	}
	function fromServer() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var obj = JSON.parse(xhr.responseText);

			var div = document.createElement('div');

			for (var i = 0; i < obj.cars.length; i++) {
				var labelNode = document.createElement('label');
				labelNode.innerHTML = obj.cars[i].name;

				var ulNode = document.createElement('ul');
				
				for (var j = 0; j < obj.cars[i].models.length; j++) {
					var modelNode = document.createElement('li');
					modelNode.innerHTML = obj.cars[i].models[j];
					ulNode.appendChild(modelNode);

				}
				div.appendChild(labelNode);
				div.appendChild(ulNode);

			}
		document.getElementById("disp").appendChild(div);
		}
	}
	/* 	for(var i=0; i<obj.cars.length; i++){
			// alert(obj.cars.length); 3의값 0 1 2 번지
			var ulNode = document.createElement("ul");
			
			for (var j=0; j<obj.cars[i]; j++){
			alert(obj.cars[i]);
			var liname = document.createElement("li");
			liname.innerHTML=obj.cars[i].name;
			var limodels = document.createElement("li");
			limodels.innerHTML=obj.cars[i].models;
			
			ulNode.appendChild(liname);
			ulNode.appendChild(limodels);
			
			divNode.appendChild(ulNode);
			
			
			
			}
			
		}
		document.getElementById("disp").appendChild(divNode);
	}	

	}
	 */
</script>
</head>
<body onload="toServer()">
	<div id="disp"></div>
</body>
</html>
/**
 * 
 */

var xhr = null;

function createXHR(){
	if (window.XMLHttpRequest) {
	    xhr = new XMLHttpRequest();
	}else{
		  xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}
}

function startRequest(){
	var createForm = document.getElementById("createForm");
	var id =createForm.id.value;
	var pwd = createForm.pwd.value;
	var data = "id=" +id +"&pwd="+pwd;
	
//	alert(id + "," + pwd);
	
	
	createXHR();
	/*
	xhr.open("get", "server.jsp?"+data , true);
	xhr.send();
	xhr.onreadystatechange = resultProcess;*/
	
	xhr.open("POST", "server.jsp",true);
	xhr.setRequestHeader("Content-type"," application/x-www-form-urlencoded");
	xhr.send(data);
	xhr.onreadystatechange = resultProcess;
}

function resultProcess(){
	if(xhr.readyState == 4 && xhr.status == 200){
//		alert(xhr.responseText);
		var disp = document.getElementById("resultDisp");
		var span = document.createElement("span");
		span.style.color="red";
		span.innerHTML=xhr.responseText;
		
		disp.appendChild(span);
	}
}
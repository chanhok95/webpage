/**
 * 
 */
var xhr =null;

function startRequest() {
	// alert("ok");
	
	// XMLHTTPRequest 객체 생성
	
	if (window.XMLHttpRequest) {
	    // code for modern browsers
	    xhr = new XMLHttpRequest();
	 } else {
	    // code for old IE browsers
	    xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}

	alert(xhr);
	xhr.open("get", "server.txt", true);  //요청방식,서버파일,비동기식 
	xhr.send();
	
	xhr.onreadystatechange = resultProcess //모든 응답이 이루어지면 ,시스템이 호출하는거 (콜백 함수)
}

function resultProcess(){
//	alert(xhr.readyState+","+xhr.status); //0: 초기화되지않음 1: open메소드 호출     2:send메소대 호출      3:수신중         4:수신완료 
	if(xhr.readyState==4 && xhr.status==200){
	//	alert(xhr.responseText);
	var resultDisp=document.getElementById("resultDisp");
	resultDisp.innerHTML=xhr.responseText;
	}
	
}
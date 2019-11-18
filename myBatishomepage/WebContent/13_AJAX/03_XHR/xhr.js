/**
 * 
 */

var xhr=null;

function createXHR(){
	if (window.XMLHttpRequest) {
	    xhr = new XMLHttpRequest();
	 } else {
	    xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}

	
}


function startRequest() {
	createXHR();
	
//	xhr.open("get","http://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109", true); //외부사이트를 파싱해올때 체크를 해봐야됨 0이넘어오면 프록시작업
	xhr.open("get" ,"responseXML.xml",true);
	xhr.send();
	xhr.onreadystatechange=resultProcess;
	
	
}




function resultProcess(){
	if(xhr.readyState==4 &&xhr.status ==200){
		alert(xhr.responseXML);
		var xmlDoc =xhr.responseXML;
		var studentList =xmlDoc.getElementsByTagName("student");
//		alert(studentList.length); 	//단계별로 진행 뽑아오는지 확인하고
		for(var i=0; i<studentList.length; i++){
			var student = studentList[i];
			var subElement = student.childNodes;
			var divNode = document.createElement("div");
			
			for(var j=0; j<subElement.length; j++){
				if(subElement[j].nodeType==1){
					var spanNode = document.createElement("span");
					spanNode.innerHTML= subElement[j].childNodes[0].nodeValue;
					divNode.appendChild(spanNode);
					alert(subElement[j].childNodes[0].nodeValue);
					
				}
			}
				document.getElementById("divResult").appendChild(divNode);
			}
		
		}
	}


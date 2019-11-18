/**
 * 
 */
var root =null;


function writeToServer(requestRoot){
	var writeReply=document.getElementById("writeReply").value;
	// alert(writeReply);
	root = requestRoot;
	
	var url = root + "/reply/replyWrite.do";
	
	var params="writeReply="+writeReply;
	
	
		sendRequest("POST",url,writeFromServer,params);
	
}


function writeFromServer(){
	
	if(xhr.readyState==4 && xhr.status==200){
		
		// alert(xhr.responseText);
		
		var result =xhr.responseText.split(","); //split반환 - 배열
		var bunho = result[0].trim(); //공백이 들어갈때 trim() ,문자열 공백제거
		var reply = result[1].trim();
		
		document.getElementById("writeReply").value=""; //댓글입력후 남아있는값 지우기
		
		var listAllDiv=document.getElementById("listAllDiv");
		var div= document.createElement("div");
		div.className="replyDiv"; //css 값을 가져옴
		div.id=bunho;			//번호로잡아야 수정 삭제
		
		var spanBunho=document.createElement("span");
		spanBunho.className="cssBunho";
		spanBunho.innerHTML=bunho;
		
		var spanReply=document.createElement("span");
		spanReply.className="cssReply";
		spanReply.innerHTML=reply;
		
		var spanUpDel=document.createElement("span");
		spanUpDel.className="cssUpDel";
		
		var aDelete=document.createElement("a");
	//	aDelete.href=
	//		"javascript:deleteToServer("+bunho+",\'"+root+"\')";  // /mybatishomepage로넘어오므로 특수문자 처리 \'  \'  , js에서는 예외적으로 쌍따옴표 (쌍따옴표) 받아주는거같음
		aDelete.href=
			"javascript:deleteToServer('"+bunho+"','"+root+"')";	//2가지 방법 이렇게해도 \없어짐
		
		aDelete.innerHTML="삭제&nbsp;&nbsp;";
	
		var aUpdate=document.createElement("a");
		aUpdate.href=
			"javascript:UpdateToServer('"+bunho+"','"+root+"')";
		aUpdate.innerHTML="수정";
		
		spanUpDel.appendChild(aDelete);
		spanUpDel.appendChild(aUpdate);
		
		div.appendChild(spanBunho);
		div.appendChild(spanReply);
		div.appendChild(spanUpDel);
		
		listAllDiv.appendChild(div);
		listAllDiv.insertBefore(div, listAllDiv.childNodes[0]);
		
	}
	
	
}
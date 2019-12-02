/**
 * 
 */

function UpdateToServer(bunho,value){
	//alert(bunho + "," +root);
	
	var url = root + "/reply/update.do";
	var params="bunho="+bunho+"&lineReply="+value;
	
	sendRequest("GET",url,updateFromServer,params);

}




function updateFromServer(){
	if(xhr.readyState==4 && xhr.status==200){
		// alert(xhr.responseText);
		var divBunho =	document.getElementById(xhr.responseText);
		var listAllDiv=document.getElementById("listAllDiv");
//		var bunho =
		var spanNode= document.createElement("span");
		var inputNode=document.createElement("input");
		inputNode.type="text";
		var inputNodeType=document.createElement("input");
	//	inputNodeType.type="button";
	//	inputNodeType.value="수정";
		//inputNodeType.setAttribute("onclick","UpdateOkToServer('"+bunho+"','"+root+"','"+line_reply+"')");
		
		//sendRequest("GET",url,UpdateOkToServer,params);
		
		
		
		divBunho.appendChild(spanNode);
		divBunho.appendChild(inputNode);
		divBunho.appendChild(inputNodeType);
		
		
		
		//listAllDiv.replaceChild(divBunho);
		
				//<span> <input> 붙여줘야되고
	}
	
	/*
	function UpdateOkToServer(bunho,root,line_reply){
		//alert(bunho + "," +root);
		
		var url = root + "/reply/updateOk.do";
		var params="bunho="+bunho+"line_reply="+line_reply;
		
		sendRequest("GET",url,updateFromServer,params);

	}

}*/
}
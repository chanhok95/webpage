/**
 * 
 */
var root =null;


function writeToServer(requestRoot){
	root = requestRoot;
	
	var writeReply=$("#writeReply").val();
	
	
	var url = root + "/reply/replyWrite.do?"+params;
	
	var params="writeReply="+writeReply;
	
	//alert(root+","+url+","+params);
	$.ajax({
		url:url,
		type: "get",
		dataType: "text",
		success: writeFromServer,
		
		error:function(xhr,status,error){
			alert(xhr+","+status+","+error);
		
		
		}
		
		
	})
	
}


function writeFromServer(data){
		// alert(xhr.responseText);
		
	
	
		var result =data.split(','); //split반환 - 배열
		var bunho = result[0].trim(); //공백이 들어갈때 trim() ,문자열 공백제거
		var reply = result[1].trim();
		alert(bunho+","+reply);
		
	
	
}
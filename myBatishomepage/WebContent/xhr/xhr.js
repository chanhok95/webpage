/**
 * 
 */

var xhr= null;

function createXHR(){
	if(window.XMLHttpRequest){
		return new XMLHttpRequest;
	}else {
		return new  ActiveXObject("Microsoft.XMLHTTP");
	}
	
}


function sendRequest(method,url,callback,params){
	 //("POST","server.jsp",fromServer,params)
	var httpMethod = method.toUpperCase();
	
	if(httpMethod != "GET" && httpMethod != "POST"){
		httpMethod="GET";
		
	}
	var httpParams = (params == null || params == "") ? null :params;
	
	var httpUrl = url;
	
	if(httpMethod == "GET" && httpParams != null){ 
		httpUrl += "?" + httpParams;
		
	}
	
// alert("httpMethod ->"+httpMethod +"httpParams ->"+ httpParams +"httpUrl->"+httpUrl );
	
	xhr=createXHR();
	xhr.open(httpMethod, httpUrl,true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(httpMethod=="POST" ? httpParams : null);
	xhr.onreadystatechange=callback;
	
}
/**
 * 
 */

function createXhr(){
	if(window.XMLHttpRequest){
		return new XMLHttpRequest;
	}else{
		return new  ActiveXObject("Microsoft.XMLHTTP");
	}
	
}

var xhr =null;

function sendRequest(method,url,callback,param){
		//("get","server.txt",fromServer,null) 데이터가 넘어옴
	var httpMethod = method.toUpperCase(); // 영문 문자열 대소문자변환
	if(httpMethod !="GET" && httpMethod !="POST"){
		httpMethod="GET";
	}
	
	var httpParam=(param==null || param =="")? null :param;
	var httpUrl = url;
	if(httpMethod=="GET" && httpParam != null){
		httpUrl += "?"+httpParam;
	}
	
	xhr = createXhr();
	xhr.open(httpMethod,httpUrl,true);
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send(httpMethod=="POST" ? httpParam:null );
	xhr.onreadystatechange=callback;
}
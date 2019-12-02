<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${root}/xhr/jquery-3.4.1.js"></script>
<script type="text/javascript">
	
	$(function (){
		
		$.ajax({
			
			
				url:"${root}/pXML.do",
				type:"get",
				dataType: "xml",
				success: function(data){
					//alert("ok");
				//	 if ( $(data).find('data').length > 0 ) {
				//	var descripton= $(data).find("description");
					
				//		$(descripton).each(function() {
						$(data).find("description").each(function(){	
					//		alert( $(this).find('mode').text() ) ;
					//		alert( $(this).find('tmEf').text() ) ;
					//		alert( $(this).find('wf').text() ) ;
					//		alert( $(this).find('tmn').text() ) ;
					//		alert( $(this).find('tmx').text() ) ;
					//	var text = "<span>"+data.mode+"</span>&nbsp;&nbsp;";
					//	var mode =$(this).find("mode").text();
					//	 mode +=$(this).find("tmEf").text();
					//	 mode +=$(this).find("wf").text();
					//	 mode +=$(this).find("tmn").text();
					//	 mode +=$(this).find("tmx").text();
						
					var text= $(this).find("wf:eq(0)").text();
					
					//alert(text);
					
						$("#resultDisp").append(text);
						
					})
					
					
					
				//} 
					
					
				}
			
			
		});
		
		
	});

</script>


</head>
<body>
 <div id="resultDisp"></div>
</body>
</html>
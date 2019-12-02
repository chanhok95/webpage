/**
 * 
 */

function deleteToServer(bunho, root) {
	// alert(bunho +"," + root);

	var updateReply = $("#updateReply").val();
	var params = "bunho=" + bunho; // 

	var url = root + "/reply/delete.do?" + params;

	$.ajax({
		url : url,
		type : "get",
		dataType : "text",
		success : deleteFromServer,
		error : function(xhr, status, error) {
			alert(xhr + "," + status + "," + error);

		}

	});

}

function deleteFromServer(data) {
	// alert("sds");
	$("#" + data).remove();

}
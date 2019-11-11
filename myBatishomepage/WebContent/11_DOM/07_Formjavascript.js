/**
 * 
 */
function checkForm(obj) { // obj =this=form
	if (obj.irum.value == "") {
		window.alert("이름을 입력하세요");
		obj.irum.focus();
		return false;
	}
	if (obj.siteurl.value == "") {
		window.alert("이동할 사이트를 선택하세요");
		obj.siteurl.focus();
		return false;
	}
	var test = false;
	for (var i = 0; i < obj.fruit.length; i++) {
		if (obj.fruit[i].checked == true)
			test = true;
	}
	if (test == false) {
		window.alert("좋아하는 과일을 선택하세요.");
		return false;
	}
	var count = 0;
	var str = "";
	for (var i = 0; i < obj.interset.length; i++) {
		if (obj.interset[i].checked == true) {
			str += obj.interset[i].value + ",";
			++count;
		}
	}
	if (count == 0) {
		window.alert("취미를 하나라도 선택해주세요.");
		return false;
	}
//	 window.alert(str);

	obj.result.value = str;
}
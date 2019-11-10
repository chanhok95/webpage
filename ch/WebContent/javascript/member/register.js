/**
 * 
 */

/**
 * @param  유효성검사는 마지막에 확인후 주석걸고 
 * @returns
 */
function registerForm(obj) {
	// alert("ok");

	if (obj.id.value == "") {
		window.alert("아이디를 입력하세요.");
		obj.id.focus();
		return false;
	}
	
	if (obj.password.value == ""){
		window.alert("비밀번호를 입력하세요.");
		obj.password.focus();
		return false;
	}
	
	if (obj.passwordCheck.value != obj.password.value){
		window.alert("비밀번호를가 같지 않습니다.");
		obj.passwordCheck.focus();
		return false;
	}
	
	if (obj.name.value == ""){
		window.alert("이름을 입력하세요.");
		obj.name.focus();
		return false;
	}

	
	if (obj.born.value == ""){
		window.alert("생년월일을 입력해주세요.");
		obj.born.focus();
		return false;
	}
	
	if (obj.month.value == "none"){
		window.alert("월을 입력해주세요.");
		obj.month.focus();
		return false;
	}
	
	if (obj.gender.value == "nonee"){
		window.alert("성별을 입력해주세요.");
		obj.gender.focus();
		return false;
	}
	
	
	if (obj.year.value == ""){
		window.alert("생년월일을 입력해주세요.");
		obj.year.focus();
		return false;
	}
	
	
	if (obj.email.value == ""){
		window.alert("이메일 번호를 입력해주세요.");
		obj.email.focus();
		return false;
	}
}


	
	

function idCheck(obj, root) {
	// alert(obj.id.value);

	if (obj.id.value == "") {
		alert("아이디를 반드시 입력하세요.");
		obj.id.focus();
		return false;
	}

	var url = root + "/member/idCheck.do?id=" + obj.id.value;
	// alert(url);
	var popupX = (document.body.offsetWidth / 2) - (400 / 2);
	var popupY= (document.body.offsetHeight / 2) - (100 / 2);
	
	open(url, "",  ' status=no, height=100, width=400, scrollbars=yes left='+ popupX + ', top='+ popupY);
}



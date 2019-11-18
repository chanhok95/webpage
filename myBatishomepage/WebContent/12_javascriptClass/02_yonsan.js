/**
 * 
 */

Younsan = function(su, buho, value) {

	this.su = parseInt(su);
	this.buho;
	this.value = parseInt(value);
	this.result = 0;
}

Younsan.prototype.disp = function() {
	var r = document.getElementById("result");
	r.innerHTML = this.result;
}

Younsan.prototype.calculate = function() {
	if (this.buho == "+") {
		this.result = this.su + this.value;
	} else if (this.buho == "-") {
		this.result = this.su - this.value;
	} else if (this.buho == "*") {
		this.result = this.su * this.value;
	} else if (this.buho == "/") {
        if (this.value != 0 || this.su != 0) this.result = this.su / this.value;
	} else {
			alert("사칙연산만 가능합니다");
	}

}

/**
 * 자바스크립트 클래스 만들기
 * 클래스이름 = function(파라미터) {}
 * 클래스이름.prototype.함수명=function(파라미터) {}
 */

Fruit=function(){
	this.msg="마있는";
};

Fruit.prototype.taste=function(){
	var str ="과일";
	alert(this.msg+str); //this 생략 불가능
};

Fruit.prototype.disp=function(msg){
	alert(msg);
};


//★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★

Apple =function(){};

Apple.prototype =new Fruit(); //상속

Apple.prototype.taste=function(){ //함수 재정의
	var str="사과";
	alert(this.msg+str);
}; 

Apple.prototype.abc=function(){
	alert("msg Function");
};
//★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★

Orange=function(){};

Orange.prototype = new Fruit();

Orange.prototype.taste=function(){
	var str="오렌지";
	alert(this.msg+str);
};

Orange.prototype.ef=function(){
	alert("msg orange")
}


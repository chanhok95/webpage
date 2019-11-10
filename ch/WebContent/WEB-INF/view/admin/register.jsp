<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}" /> 
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
var hobby0 = new Array("-선택-","");
var hobby1 = new Array("숏패딩","후리스","맨투맨","후드티","롱패딩","니트","코트","플리스");
var hobby2 = new Array("데님 팬츠","트레이닝팬츠","코튼 팬츠","쇼트 팬츠","수트 팬츠","슬랙스");
var hobby3 = new Array("구두","부추","보트","힐","샌들");
var hobby4 = new Array("디지털","오토매틱","퀴츠 아날로그","기타");

function hobbychange(item){
    var temp, i=0, j=0;
    var ccount, cselect;

    temp = document.signform.cateCode;

    for (i=(temp.options.length-1) ; i>0 ; i--){ temp.options[i] = null; }
    eval('ccount = hobby' + item + '.length');
    for (j=0 ; j<ccount ; j++) {
        eval('cselect = hobby' + item + '[' + j + '];');
        temp.options[j]= new Option(cselect,cselect); 
    }
    temp.options[0].selected=true;
    return true;
}



</script>
</head>
<body>
<form role="form" method="post" autocomplete="off" name="signform" action="${root }/admin/registerOk.do">

<div class="inputArea"> 
 <label>대분류</label>
 <select class="category1" name="bighobby" 
 onChange=javascript:hobbychange(document.signform.bighobby.options.selectedIndex)>
<option selected value="">-선택-</option>
			<option value=상의>상의</option>
			<option value=하의>하의</option>
			<option value=신발>신발</option>
			<option value=시계>시계</option>
			
 </select>

 <label>소분류</label>
 <select class="category2" name="cateCode">
  <option selected value="">-선택-</option>
  <option value="">-선택-</option>
  
 </select>
</div>

<div class="inputArea">
 <label for="gdsName">상품명</label>
 <input type="text" id="gdsName" name="name" />
</div>

<div class="inputArea">
 <label for="gdsPrice">상품가격</label>
 <input type="text" id="gdsPrice" name="price" />
</div>

<div class="inputArea">
 <label for="gdsStock">상품수량</label>
 <input type="text" id="gdsStock" name="stock" />
</div>

<div class="inputArea">
 <label for="gdsDes">상품소개</label>
 <textarea rows="5" cols="50" id="gdsDes" name="des"></textarea>
</div>

	  <div class="inputArea">
 <label for="gdsDes">이미지</label>
<input type="file" name="img" value="img">
</div>  


<div class="inputArea">
 <button type="submit" id="register_Btn" class="btn btn-primary">등록</button>
 <input type="reset" value="취소"> 
</div>

</form>
</div>
</body>
</html>
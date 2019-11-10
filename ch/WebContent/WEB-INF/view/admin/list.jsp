<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
 <thead>
  <tr>
   <th>번호</th>
   <th>이름</th>
   <th>카테고리</th>
   <th>가격</th>
   <th>수량</th>
   <th>이미지</th>
   <th>등록날짜</th>
  </tr>
 </thead>
 <tbody>
  <c:forEach items="${boardList}" var="list">
  <tr>
   <td>${list.num}</td>
   <td>${list.name}</td>
   <td>${list.cateCode}</td>
   <td>${list.price}</td>
   <td>${list.stock}</td>
   <td>${list.des}</td>
   <td>${list.img}</td>
   <td>${list.registerDate}</td>
  </tr>   
  </c:forEach>
 </tbody>
</table>
</body>
</html>
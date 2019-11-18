<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX DB</title>
</head>
<body>
	<table border="1" width="600" cellpadding="0" cellspacing="0">
		<tr>
			<td align="center" bgcolor="#DEDEDE" width="100">사번</td>
			<td align="center" bgcolor="#DEDEDE" width="100">이름</td>
			<td align="center" bgcolor="#DEDEDE" width="100">입사일</td>
			<td align="center" bgcolor="#DEDEDE" width="100">직종</td>
			<td align="center" bgcolor="#DEDEDE" width="100">급여</td>
			<td align="center" bgcolor="#DEDEDE" width="100">부서번호</td>
			<td align="center" bgcolor="#DEDEDE" width="100">부서명</td>
		</tr>
		<c:forEach var="sawonDto" items="${sawonList}">
			<tr>
				<td width="100" align="center">${sawonDto.employeeId}</td>
				<td width="100" align="center">${sawonDto.firstName}</td>
				<td width="100" align="center">
					<fmt:formatDate value="${sawonDto.hireDate}" pattern="yyyy-MM-dd hh:mm:ss" /> </td>
				<td width="100" align="center">${sawonDto.jobId}</td>
				<td width="100" align="center">${sawonDto.salary}</td>
				<td width="100" align="center">${sawonDto.departmentId}</td>
				<td width="100" align="center">${sawonDto.departmentName}</td>
		
		</c:forEach>
	</table>

</body>
</html>
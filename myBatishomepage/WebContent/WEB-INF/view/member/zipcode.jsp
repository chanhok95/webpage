<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath }" />
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${root }/javascript/member/register.js"></script>
</head>
<body>
	<div align="center">
		<form action="${root }/member/zipcode.do" method="get">
			<table>
				<tr>
					<td><input type="text" name="dong" /> <input type="submit"
						value="검색" /></td>
				</tr>
			</table>
		</form>

		<table>
			<c:if test="${zipcodeList.size()==0 }">
				<tr>
					<td>검색된 결과가 없습니다.</td>
				</tr>
			</c:if>
			<c:if test="${zipcodeList.size() > 0 }">
				<tr>
					<td>아래의 우편번호를 클릭하세요.</td>

				</tr>
				<c:forEach var="zipcodeDto" items="${zipcodeList}">
					<tr>
						<td><a href="javascript:sendAddress(
								'${zipcodeDto.zipcode}', '${zipcodeDto.sido }', '${zipcodeDto.gugun }',
								'${zipcodeDto.dong }', '${zipcodeDto.ri }', '${zipcodeDto.bunji }')">
								
								 <%-- el에서는 getter 안씀   --%>
								
								
								${zipcodeDto.zipcode} ${zipcodeDto.sido } ${zipcodeDto.gugun }
								${zipcodeDto.dong } ${zipcodeDto.ri } ${zipcodeDto.bunji }
						</a>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</table><br/><br/>
		<a href="javascript:self.close()">닫기</a>
	</div>
</body>
</html>
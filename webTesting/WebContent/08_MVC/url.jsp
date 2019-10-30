<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>URL-Pattern 디렉토리 패턴 방식</h3>
		<div>디렉토리 형태로 서버의 해당 컴포넌트를 찾아서 실행하는 구조이다.
		보안에 취약 , 한곳에 처리를 한다. 즉 요청하는 서블릿 파일 다만들어야한다
		현재는 사용 안하는 방식 (현재는 사용안함 - 이해를돕기위해) 
		</div>
	<br/><br/><br/>
	<a href="http://localhost:8181/webTesting/com/java/mvc02/ABC">서버 요청-/com/java/mvc02/ABC </a><br/> <!--  -->

	<a href="http://localhost:8181/webTesting/aa/bb/cc/dd/ABC">서버 요청-/aa/bb/cc/dd/ABC</a><br/>

	<a href="http://localhost:8181/webTesting/Teacher">서버 요청-/Teacher</a><br/>
	<br/><br/>
	<h3>URL-Pattern 확장자 패턴</h3>
	<div>확장자 형태로 서버의 해당 컴포넌트를 찾아서 실행하는 구조</div>
	<a href="http://localhost:8181/webTesting/aa/bb/cc/dd/xx/kk/ABC.a">서버 요청-/aa/bb/cc/dd/xx/kk/ABC.a</a><br/>

	<a href="http://localhost:8181/webTesting/xx/yy/zz/kk/tt/ll/XYZ.a">서버 요청-/xx/yy/zz/kk/tt/ll/XYZ.a</a><br/>
	<br/><br/>
	
	<h3>글쓰기 / 글읽기</h3>
	<a href="http://localhost:8181/webTesting/write.kitri">글쓰기</a>&nbsp;&nbsp;
	<a href="http://localhost:8181/webTesting/list.kitri">글읽기</a><br/>
	<br/><br/>
	
	<h3>글쓰기 / 글읽기</h3>
	<a href="http://localhost:8181/webTesting/write.action">글쓰기</a>&nbsp;&nbsp;
	<a href="http://localhost:8181/webTesting/list.action">글읽기</a><br/>
	<br/><br/>
	
	
</body>
</html>
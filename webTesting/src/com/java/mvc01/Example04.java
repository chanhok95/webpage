package com.java.mvc01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example04
 */
public class Example04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example04() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * response 객체 : 페이지 contextType 설정,출력기능 ,리다이렉트 하기
		 * 쿠키 쓰기기능 /읽기(request), 헤더 정보 입력 :(쓰기) -파일입출력시  
		 * */
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println(id + "\t"+ pwd);
		
			//DB 연결 (가정)
		String dbid = "abc123";
		String dbpwd = "abc123";
		
		String contexPath = request.getContextPath();
		if(id.equals(dbid) && pwd.equals(dbpwd)) {
			// 로그인 성공페이지
		response.sendRedirect(contexPath +"/com/java/mvc01/Example04_Succese"); // 원하는 데이터 전송시 get방식 사용 URL?su=4&value=10 
		}else {
			//로그인 실패페이지
		response.sendRedirect(contexPath+"/com/java/mvc01/Example04_Falied");
		}
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.java.mvc01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Example07_SessionSet
 */
public class Example07_SessionSet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example07_SessionSet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*
	 * 세션도 쿠키와 마찬가지로 sessionScope이다. : 해당 프로젝트(context)에서 데이터를 주고받는거 없이 다 사용할수있다
	 * 쿠키와 달리 클라이언트의 특정 위치에 저장되는 것이 아니라, 서버상에 객체로 존재한다.
	 * 따라서 세션은 서버에서만 접근이 가능하고 보안이 좋고, 저장 할 수있는 데이터에 한계가 없다.
	 * (참고로 쿠키는 용량제한 4KB로 용량이 제한적이며 , 300개 까지 데이터 정보를 가질수 있다.)
	 * 
	 *  세션스코프 - 웹페이지단위 꺼지면 기록이 사라지고 (서버) // 어플리케이션스코프 -게속 살아있는  // requestscope
	 * */
		
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	System.out.println(id + "\t" +pwd);
	
	HttpSession session = request.getSession(); // 현재 session이 존재하면 session 리턴 , 존재하지않으면 내부적으로 새로운 session 리턴
	
	String msg="";
	if(!session.isNew()) {  //isNew 만들어졋는지 확인 웹페이지를 닫으면 세션초기화

		session.setAttribute("id", id);	    //항상 집어넣는건 Set key,value
		session.setAttribute("pwd", pwd);
		session.setMaxInactiveInterval(60*20); // 세션시간 20분
		msg="세션객체가 생성되었습니다.";
	}else {
		System.out.println("세션객체가 이미 생성되어 있음.");
	}
		
	
		//응답
	
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head><title></title></head>");
		out.print("<body>");

		out.print("<script type='text/javascript'>"); 
		out.print("alert('"+msg+"');");

		String contextpath= request.getContextPath();
		out.print("location.href='"+contextpath+"/06_Servlet/example07.html';");
		out.print("</script>");
		
		out.print("</body>");
		out.print("</html>");
		out.close();
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

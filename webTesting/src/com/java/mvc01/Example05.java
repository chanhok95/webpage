package com.java.mvc01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example05
 */
public class Example05 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// private int su; Example05에 사용하는 변수 pageScope 
	// 데이터 전달시 request 객체 파라미터로 전달  requestScope
	//	SessionScope , ApplicationScope
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example05() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//include   값을 전달하고 다시 돌아오는
		/*	페이지이동 / 페이지전달:response.sendRedirect() /URL?전달
		 * 					include() / request , response
		 * 					forward() / request , response
		 * 					
		 * */
		
		
		Cookie[] cookies = request.getCookies();
		System.out.println("쿠키값"+cookies.length);
		
		//요청
		request.setCharacterEncoding("utf-8");
		String message = request.getParameter("message");
		System.out.println(message);
		
		//응답
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head><title></title></head>");
		out.print("<body>");
		
		RequestDispatcher rd=
				request.getRequestDispatcher("/com/java/mvc01/Example05_sub");
		rd.include(request, response); // 해당 페이지호출후 다시 호출한 곳으로 돌아온다.
		out.print("<hr width='400px' align='center' color='red'/>");
		
		request.setAttribute("name", "홍길동");	//값을 보내주는 key ,value
		rd.include(request, response);			// 전송
		out.print("<hr width='400px' align='center' color='blue'/>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//forward	값을 전달하고 다시 오지않는
		request.setCharacterEncoding("utf-8");
		String message = request.getParameter("message");
		System.out.println(message);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head><title></title></head>");
		out.print("<body>");
		
		RequestDispatcher rd=
				request.getRequestDispatcher("/com/java/mvc01/Example05_sub");
		request.setAttribute("name", "홍길동"); //key , value 
		rd.forward(request, response);
		out.print("<hr width='400px' align='center' color='red'/>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

}

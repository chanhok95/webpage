package com.java.mvc01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example06_CookieGet
 */
public class Example06_CookieGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example06_CookieGet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Cookie[] cookies=request.getCookies();
		
		//응답
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		out.print("<html>");
		out.print("<head><title></title></head>");
		out.print("<body>");
		
		String imgStr="";
		if(cookies !=null) {
			for(int i=0; i<cookies.length; i++) {
				out.print("<h3>"+cookies[i].getName()+"</h3>");
				out.print("<h3>"+cookies[i].getValue()+"</h3>");
			}
			String contextpath = request.getContextPath();
			for(int i=0; i<cookies.length; i++) {
				imgStr = contextpath + "/images/"+ cookies[i].getValue()+".jpg";
				out.print("<img src ='"+imgStr+"'+width='150' height='100' /><br/><br/>"); //홀따옴표 쌍따옴표 개념
			}
			
		}else {
			out.print("<h3>장바구니에 아무것도없습니다 </h3>");
		}
		
		out.print("</body>");
		out.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

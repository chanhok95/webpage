package com.java.mvc01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example06
 */
public class Example06_CookieSet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example06_CookieSet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String[] fruit = request.getParameterValues("fruit"); //checkbox name=fruit 배열로 받아와야
		System.out.println(fruit.length);
		
		//sessionsocope : 해당 프로젝트(context)에서 데이터를 주고받는거 없이 다 사용할수있다.
		if(fruit.length !=0) {
			for(int i=0; i<fruit.length; i++) {
				String key = "fruit" + i;
				
				Cookie cookie = new Cookie(key, fruit[i]); //쿠키 궁금하면 api보기
				cookie.setMaxAge(60*20); //20분   초 *분 *시 *일 (60*60*2 = 2시간) (60 * 60*24 *365)
				response.addCookie(cookie); //사용자 웹브라우저에 쿠키폴더로 저장
			}								
		}										//Example05 cookie선언하면 쿠키값이 나옴
		//응답
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title></title></head>");
		out.print("<body>");

		out.print("<script type='text/javascript'>"); //<script type="text/javascript">
		out.print("alert('장바구니에 담겼습니다.');");// alert("장바구니에 담겼습니다.")
		String contextpath= request.getContextPath();
		out.print("location.href='"+contextpath+"/06_Servlet/example06.html';"); // 홀따옴표 봐야됨 ,
		out.print("</script>");
//		out.print("<h3> 쿠키에 저장되었습니다 </h3>");
		
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

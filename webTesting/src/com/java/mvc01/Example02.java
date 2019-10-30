package com.java.mvc01;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Example02
 */

public class Example02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Example02() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글처리안해주니까 setchar 쓸필요없음
		//무결성한 데이터만 들어와야되서 예외상황에서발생하는값들을 js에서 처리
		int su = Integer.parseInt(request.getParameter("su")); 
		String bunho =request.getParameter("bunho");
//		char ch = bunho.charAt(0);  문자열 -> 문자 둘중에한개써도됨 charAt 문자열 -> 문자
		int value = Integer.parseInt(request.getParameter("value"));
		System.out.println(su+"\t"+bunho +"\t"+value);
		
//		float result=0.0f;		
//		DecimalFormat df=null;
		String result="";
		// valueof  = String클래스의  valueof 메서드는 매개변수로 기본형 변수와 객체를 지정할 수 있으며 그 결과로 String을 얻을수있다.
		result = String.valueOf(su+value);
		
//		df = new DecimalFormat("0");
//		df.format(result);
		if(bunho.equals("+")) {
			result = String.valueOf(su+value);
		}else if(bunho.equals("-")) {
			result = String.valueOf(su-value);
		}else if(bunho.equals("*")) {
			result = String.valueOf(su*value);
		}else if(bunho.equals("/")) {
			DecimalFormat df = new DecimalFormat("0.00");
			result=df.format((float)su/value);
//			df=new DecimalFormat("0.00");
//			df.format(result);
		}
		System.out.println(result);
	//응답 
		
		response.setCharacterEncoding("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head><title></title></head>");
		out.print("<body>");
		out.print("<h3>"+su+""+bunho+""+value+"="+result+"</h3>");		
		out.print("</body>");
		out.print("</html>");
		
		out.close();		//필수
	
	}			//소수점 없애기 round ,floor ,int형변환	

	
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

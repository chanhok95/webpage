package com.java.mvc01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Example01 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// init(),service(),destory() 생략가능

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청
		req.setCharacterEncoding("utf-8"); // 인코딩작업 UTF-8 ,요청한글설정
		String name = req.getParameter("name"); // 요청데이터값
		System.out.println(name);
		// DB (패턴 사용 -나중에)

		// 응답
		// 출력 BufferdOutStream --> OutputStream --> Socket의 OutputStream				File I/O 이해안되면 책보고오기
		// 입력은 반대 Socket의 IutputStream -->IutputStream -->BufferdIutputStream
		resp.setContentType("text/html;charset=utf-8");	//text/html; 은 json이나 다른환경에서 변할수있음
		PrintWriter out = resp.getWriter();

		//↓ JAVA(개발자)+HTML(디자이너) 2개의 영역이 섞인건 잘못된것 예시(수업)을 위해 쓴거
		out.print("<html>");
		out.print("<head><title></title></head>");
		out.print("<body>");
		out.print("<h3>"+name +"</h3>");
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);

	}

}

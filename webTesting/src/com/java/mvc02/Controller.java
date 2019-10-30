package com.java.mvc02;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//frontController pattern : 사용자의 모든 요청을 하나의 서블릿에서 처리하는 형태 (확장자 패턴)

		
		//http://localhost:8181/webTesting/write.kitri
		//http://localhost:8181/webTesting/list.kitri
		String cmd = request.getRequestURI();  // /WebTesting/write.kitri   contextpath -> /webTesting
		cmd = cmd.substring(request.getContextPath().length());	
		System.out.println(cmd);		//WebTesting/ 이후 까지 잘라내기

		String view = null;
		
		if(cmd.equals("/list.kitri")) {
			//class만둘어야하는데 오늘만 이렇게 씀
			ArrayList<String> list = new ArrayList<String>();
			list.add("사과");
			list.add("바나나");
			
			view="/08_MVC/list.jsp";
			request.setAttribute("list", list);	//jsp파일에  key,value 값을 보내줌 페이지에 사과 바나나
		}
		
		else if(cmd.equals("/write.kitri")) {
			//class만둘어야하는데 오늘만 이렇게 씀
			int check=0;
			
			view="/08_MVC/write.jsp";
			request.setAttribute("checl", check);	// key , value (key->jsp받을 값 ,value java 변수) 
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(view);
		
		if(dis != null) {
			dis.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

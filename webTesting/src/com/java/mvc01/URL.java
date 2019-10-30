package com.java.mvc01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class URL extends HttpServlet {

	// init() 초기화 - service() / get(),post() - destory() 소멸

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("2-1.서비스 병행적으로 처리get---------------------------------");
		
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("2-2.서비스 병행적으로 처리post---------------------------------");
		//세션 테스트 다른곳에서 사용할때
		HttpSession session = req.getSession();

		if (!session.isNew()) {
			String id = (String) session.getAttribute("id"); // 한번 업캐스팅 되었기때문에 다운캐스팅
			String pwd = (String) session.getAttribute("pwd");
			System.out.println(id + "\t" + pwd);
		}
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("2.서비스 병행적으로 처리(get/post)---------------------------------");
		doGet(req, resp);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("3.소멸(업데이트,서버중지시)---------------------------");
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub

		System.out.println("1.초기화(최초 1번 있는지 없는지)----------------------");
	}

}

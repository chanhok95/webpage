package com.java.mvc03;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SampleCnt
 */
public class SampleCnt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SampleCnt() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cmd = request.getRequestURI();
		cmd = cmd.substring(request.getContextPath().length());
		System.out.println("cmd ->" + cmd); // 나중에 로그기능으로 대처

		String view = null;
		
		if (cmd.equals("/list.action")) {
			ListAction list = new ListAction();
			view = list.proRequest(request,response);

		} else if (cmd.equals("/write.action")) {
			WriteAction write = new WriteAction();
			view = write.proRequest(request,response);

		}
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response); // 각각의페이지를 넘어가면서 jsp페이지에 값을준다
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.java.mvc04;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CommandCtrl
 */
public class CommandCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> commandMap = new HashMap<String, Object>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommandCtrl() {
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
		System.out.println("cmd ->" + cmd);
		String view = null;

		try {
			CommandAction command = (CommandAction) commandMap.get(cmd);
			view = command.prorequst(request, response);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		  RequestDispatcher rd = request.getRequestDispatcher(view);
		  rd.forward(request, response);
		 
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		ListAction list = new ListAction();
		commandMap.put("/list.do", list);
		WriteAction write = new WriteAction();
		commandMap.put("/write.do", write);
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

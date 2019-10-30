package com.java.mvc01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class URLForm extends HttpServlet { //service , destory ,init -생략가능 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String pwd=req.getParameter("pwd");
	System.out.println(id+"\t"+pwd);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
		//doGet(req, resp);
	}

	@Override
	public void destroy() {
		System.out.println("종료 -----------------------------------");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("시작 -----------------------------------");
	}

}

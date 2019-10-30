package com.java.mvc05;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> commandMap = new HashMap<String, Object>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
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
			CommandAction ca = (CommandAction) commandMap.get(cmd);
			view = ca.actionDo(request, response);
		} catch (Throwable e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		if (view != null) {
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
	}

	/*
	 * @Override public void init() throws ServletException { ListAction list = new
	 * ListAction(); commanMap.put("/list.nhn", list); WriteAction write = new
	 * WriteAction(); commanMap.put("/write.nhn", write); }
	 */

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		String configFile = config.getInitParameter("configFile");
		System.out.println("configFile ->" + configFile);

		FileInputStream fis = null;
		BufferedInputStream bis = null;
		Properties pro = new Properties();

		try {
			fis = new FileInputStream(configFile);
			bis = new BufferedInputStream(fis, 1024); // 데이터가 많아질때 일정바이트씩 끊어서 가지고옴
			pro.load(bis);
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (bis != null)
					bis.close();
				if (fis != null)
					fis.close();

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		Set<Object> set = pro.keySet();
		Iterator<Object> keyIter = set.iterator();
		while (keyIter.hasNext()) {
			String key = (String) keyIter.next();
			String value = pro.getProperty(key);
			System.out.println("key->" + key+"\t value ->"+value+"\n\n");
			
			/* AA a= new AA(); //정적 객체생성
			 * 문자열 --> 동적 클래스 --> 동적 객체로 생성
			 * 
			 * */
			try {
				Class<?> handlerClass = Class.forName(value);
			//	Object obj = handlerClass.newInstance();
				Object obj =handlerClass.getDeclaredConstructor().newInstance();
				commandMap.put(key,obj);
					
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
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

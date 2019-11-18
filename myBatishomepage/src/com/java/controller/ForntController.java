package com.java.controller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.commad.CommandAction;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Servlet implementation class ForntController
 */
public class ForntController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ForntController.class.getName());
	private static final String logMsg = "logMsg-----------------"; // log메시지 색깔(플러그인설치)구분
	private HashMap<String, Object> commandmap = new HashMap<String, Object>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForntController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		String configFile = config.getInitParameter("configFile");
		logger.info(logMsg + configFile);

		// 서버 실제 경로 ( 다른사용자가 war파일로 풀때 돌아갈수있도록 server 설정할때 실제경로 체크해서 경로 지정해준이유)
		String path = config.getServletContext().getRealPath(configFile);
		logger.info(logMsg + path);

		FileInputStream fis = null;
		BufferedInputStream bis = null;
		Properties pro = new Properties(); // 등호 구분

		try {
			fis = new FileInputStream(path);
			bis = new BufferedInputStream(fis, 1024);
			pro.load(bis);
		} catch (Exception e) {

		} finally {
			try {
				if (bis != null)
					bis.close();
				if (fis != null)
					fis.close();
			} catch (IOException e) {
			}
		}
		Iterator<Object> keyIter = pro.keySet().iterator();
		while (keyIter.hasNext()) {
			String key = (String) keyIter.next();
			String value = pro.getProperty(key);
			logger.info(logMsg + "key ->" + key + "\t value ->" + value);

			try {			
				Class<?> hadleClass = Class.forName(value); // 동적클래스 문자열 -> 클래스 -> 객체
				Object obj =hadleClass.getDeclaredConstructor().newInstance();
				commandmap.put(key, obj); 

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
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
		logger.info(logMsg + cmd);

		String view = null;

		try {
			CommandAction command = (CommandAction) commandmap.get(cmd);
			view = command.proRequest(request, response);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	
		if (view != null) {
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
	}
		
//		if (view != null) { 템플릿 방식
//			RequestDispatcher rd = null;
//			
//			if(view.equals("/WEB-INF/view/member/idCheck.jsp") || view.equals("/WEB-INF/view/member/zipcode.jsp")) {
//				rd = request.getRequestDispatcher(view);
//			} else {
//				request.setAttribute("viewPage", view);
//				rd = request.getRequestDispatcher("/template/index.jsp");
//			}
//			rd.forward(request, response);
//		}
		
//	}
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

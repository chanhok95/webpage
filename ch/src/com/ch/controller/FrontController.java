package com.ch.controller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ch.command.CommandAction;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(FrontController.class.getName());
    private static final String logMsg = "logmsg--------------------------"; // log메시지 색깔구분
    private HashMap<String, Object> commandMap = new HashMap<String, Object>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
    }
    
    
    @Override
	public void init(ServletConfig config) throws ServletException {
    	
    	String configFile = config.getInitParameter("configFile");
    	logger.info(logMsg+configFile);
    	String path = config.getServletContext().getRealPath(configFile);
    	
    	FileInputStream fis =null;
    	BufferedInputStream bis = null;
    	Properties pro = new Properties();
    	
    	try {
			fis = new FileInputStream(path);
			bis = new BufferedInputStream(fis,1024);
			pro.load(bis);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(bis !=null)
					bis.close();
				if(fis !=null)
					fis.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
    	Iterator<Object> keyIter = pro.keySet().iterator();
    	while(keyIter.hasNext()) {
    		String key = (String) keyIter.next();
    		String value = pro.getProperty(key);
    		logger.info(logMsg+key+value);
    		
    		try {
    			Class<?> hadleClass = Class.forName(value); // (동적클래스 , 문자열 -> 클래스 -> 객체)
    			Object obj = hadleClass.getDeclaredConstructor().newInstance();
    			commandMap.put(key, obj);
    		}catch (Exception e) {
				// TODO: handle exception
    			e.printStackTrace();
    		}
    	
    	}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getRequestURI();
		cmd = cmd.substring(request.getContextPath().length()); // /ch/member/login.do -> member/login.do
		logger.info(logMsg+cmd);
		
		String view = null;
		try { 	//
			CommandAction command = (CommandAction) commandMap.get(cmd); 
			view = command.proRequest(request, response);
		} catch (Throwable e) {
			e.printStackTrace();
		}
//		if (view != null) {		//
//			RequestDispatcher rd = request.getRequestDispatcher(view);
//			rd.forward(request, response);
//		}
//	}
		if (view != null) {
			RequestDispatcher rd = null;
			
			if(view.equals("/WEB-INF/view/member/idCheck.jsp")) {
				rd = request.getRequestDispatcher(view);
			} else {
				request.setAttribute("viewPage", view);
				rd = request.getRequestDispatcher("/template/index.jsp");
				
			}
			rd.forward(request, response);
		}
		
		
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

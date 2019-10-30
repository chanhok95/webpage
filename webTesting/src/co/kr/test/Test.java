package co.kr.test;

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
 * Servlet implementation class Test
 */
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> commandMap = new HashMap<String, Object>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		String conFigFile = config.getInitParameter("conFigFile");
		System.out.println(conFigFile);
		
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		Properties pro = new Properties();
		
		try {
			fis = new FileInputStream(conFigFile);
			bis = new BufferedInputStream(fis,1024);
			pro.load(bis);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(bis != null);
					bis.close();
				if(fis != null);
					fis.close();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		Set<Object> set = pro.keySet();
		Iterator<Object> keyIter = set.iterator();
		while(keyIter.hasNext()) {
			String key = (String) keyIter.next();
			String value = pro.getProperty(key);
			System.out.println("key ->" +key +"\t value ->" + value);
			try {
				Class<?> handlerClass = Class.forName(value);
				Object obj =  handlerClass.newInstance();
				commandMap.put(key, obj);
			} catch (Exception e) {
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
		System.out.println(cmd);

		String view = null;

		try {
			InTest it = (InTest) commandMap.get(cmd);
			view = it.actiondo(request, response);
		} catch (Throwable e) {
			e.printStackTrace();

		}
		if (view != null) {
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
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

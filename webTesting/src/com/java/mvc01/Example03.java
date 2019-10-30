package com.java.mvc01;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Example03
 */
public class Example03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Example03() {
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
		/*
		 * request 객체는 웹브라우저를 통해서 서버에 어떤 정보를 요청하는 것이다. 한글 Encoding 기능 파라미터 읽기 가능
		 * 
		 * 서버와 관련된 정보읽기 기능 클라이언트정보(웹브라우저) 정보 읽기 가능 헤더 읽기 기능
		 * 
		 * 쿠키 읽기 기능
		 */
		// 한글설정 request.setCharterEncoding("utf-8")
		// 파라미터읽기 request.getParameter("name")

		// 서버와 관련된 정보읽기 기능  get =데이터를 뽑아옴/set= 뿌림
		String serverName = request.getServerName(); //서버이름 localhost
		int port = request.getServerPort();	//서버포트 8181

		// 이 두개 헷갈리면안됨 중요
		String contextPath = request.getContextPath(); //현재 작업 공간 /webTesting     root경로
		String servletPath = request.getServletPath(); //현재 서블릿의 풀패키지  		/com/java/mvc01/Example03  
		String method = request.getMethod();
		
		
		StringBuffer URL= request.getRequestURL();	//Uniform resource location	 , http:/~~~~ servlet ,http://localhost:8181/webTesting/com/java/mvc01/Example03
		String URI= request.getRequestURI();	//Uniform resource ldentifier	, webTesting~~servlet ,/webTesting/com/java/mvc01/Example03
		
		System.out.println("serverName ->" + serverName);
		System.out.println("port ->" + port);
		System.out.println("contextPath ->" + contextPath);
		System.out.println("servletPath ->" + servletPath);
		System.out.println("method ->" + method);
		System.out.println("URL ->" + URL);
		System.out.println("URI ->" + URI);
		
				// ContextPath() , ServletPath(), URL ,URI 4개는 중요 무조건 기억해야됨
		
		//클라이언트 정보
		String remodtAddr  = request.getRemoteAddr(); //클라이언트 주소 :0000001
		int remoteedPort = request.getRemotePort();
		String protocol = request.getProtocol();
		System.out.println("remodtAddr ->" + remodtAddr);
		System.out.println("remoteedPort ->" + remoteedPort);
		System.out.println("protocol ->" + protocol);
		System.out.println("\n");
		
		//헤더 읽기  resoponse 게시판 파일업로드 -> header  지금내용은 default값
		Enumeration<String> header = request.getHeaderNames();
		while(header.hasMoreElements()) {
			String key = header.nextElement();
			String value = request.getHeader(key);
			
			System.out.println(key + " :" + value);
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

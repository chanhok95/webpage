package com.java.webapp.lifecycle;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author 
 *	웹 어플리케이션 생명주기 리스너의 해당 메소드가 웹어플리케이션 시작과 종료를 호출한다. (Default)로 생성되는
 */
public class ContextListner implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("Web App End--------------------------------");

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("Web App Statrt--------------------------------");
		
		
	}

}

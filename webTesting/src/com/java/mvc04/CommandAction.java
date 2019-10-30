package com.java.mvc04;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandAction {																			
	public String prorequst(HttpServletRequest request,HttpServletResponse response) throws Throwable; 		//throwable 최상위
																											// Commend 패턴
		
	
}

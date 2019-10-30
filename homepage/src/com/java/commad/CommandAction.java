package com.java.commad;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface CommandAction {
	public static final Logger logger = Logger.getLogger(CommandAction.class.getName());
	public static final String logMsg = "logMsg-----------------"; // log메시지 색깔(플러그인설치)구분
	
	public String proRequest(HttpServletRequest request,HttpServletResponse response) throws Throwable;
		
	
}

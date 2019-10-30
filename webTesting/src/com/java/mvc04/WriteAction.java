package com.java.mvc04;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteAction implements CommandAction {
	public String prorequst(HttpServletRequest request,HttpServletResponse response) throws Throwable {
		request.setAttribute("WriteMsg", "Write");
		
		return "/09_MVC/write.jsp";
		
	}
}

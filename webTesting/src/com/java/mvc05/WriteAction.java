package com.java.mvc05;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteAction implements CommandAction {

	@Override
	public String actionDo(HttpServletRequest requst, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		requst.setAttribute("WriteMsg", "Write");
		return "/09_MVC/write.jsp";
	}

}

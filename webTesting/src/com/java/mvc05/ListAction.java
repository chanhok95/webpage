package com.java.mvc05;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListAction implements CommandAction {

	@Override
	public String actionDo(HttpServletRequest requst, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		requst.setAttribute("ListMsg", "List");
		return "/09_MVC/list.jsp";
	}

}

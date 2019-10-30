package com.java.mvc04;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListAction implements CommandAction{
	public String prorequst(HttpServletRequest request,HttpServletResponse response) throws Throwable {
		request.setAttribute("ListMsg", "list");
		return "/09_MVC/list.jsp";
	}
}

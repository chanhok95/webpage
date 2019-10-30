package com.java.mvc03;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteAction {
	public String proRequest(HttpServletRequest requst,HttpServletResponse response) {
		//DAO,DTO
		requst.setAttribute("WriteMsg", "Write page");
		
		return "/09_MVC/write.jsp";
	}
}

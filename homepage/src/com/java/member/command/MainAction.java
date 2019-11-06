package com.java.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.commad.CommandAction;

public class MainAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
	
		HttpSession session = request.getSession();
		if(!session.isNew()) {
			logger.info(logMsg+(String)session.getAttribute("id")); 
		}
		
		
		return "/WEB-INF/view/member/main.jsp";
	}

}

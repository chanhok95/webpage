package com.java.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.commad.CommandAction;
import com.java.member.dao.MemberDao;

public class DeleteOkAction implements CommandAction{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		logger.info(logMsg + id + "\t\t"+ pwd);
		
		int check = MemberDao.getInstance().deleteOk(id, pwd);
		logger.info(logMsg+check);
		
		request.setAttribute("check", check);
		
		return "/WEB-INF/view/member/deleteOk.jsp";
	
	}

}

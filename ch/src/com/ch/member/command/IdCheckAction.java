package com.ch.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ch.command.CommandAction;
import com.ch.member.dao.MemberDao;

public class IdCheckAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
	
		String id = request.getParameter("id");
		logger.info(logMsg+id);
		
		int check=MemberDao.getInstance().idCheck(id);
		logger.info(logMsg+check);		
		
		request.setAttribute("check", check);
		request.setAttribute("id", id);
		
		return "/WEB-INF/view/member/idCheck.jsp";
	}
		
		

}

package com.ch.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ch.command.CommandAction;
import com.ch.member.dao.MemberDao;

public class LoginOkAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		logger.info(logMsg + id + "\t\t"+ password);
		
		String memberLevel = MemberDao.getInstance().login(id,password);
		
		if(memberLevel !=null) {
			request.setAttribute("memberLevel", memberLevel);
			request.setAttribute("id", id);
		
		
		}
		
		
		return "/WEB-INF/view/member/loginOk.jsp";
	}

}

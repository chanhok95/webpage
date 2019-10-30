package com.java.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.commad.CommandAction;
import com.java.member.dao.MemberDao;

public class LoginOkAction implements CommandAction{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		logger.info(logMsg + id + "\t\t"+ pwd);
		
		String memberLevel = MemberDao.getInstance().login(id,pwd);
		logger.info(logMsg+memberLevel);
		
		
		if(memberLevel !=null) {
			request.setAttribute("memberLevel", memberLevel);
			request.setAttribute("id", id);
		
		
		}
		return "/WEB-INF/view/member/loginOk.jsp";
	}

}

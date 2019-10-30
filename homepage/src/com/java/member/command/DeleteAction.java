package com.java.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.commad.CommandAction;

public class DeleteAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		
		//session에서 사용중이여서 굳이입력안해도됨
		
		return  "/WEB-INF/view/member/delete.jsp";
	}

}

package com.java.fileboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.fileboard.dao.BoardDao;
import com.java.commad.CommandAction;

public class DeleteAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		int boardNumber=Integer.parseInt(request.getParameter("boardNumber"));
		
		logger.info(logMsg + boardNumber );
		
		int check = BoardDao.getInstance().delete(boardNumber);
		logger.info(logMsg+check);
		
		request.setAttribute("check", check);
		
		return "/WEB-INF/view/fileboard/delete.jsp";
	}

}

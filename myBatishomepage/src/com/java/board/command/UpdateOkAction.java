package com.java.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.board.dao.BoardDao;
import com.java.board.dto.BoardDto;
import com.java.commad.CommandAction;

public class UpdateOkAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		BoardDto boardDto = new BoardDto();
		logger.info(logMsg+request.getParameter("boardNumber"));
		
		boardDto.setBoardNumber(Integer.parseInt(request.getParameter("boardNumber")));
		boardDto.setEmail(request.getParameter("email"));
		boardDto.setContent(request.getParameter("content"));
		boardDto.setSubject(request.getParameter("subject"));
		
		logger.info(logMsg+boardDto.toString());

		int check = BoardDao.getInstance().updateOk(boardDto);
		
		logger.info(logMsg+check);
		
		request.setAttribute("check", check);
		
		return "/WEB-INF/view/board/updateOk.jsp";
	}

}

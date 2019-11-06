package com.java.fileboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.fileboard.dao.BoardDao;
import com.java.fileboard.dto.BoardDto;
import com.java.commad.CommandAction;

public class UpdateAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub

		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		int groupNumber = Integer.parseInt(request.getParameter("groupNumber"));
		int sequenceNumber = Integer.parseInt(request.getParameter("sequenceNumber"));
		int sequenceLevel = Integer.parseInt(request.getParameter("sequenceLevel"));

		logger.info(logMsg + boardNumber + groupNumber + sequenceNumber + sequenceLevel);

		BoardDto boardDto = BoardDao.getInstance().update(boardNumber);

		
		if(boardDto.getFilename() != null) {
			int index = boardDto.getFilename().indexOf("_")+1;
			boardDto.setFilename(boardDto.getFilename().substring(index));
		}
		
		logger.info(logMsg + boardNumber);
		logger.info(logMsg + boardDto);

		request.setAttribute("boardDto", boardDto);
		request.setAttribute("boardNumber", boardNumber);
		request.setAttribute("groupNumber", groupNumber);
		request.setAttribute("sequenceNumber", sequenceNumber);
		request.setAttribute("sequenceLevel", sequenceLevel);

		return "/WEB-INF/view/fileboard/update.jsp";
	}

}

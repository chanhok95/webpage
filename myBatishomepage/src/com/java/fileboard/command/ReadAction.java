package com.java.fileboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.fileboard.dao.BoardDao;
import com.java.fileboard.dto.BoardDto;
import com.java.commad.CommandAction;

public class ReadAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		int boardNumber = Integer.parseInt(request.getParameter("boardNumber"));
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		
		logger.info(logMsg+"boardNumber ->"+boardNumber+"pageNumber -> "+pageNumber);
		
		BoardDto boardDto = BoardDao.getInstance().read(boardNumber);
		
		
		request.setAttribute("boardDto", boardDto);
		request.setAttribute("pageNumber", pageNumber);
		
		if(boardDto.getFilename() != null) {
			int index = boardDto.getFilename().indexOf("_")+1;
			boardDto.setFilename(boardDto.getFilename().substring(index));
		}
		logger.info(logMsg+"boardDto.toString - >"+boardDto.toString());
		
		return "/WEB-INF/view/fileboard/read.jsp";
	}

}

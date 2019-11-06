package com.java.fileboard.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.fileboard.dao.BoardDao;
import com.java.fileboard.dto.BoardDto;
import com.java.commad.CommandAction;

public class ListAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String pageNumber = request.getParameter("pageNumber");
		if (pageNumber == null)
			pageNumber = "1";

		int currentPage = Integer.parseInt(pageNumber); // 시작 - 끝
		logger.info(logMsg +"currentPage -> " + currentPage);

		int count = BoardDao.getInstance().getCount();
		logger.info(logMsg +"count -> " +count);

		int boardSize = 10;
		int startRow = (currentPage - 1) * boardSize + 1;
		int endRow = currentPage * boardSize;

		List<BoardDto> boardList=null;
		
		
		if (count > 0) {
			boardList=BoardDao.getInstance().getBoardList(startRow,endRow);
			logger.info(logMsg +"boardList - >"+boardList.size());
		}
		
		request.setAttribute("boardSize", boardSize);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("count", count);
		request.setAttribute("boardList", boardList);

		return  "/WEB-INF/view/fileboard/list.jsp";
	}

}

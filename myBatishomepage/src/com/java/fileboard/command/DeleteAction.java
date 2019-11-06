package com.java.fileboard.command;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.fileboard.dao.BoardDao;
import com.java.fileboard.dto.BoardDto;
import com.java.commad.CommandAction;

public class DeleteAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		int boardNumber=Integer.parseInt(request.getParameter("boardNumber"));
		
		logger.info(logMsg + boardNumber );
		
		BoardDto readBoard= BoardDao.getInstance().update(boardNumber);
		
		
		int check = BoardDao.getInstance().delete(boardNumber);
		logger.info(logMsg+check);
		
		if(check >0 && readBoard.getFilename() != null) { 	
			File file = new File(readBoard.getPath());
			if(file.exists()&&file.isFile())file.delete();	//파일삭제 
				
		}
		
		
		request.setAttribute("check", check);
		
		return "/WEB-INF/view/fileboard/delete.jsp";
	}

}

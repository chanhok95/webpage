package com.java.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.commad.CommandAction;

public class WriteAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 부모글 ROOT
		int boardNumber =0;		//글번호(DB 결정)
		int groupNumber =1;		//그룹번호
		int sequenceNumber=0;	//글순서
		int sequenceLevel=0;	//글레벨
		
		if(request.getParameter("boardNumber") != null) {
			// 답글 
			boardNumber=Integer.parseInt(request.getParameter("boardNumber"));
			groupNumber=Integer.parseInt(request.getParameter("groupNumber"));
			sequenceNumber=Integer.parseInt(request.getParameter("sequenceNumber"));
			sequenceLevel=Integer.parseInt(request.getParameter("sequenceLevel"));
			
		}
		
		request.setAttribute("boardNumber", boardNumber);
		request.setAttribute("groupNumber", groupNumber);
		request.setAttribute("sequenceNumber", sequenceNumber);
		request.setAttribute("sequenceLevel", sequenceLevel);		//4개의값 히든
		
		
		return "/WEB-INF/view/board/write.jsp";
	}

}

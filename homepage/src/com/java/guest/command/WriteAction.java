package com.java.guest.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.commad.CommandAction;
import com.java.guest.dao.GuestDao;
import com.java.guest.dto.GuestDto;

public class WriteAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//list - Page 기법,	
		
		String pageNumber= request.getParameter("pageNumber");
		if(pageNumber ==null) pageNumber="1";
		
		int currentPage = Integer.parseInt(pageNumber); // 1) 요청페이지 1
		
		logger.info(logMsg+ currentPage);
		
		int boardSize = 3; // 2) 페이지당 출력할 게시물 수
		
		int starRow=(currentPage-1)*boardSize+1; 		//시작번호
		int endRow= boardSize*currentPage; 				//끝번호
		logger.info(logMsg+starRow+","+ endRow);
		
		int count = GuestDao.getInstance().getCount(); //"select count(*) from guest"
		logger.info(logMsg+ count);
		
		ArrayList<GuestDto> guestList =null;
		
		if(count > 0) {		//  위에서 실행된 count 값이 한개이상 들어오면 밑의값 실행
		guestList = GuestDao.getInstance().guestList(starRow,endRow);
		/*
		 *  select * from
		 *   (select rownum as rnum,a.* from(select * from guest order by num desc) a)
		 *   b where b.rnum >=? and b.rnum <=?   
		 *    // startRow endRow
		 * */
		logger.info(logMsg+guestList.size());
		}
		
		request.setAttribute("guestList", guestList);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("boardSize", boardSize);
		request.setAttribute("count", count);
		
		return "/WEB-INF/view/guest/write.jsp";
	
	}

}

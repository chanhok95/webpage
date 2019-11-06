package com.java.guest.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.commad.CommandAction;
import com.java.guest.dao.GuestDao;
import com.java.guest.dto.GuestDto;

public class UpdateAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		int num =Integer.parseInt(request.getParameter("num"));
		int pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
		
		logger.info(logMsg+"num ->" + num + "pageNumber ->" +pageNumber);
		
		GuestDto guestDto=GuestDao.getInstance().update(num);
		
		logger.info(logMsg+num);
		logger.info(logMsg+"guestDto - >"+guestDto);
		
		request.setAttribute("guestDto", guestDto);
		request.setAttribute("pageNumber", pageNumber);
		
		return "/WEB-INF/view/guest/update.jsp";
	}

}

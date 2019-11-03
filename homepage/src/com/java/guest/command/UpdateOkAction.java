package com.java.guest.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.commad.CommandAction;
import com.java.guest.dao.GuestDao;
import com.java.guest.dto.GuestDto;

public class UpdateOkAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		GuestDto guestDto=new GuestDto();
		logger.info(logMsg+request.getParameter("num"));
		
		
		
		
		guestDto.setNum(Integer.parseInt(request.getParameter("num")));
		guestDto.setPassword(request.getParameter("pwd"));
		guestDto.setMessage(request.getParameter("message"));
		
		logger.info(logMsg+guestDto.toString());
		
		int check=GuestDao.getInstance().updateOk(guestDto);
		logger.info(logMsg+check);
		
		int pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
		
		request.setAttribute("check", check);
		request.setAttribute("pageNumber", pageNumber);
		
		return "/WEB-INF/view/guest/updateOk.jsp";
	}

}

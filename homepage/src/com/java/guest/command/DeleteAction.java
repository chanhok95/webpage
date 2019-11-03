package com.java.guest.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.commad.CommandAction;
import com.java.guest.dao.GuestDao;

public class DeleteAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		int num= Integer.parseInt(request.getParameter("num"));
		int pageNumber = Integer.parseInt(request.getParameter("pageNumber")); // 임의의 페이지를삭제했을때 1페이지로 다시 안가게끔  ,view (hidden)
		logger.info(logMsg+"num -> "+num +"\t"+"pageNumber ->"+pageNumber);
	
		int check = GuestDao.getInstance().delete(num);
		logger.info(logMsg+check);
			
		
		request.setAttribute("check", check);
		request.setAttribute("pageNumber", pageNumber);
		
		return "/WEB-INF/view/guest/delete.jsp";
	}

}

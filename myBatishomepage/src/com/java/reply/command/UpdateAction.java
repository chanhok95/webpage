package com.java.reply.command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.commad.CommandAction;
import com.java.reply.dao.ReplyDao;
import com.java.reply.dto.ReplyDto;

public class UpdateAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		int bunho = Integer.parseInt(request.getParameter("bunho"));
		logger.info(logMsg+bunho);
		
		ReplyDto replyDto = ReplyDao.getInstance().update(bunho);
		logger.info(logMsg+replyDto.toString());
		
		if(bunho > 0) {
			response.setContentType("application/txt;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(bunho);

			
		}
		
		
		
		return null;
	}

}

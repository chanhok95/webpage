package com.java.reply.command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.commad.CommandAction;
import com.java.reply.dao.ReplyDao;
import com.java.reply.dto.ReplyDto;

public class UpdateOkAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		ReplyDto replyDto = new ReplyDto();
		replyDto.setBunho(Integer.parseInt(request.getParameter("bunho")));
		replyDto.setLine_reply(request.getParameter("line_reply"));
		logger.info(logMsg+replyDto.toString());
		
		int check = ReplyDao.getInstance().updateOk(replyDto);
		logger.info(logMsg+check);
		
		if(check > 0 ) {
			response.setContentType("application/txt;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(check);

		}
		
		return null;
	}

}

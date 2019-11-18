package com.java.reply.command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.commad.CommandAction;
import com.java.reply.dao.ReplyDao;
import com.java.reply.dto.ReplyDto;

public class ReplyWriteAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		String writeReply=  request.getParameter("writeReply"); 
		logger.info(logMsg+writeReply);
		
		ReplyDto  replyDto = new ReplyDto();
		replyDto.setLine_reply(writeReply);
		
		int check = ReplyDao.getInstance().insert(replyDto);
		logger.info(logMsg+check);
		
		if(check > 0 ) {										//JS에서 받으니까 TXT,xml,json 형식으로 데이터를 던져줘야됨
			int bunho=ReplyDao.getInstance().getBunho();
			String data=bunho+","+replyDto.getLine_reply();
			logger.info(logMsg+data);
			
			response.setContentType("application/txt;charset=utf-8"); // js로 값전달 , txt -> json,xml로 변경될수있음
			PrintWriter out = response.getWriter(); //js로 넘겨주는 매개체 xhr
			out.print(data);
		}
		
		
		
		return null;
	}

}

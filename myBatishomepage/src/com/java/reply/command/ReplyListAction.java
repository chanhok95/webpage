/**
 * 
 */
package com.java.reply.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.commad.CommandAction;
import com.java.reply.dao.ReplyDao;
import com.java.reply.dto.ReplyDto;

/**
 * @개발자  : 길찬호
 * @작성일  : 2019. 11. 14.
 * @설명  : 
 */
public class ReplyListAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
	
		List<ReplyDto> replyList = ReplyDao.getInstance().getList();
		logger.info(logMsg+replyList.size());
		
		request.setAttribute("replyList", replyList);
		
		return "/WEB-INF/view/reply/replyList.jsp";
	}

}

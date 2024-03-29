package com.java.member.command;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.java.commad.CommandAction;
import com.java.member.dao.MemberDao;
import com.java.member.dto.MemberDto;

/**
 * @개발자 : 길찬호
 * @작성일 : 2019. 10. 25.
 * @설명  :
 */

public class RegisterOkAction implements CommandAction{

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		MemberDto memberDto= new MemberDto();
		memberDto.setId(request.getParameter("id"));
		memberDto.setPassword(request.getParameter("password"));
		memberDto.setName(request.getParameter("name"));
		
		memberDto.setJumin1(request.getParameter("jumin1"));
		memberDto.setJumin2(request.getParameter("jumin2"));
		memberDto.setEmail(request.getParameter("email"));
		
		memberDto.setZipcode(request.getParameter("zipcode"));
		memberDto.setAddress(request.getParameter("address"));
		memberDto.setJob(request.getParameter("job"));
		
		memberDto.setMailing(request.getParameter("mailing"));
		memberDto.setInterest(request.getParameter("interest"));
		
		memberDto.setRegisterDate(new Date());
		memberDto.setMemberLevel("BA"); //준회원 DB에서 2바이트 
		
		logger.info(logMsg+memberDto.toString());
		
//		MemberDao memberDao = new MemberDao();
//		int check = memberDao.insert(memberDto);
		int check = MemberDao.getInstance().insert(memberDto);
		
		logger.info(logMsg+check);
		
		request.setAttribute("check", check);
		
		
		return "/WEB-INF/view/member/registerOk.jsp";
	}

}

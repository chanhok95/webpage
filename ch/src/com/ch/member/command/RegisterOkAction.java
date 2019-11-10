package com.ch.member.command;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ch.command.CommandAction;
import com.ch.member.dao.MemberDao;
import com.ch.member.dto.MemberDto;

public class RegisterOkAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		MemberDto memberDto = new MemberDto();
		memberDto.setId(request.getParameter("id"));
		memberDto.setPassword(request.getParameter("password"));
		memberDto.setName(request.getParameter("name"));
		
		memberDto.setBorn(Integer.parseInt(request.getParameter("born")));
		memberDto.setMonth(Integer.parseInt(request.getParameter("month")));
		memberDto.setYear(Integer.parseInt(request.getParameter("year")));
		
		memberDto.setGender(request.getParameter("gender"));
		memberDto.setEmail(request.getParameter("email"));
		memberDto.setMemberLevel("회원");
		memberDto.setRegisterDate(new Date());
		
		logger.info(logMsg+memberDto.toString());
		
		int check = MemberDao.getInstance().insert(memberDto);
		
		logger.info(logMsg+check);
		
		request.setAttribute("check", check);
		
		return "/WEB-INF/view/member/registerOk.jsp";
	}

}

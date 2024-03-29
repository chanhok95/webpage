package com.java.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.commad.CommandAction;
import com.java.member.dao.MemberDao;
import com.java.member.dto.MemberDto;

public class UpdateOkAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8"); 	//disable 데이터를 못넘겨서와서 hidden 으로 값을 받아옴
		
		MemberDto memberDto =new MemberDto();
		memberDto.setNum(Integer.parseInt(request.getParameter("num")));
//		memberDto.setId(request.getParameter("id"));
		memberDto.setPassword(request.getParameter("password"));
		memberDto.setEmail(request.getParameter("email"));
		
		memberDto.setZipcode(request.getParameter("zipcode"));
		memberDto.setAddress(request.getParameter("address"));
		memberDto.setJob(request.getParameter("job"));
		
		memberDto.setMailing(request.getParameter("mailing"));
		memberDto.setInterest(request.getParameter("interest"));
	
		logger.info(logMsg+memberDto.toString());
		
		int check = MemberDao.getInstance().updateOk(memberDto);
		logger.info(logMsg+check);
		
		request.setAttribute("check", check);
		
		
		return "/WEB-INF/view/member/updateOk.jsp";
	}

}

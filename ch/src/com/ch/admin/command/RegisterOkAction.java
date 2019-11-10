package com.ch.admin.command;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ch.admin.dao.AdminDao;
import com.ch.admin.dto.AdminDto;
import com.ch.command.CommandAction;

public class RegisterOkAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		AdminDto adminDto = new AdminDto();
		
		adminDto.setName(request.getParameter("name"));
		adminDto.setCateCode(request.getParameter("cateCode"));
		
		adminDto.setPrice(Integer.parseInt(request.getParameter("price")));
		adminDto.setStock(Integer.parseInt(request.getParameter("stock")));
		adminDto.setDes(request.getParameter("des"));
		
		adminDto.setImg(request.getParameter("img"));
		adminDto.setRegisterDate(new Date());
		
		logger.info(logMsg+adminDto.toString());
		
		int check = AdminDao.getInstance().insert(adminDto);
		
		logger.info(logMsg+check);
		
		request.setAttribute("check", check);
		
		return "/WEB-INF/view/admin/registerOk.jsp";
	}

}

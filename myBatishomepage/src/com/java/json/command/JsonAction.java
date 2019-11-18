package com.java.json.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.commad.CommandAction;

public class JsonAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String msg=request.getParameter("msg");
		
		if(msg.equals("obj")) {
			
			return "/WEB-INF/view/json/jsonobj.jsp";
		}else if(msg.equals("array")){
			return "/WEB-INF/view/json/jsonArray.jsp";
		}else if(msg.equals("objArray")) {
			return "/WEB-INF/view/json/jsonobjArray.jsp";
		}else {
			return null;
		}
		
		
	}

}

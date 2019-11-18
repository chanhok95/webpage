package com.java.json.command;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

import com.java.commad.CommandAction;
import com.java.reply.dao.ReplyDao;
import com.java.reply.dto.ReplyDto;

public class JsonArrAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		List<ReplyDto> replyList = ReplyDao.getInstance().getList();
		logger.info(logMsg+replyList.size());
		
		JSONArray array = new JSONArray();
		
		for(int i=0; i<replyList.size(); i++) {
			ReplyDto replyDto = replyList.get(i);
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("bunho", replyDto.getBunho());
			map.put("line_reply", replyDto.getLine_reply());
			
			array.add(map);
		}
		String JsonText = JSONValue.toJSONString(array); //JSON형태로 변경하겠다
		logger.info(logMsg+JsonText);
		
		
		if(JsonText != null) {
			response.setContentType("application/x-json;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(JsonText);
		}
		
		return null;
	}

}

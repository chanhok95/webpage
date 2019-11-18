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

public class JsonObjArrAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		int bunho=1;
		String name = "홍길동";
		float average = 88.f;
		
		
		JSONArray array = new JSONArray();
		List<ReplyDto> replyList = ReplyDao.getInstance().getList();
		
		for(int i=0; i<replyList.size(); i++) {
			ReplyDto replyDto = replyList.get(i);
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("bunho", replyDto.getBunho());
			map.put("line_reply", replyDto.getLine_reply());
			
			array.add(map);
		} 	//JSONArray 이용 
		
		HashMap<String, Object> allmap = new HashMap<String, Object>();
		allmap.put("bunho", bunho);
		allmap.put("name", name);
		allmap.put("averge", average);
		allmap.put("reply", array);
		
		String jsonText=JSONValue.toJSONString(allmap);
		logger.info(logMsg+jsonText);
		
		if(jsonText != null) {
			response.setContentType("application/x-json;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(jsonText);
			out.close(); //이전 예제들은 안닫아줘서 무조건 닫아줘야됨
		}
		return null;
	} // JSONobj이용  
		// {"averge":88.0,"name":"홍길동","bunho":1,"reply":
		//[{"bunho":38,"line_reply":"2323"},
		//{"bunho":36,"line_reply":"23231"},
		//{"bunho":35,"line_reply":"65656"}]}

}

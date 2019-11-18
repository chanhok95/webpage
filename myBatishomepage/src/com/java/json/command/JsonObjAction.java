package com.java.json.command;

import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONValue;

import com.java.commad.CommandAction;

public class JsonObjAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int bunho=1;
		String name = "홍길동";
		float average = 88.f;
		
		String str = "\"bunho:\"" +bunho;  // java 메시지라 특수문자 처리 쌍따옴표
		logger.info(logMsg+str);
		
		HashMap<String, Object> map= new HashMap<String, Object>();
		map.put("bunho", bunho);
		map.put("name", name);
		map.put("average", average);
		
		String jsonText = JSONValue.toJSONString(map);	//JSON lib 에서 추가한 aip
		logger.info(logMsg+jsonText);
		
		if(jsonText != null) {
			response.setContentType("application/x-json;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(jsonText);
			
		}
		
		
		return null;
	}

}

package com.java.parsing.command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import com.java.commad.CommandAction;



public class ParsingXMLAction implements CommandAction {

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		//프록시 작업은: 외부서버에서 방화벽을 가지고 있는 외부와 통신을 위해서 만들어 놓은 서버
		// 			방화벽 안쪽에 있는 서버들의 외부 연결은 프록시 서버를 통해서만 이루어진다.
		// 			사이트에 바로 접속하는 것이 아니라,프록시 서버를 한 곳에서 거쳐서 가는 것이다.

		String url="http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108"; //라이브러리를 추가해줘야됨
		logger.info(logMsg+url);
		GetMethod getMethod = new GetMethod(url);
		HttpClient httpClint = new HttpClient();
		
		int statusCode = httpClint.executeMethod(getMethod);
		
		logger.info(logMsg+statusCode);
		
		if(statusCode == 200) {
			String result = getMethod.getResponseBodyAsString(); //기상청 XML데이터가 찍힘
			logger.info(logMsg+result);
			
			response.setContentType("application/xml;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(result);
			out.close();
		}
		
		
		return null;
	}

}


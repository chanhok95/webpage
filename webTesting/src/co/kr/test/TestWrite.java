package co.kr.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestWrite implements InTest {

	@Override
	public String actiondo(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setAttribute("WriteMsg", "Write페이지입니다");
			
		return "/09_MVC/write.jsp";
	}

}

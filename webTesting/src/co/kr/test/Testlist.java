package co.kr.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Testlist implements InTest {

	@Override
	public String actiondo(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setAttribute("ListMsg", "list페이지");
		
		return "/09_MVC/list.jsp";
	}

}

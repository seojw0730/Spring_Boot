package kh.mclass.demo4.common;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@Component
public class LoginInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("ㅎㅎㅎㅎ");
		
		HttpSession session = request.getSession();
		
		Object obj = session.getAttribute("sslogin");
		
		if(obj==null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return false;
		}else {
			return true;
		}
	}
}

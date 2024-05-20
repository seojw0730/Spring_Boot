package kh.mclass.bbb.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("ㅎㅎㅎㅎ");
		//session 객체 가져옴
		HttpSession session = request.getSession();
		//login처리 담당하는 사용자 정보 담은 객체 가져옴
		Object obj = session.getAttribute("sslogin");
		
		//로그인 안 한 상태
		if(obj == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			//못 지나감
			return false;
		}else {
			//지나감
			return true;
		}
	}
}

package kh.mclass.demo4.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kh.mclass.demo4.common.LoginInterceptor;
import kh.mclass.demo4.login.controller.KakaoApi;

//WebMvcConfigurer -> url 관련 설정
@Configuration
@EnableWebMvc
//@PropertySources
public class MyConfiguration implements WebMvcConfigurer {
	
//	@Bean
//	public KakaoReq getKak() {
//		new ()
//	}
	
//	@Autowired
//	private LoginInterceptor loginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HandlerInterceptor() {
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
		})
		.addPathPatterns("/**")
		.excludePathPatterns("/login")
		.excludePathPatterns("/join")
		.excludePathPatterns("/main/*", "/css/**", "/js/**", "/image/**");
		
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**", "/js/**", "/html/**", "/image/**");
	}
	
	@Bean
	public KakaoApi kakaoApi() {
		return new KakaoApi();
	}
	
}

package kh.mclass.demo5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		
		// csrf (웹 보안 공격 중 하나)
		http.csrf(a -> a.disable());
//		http.csrf(AbstractHttpConfigurer :: disable);
		
		//클릭 재킹 공격 방지 기능
		http.headers(httpSecurityHeadersConfigurer -> httpSecurityHeadersConfigurer.frameOptions(
				frameOptionsConfig -> frameOptionsConfig.sameOrigin()
				));
		
		//login + logout 을 HttpSecurity 객체에 맡김
		http.formLogin(fr -> 
				fr
//				.loginPage("/login") // 이 값은 default 값이라 url이 /login 이면 적을 필요 없음
				.loginPage("/my/login")
				.defaultSuccessUrl("home")
				.failureUrl("/my/login?error") // 오류만 뿌려주자
				.usernameParameter("memEmail")
				);
		
		//ExceptionHandling -> 
		//Spring Security 에서 필터 거는 법
//		http.addFilter(filter);
		
		
		//인터셉터
		//front 에서의 name 은 이 객체 안에 있는 이름으로 지정해줘야 함
		//http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
		// get 방식 --> 보안 X
		// <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> 이거 써줘도 됨
	}
}

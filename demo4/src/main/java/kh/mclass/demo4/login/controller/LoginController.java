package kh.mclass.demo4.login.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class LoginController {
	
	@Autowired
	private final KakaoApi kakaoApi;
	
	@Autowired
	private final NaverApi naverApi;
	
	@GetMapping("/login")
	public String loginForm(Model model) throws Exception {
		//카카오 로그인
		model.addAttribute("kakaoApiKey", kakaoApi.getApiKey());
		model.addAttribute("kakaoRedirectUri", kakaoApi.getLoginRedirectUri());
		model.addAttribute("kakaoLogoutRedirectUri", kakaoApi.getLogoutRedirectUri());
		
		//네이버 로그인
		model.addAttribute("naverClientId", naverApi.getClientId());
		model.addAttribute("naverRedirectUri", URLEncoder.encode(naverApi.getCallBackUrl(), "UTF-8"));
		return "login";
	}
}

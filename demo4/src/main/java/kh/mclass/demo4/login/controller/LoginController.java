package kh.mclass.demo4.login.controller;

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
	
	@GetMapping("/login")
	public String loginForm(Model model) {
		model.addAttribute("kakaoApiKey", kakaoApi.getApiKey());
		model.addAttribute("redirectUri", kakaoApi.getLoginRedirectUri());
		model.addAttribute("logoutRedirectUri", kakaoApi.getLogoutRedirectUri());
		return "login";
	}
}

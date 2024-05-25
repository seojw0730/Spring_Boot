package kh.mclass.demo4.login.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class KakaoController {
	
	@Autowired
	private final KakaoApi kakaoApi;
	
	@GetMapping("/map")
	public String map(Model model) {
		return "map";
	}
	
	@RequestMapping("/login/oauth2/code/kakao")
	public String kakaoLogin(@RequestParam String code) {
		//1. 인가 코드 받기
		
		//2. 토큰 받기
		String accessToken = kakaoApi.getAccessToken(code);
		
		//3. 사용자 정보 받기
		Map<String, Object> userInfo = kakaoApi.getUserInfo(accessToken);
		
		String email = (String) userInfo.get("email");
		String nickname = (String) userInfo.get("nickname");
		
		System.out.println("email = "+email);
		System.out.println("nickname = "+nickname);
		System.out.println("accessToken = "+accessToken);
		
		return "redirect:/login";
	}
}
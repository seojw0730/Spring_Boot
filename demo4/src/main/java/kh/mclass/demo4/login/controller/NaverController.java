package kh.mclass.demo4.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class NaverController {
	@Autowired
	private final NaverApi naverApi;
	
//	@RequestMapping("/login/naver/callback/redirect")
//	public String naverLogin
	
}

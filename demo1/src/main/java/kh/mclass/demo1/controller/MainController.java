package kh.mclass.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	
	@GetMapping("main/{id}")
	public String main(
			@RequestParam(name = "b") String a, 
			@PathVariable("id") String fff
			) {
		System.out.println(fff);
		return "main";
	}
	
	@PostMapping("main/{id}")
	public String mainInsert(
			@RequestParam(name = "b") String a, 
			@PathVariable("id") String fff
			) {
		System.out.println(fff);
		return "main";
	}
	
	@GetMapping("mainapi")
	public @ResponseBody String mainapi() {
		return "mainapi";
	}
}

package kh.mclass.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	@GetMapping("/main")
	public String mainMethod(Model model) {
		System.out.println("abc");
		model.addAttribute("m1", "지정값");
		return "abc";
	}
	
}

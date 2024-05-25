package kh.mclass.demo5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping("/my/test1")
	public String test1() {
		return "test1";
	}
}

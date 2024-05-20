package kh.mclass.bbb.sub;

//import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kh.mclass.bbb.sub.model.dto.TestDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
//	private TestService ts = new TestService();
	@Autowired
	private TestService testService;
	@Autowired
	private TestDto testDto;
	
	@Value("testDto.a1")
	private String ccc;
	
	//get post 막 쓰고 싶을 때 -> RequestMapping
//	@RequestMapping(method = RequestMethod.GET, path = "/test")
	//귀찮아서 나온거
	@GetMapping(path = "/test")
	public String method1(
			@RequestParam(defaultValue = "aa", required = false, name = "a")
			/* 
			 * 요즘에는 잘 안 쓰지만 구별용으로 사용 어노테이션이니까 바로 다음꺼 하나만 적용
			 * 어노테이션 쓴 상태에선 param 꼭 있어야 함 없으면 에러*/
			String asdf, 
			HttpServletRequest request, 
			HttpSession ss, 
			HttpServletResponse response
			) {
		System.out.println(testDto);
		System.out.println(asdf);
		System.out.println(ccc);
		ss.setAttribute("c", "세션");
//		request.setAttribute("serverTime", testService.method1());
//		try {
//			response.sendRedirect("test");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		return "home";
	}
}

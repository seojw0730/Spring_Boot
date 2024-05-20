package kh.mclass.demo4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kh.mclass.demo4.domain.BoardEntity;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;


@Controller
public class DemoController {
	@GetMapping("home")
	public String home() {
		return "home";
	}
	@GetMapping("board/list")
	public void boardlist(Model model, HttpSession session) {
		BoardEntity dto = new BoardEntity("1", "T1", "C1");
		model.addAttribute("board", dto);
		BoardEntity sessionDto = new BoardEntity("000", "T000000", "C00000000");
		session.setAttribute("demoSession", sessionDto);
//		return "home";
	}
	
	@GetMapping("board/{boardId}")
	public String boardRead(Model model, @PathVariable String boardId) {
		BoardEntity dto = new BoardEntity(boardId, "T"+boardId, "C"+boardId);
		model.addAttribute("board", dto);
		return "board/read";
	}
	
	@GetMapping("board/list/ajax")
	@ResponseBody//url 입력해서 들어가면 JSON 형태로 나옴
	public BoardEntity boardlistajax(Model model) {
		//DB 연동
		BoardEntity dto = new BoardEntity("2", "T2", "C2");
		return dto; //toJson 사용할 필요 없음
	}
	
}

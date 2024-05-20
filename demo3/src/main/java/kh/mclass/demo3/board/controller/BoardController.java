package kh.mclass.demo3.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.mclass.demo3.board.model.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("boardlist", boardService.selectAll());
		return "aaa";
	}
	
	@GetMapping("/{boardId}")
	public String boardAll(@PathVariable String boardId) {
		
		return "aaa";
	}
	
	@DeleteMapping("/{boardId}")
	public String delete(@PathVariable String boardId) {
		return "aaa";
	}
}

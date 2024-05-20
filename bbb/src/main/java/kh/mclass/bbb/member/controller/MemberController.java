package kh.mclass.bbb.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.mclass.bbb.member.model.dto.MemberRes;
import kh.mclass.bbb.member.model.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/list")
	public void selectList(
			Model model
			) {
		List<MemberRes> list = memberService.selectList();
		model.addAttribute("memberlist", list);
//		return "member/list";
	}
	
	@GetMapping("/one")
	public void selectOne(
			Model model, 
			String memId
			) {
//		List<MemberRes> list = memberService.selectList();
//		model.addAttribute("memberlist", list);
//		return "member/one";
	}
	
	@PostMapping("/insert")
	public String insert(
			Model model, 
			String memId
			) {
		return "redirect:/login";
	}
	
	@PostMapping("/ajax")
	@ResponseBody //이 값은 body로 실려가서 ajax로 실려간다
	public String getAjax(
			Model model, 
			String memId
			) {
		return "성공";
	}
	
}

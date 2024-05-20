package kh.mclass.demo3.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kh.mclass.demo3.board.domain.BoardEntity;
import kh.mclass.demo3.board.model.service.BoardService;

//이거 적으면 @ResponseBody 안 적어도 됨
@RestController
@RequestMapping("/board")
public class MemberController {

	@Autowired
	private BoardService boardService;
	
	//싹 다 ajax
	@GetMapping("")
	public /* @ResponseBody */ List<BoardEntity> list() {
		List<BoardEntity> boardlist = boardService.selectAll();
		return boardlist;
	}
	
	@DeleteMapping("/{boardId}")
	public ResponseEntity<List<BoardEntity>> delete(@PathVariable String boardId) {
		List<BoardEntity> boardlist = boardService.selectAll();
//		return ResponseEntity.internalServerError().build();//500
//		return ResponseEntity.notFound().build(); //404
//		return ResponseEntity.ok().body(boardlist);
		return ResponseEntity.ok(boardlist);
	}
}

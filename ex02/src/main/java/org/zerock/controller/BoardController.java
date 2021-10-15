package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/")
@Log4j
public class BoardController {
	
	private final BoardService boardService;

	@GetMapping("/list")
	public void list(Model model) {
		log.info("list......................");
		
		model.addAttribute("list",boardService.getList());
		
	}
	
	@GetMapping("/register")
	public void registerGet() {
		
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("board: "+board);
		
		Long bno = boardService.register(board);
		log.info("bno: "+bno);
		rttr.addFlashAttribute("result",bno); //잠깐 전송되고 없어짐
		
		// rttr.addAttribute(null, rttr); //주소 값 뒤에 파라미터로 붙음
	
		
		return "redirect:/board/list";
	}
	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno")Long bno, Model model) {
	
		model.addAttribute("board", boardService.get(bno));
		
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		
		int count = boardService.modify(board);
		if(count == 1) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		
		int count = boardService.remove(bno);	
		if(count == 1) {
			rttr.addFlashAttribute("result", "success");
		}
		
		return "redirect:/board/list";
	}
}

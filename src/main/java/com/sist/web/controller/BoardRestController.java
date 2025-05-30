package com.sist.web.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dto.BoardDTO;
import com.sist.web.entity.BoardEntity;
import com.sist.web.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BoardRestController {
	private final BoardService bService;
	
	@GetMapping("/list")
	public Page<BoardEntity> boardList(@RequestParam(name = "page", defaultValue = "0") int page,
									   @RequestParam(name = "size", defaultValue = "10") int size) {
		
		return bService.boardList(PageRequest.of(page, size));
	}
	
	@PostMapping("/insert")
	public void boardInsert(@RequestBody BoardDTO dto) {
		bService.boardInsert(dto);
	}
	
	@GetMapping("/details/{no}")
	public BoardEntity boardDetail(@PathVariable(name = "no") int no) {
		return bService.boardDetail(no);
	}
}

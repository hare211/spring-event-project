package com.sist.web.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sist.web.dto.BoardDTO;
import com.sist.web.entity.BoardEntity;

public interface BoardService {
	Page<BoardEntity> boardList(Pageable pageable);
	void boardInsert(BoardDTO dto);
	BoardEntity boardDetail(int no);
}

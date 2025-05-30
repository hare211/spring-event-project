package com.sist.web.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sist.web.dao.BoardRepository;
import com.sist.web.dto.BoardDTO;
import com.sist.web.entity.BoardEntity;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	private final BoardRepository bDao;
	
	@Override
	public Page<BoardEntity> boardList(Pageable pageable) {
		
		return bDao.findBoardList(pageable);
	}
	
	@Override
	public void boardInsert(BoardDTO dto) {
		BoardEntity entity = new BoardEntity();
		entity.setName(dto.getName());
		entity.setSubject(dto.getSubject());
		entity.setContent(dto.getContent());
		entity.setPwd(dto.getPwd());
		bDao.save(entity);
	}
	
	@Override
	@Transactional
	public BoardEntity boardDetail(int no) {
		bDao.increaseHit(no);
		return bDao.findBoardByNo(no);
	}
}

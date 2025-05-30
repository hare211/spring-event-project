package com.sist.web.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.BoardEntity;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer>{
	@Query(value = "SELECT * FROM board ORDER BY no DESC", nativeQuery = true)
	Page<BoardEntity> findBoardList(Pageable pageable);
	
	@Query(value = "SELECT * FROM board WHERE no = :no", nativeQuery = true)
	BoardEntity findBoardByNo(@Param("no") int no);
	
	@Modifying
	@Query(value = "UPDATE board SET hit = hit + 1 WHERE no = :no", nativeQuery = true)
	void increaseHit(@Param("no") int id);

}

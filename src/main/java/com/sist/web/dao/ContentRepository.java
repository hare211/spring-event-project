package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.ContentEntity;

@Repository
public interface ContentRepository extends JpaRepository<ContentEntity, Integer>{
	@Query(value = "SELECT * FROM content WHERE cat2 = 'A0208' ORDER BY content_id DESC limit 12", nativeQuery = true)
	public List<ContentEntity> selectContentList();
}

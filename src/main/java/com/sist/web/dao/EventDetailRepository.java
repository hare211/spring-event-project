package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.dto.EventDetailProjection;
import com.sist.web.entity.EventDetailEntity;

@Repository
public interface EventDetailRepository extends JpaRepository<EventDetailEntity, Integer>{
	@Query(value = "SELECT e.info_id, e.content_id, e.infoname, e.infotext, c.title, c.first_image, c.addr1 "
				 + "FROM event_detail e "
				 + "JOIN content c "
				 + "ON e.content_id = c.content_id "
				 + "WHERE c.cat2 = 'A0208' AND e.infoname = '행사소개' "
				 + "ORDER BY content_id DESC "
				 + "LIMIT 12", nativeQuery = true)
	List<EventDetailProjection> findEventDetailLimited();
	
	@Query(value = "SELECT e.info_id, e.content_id, e.infoname, e.infotext, c.title, c.first_image, c.addr1 " +
            "FROM event_detail e " +
            "JOIN content c ON e.content_id = c.content_id " +
            "WHERE c.cat2 = 'A0208' AND e.infoname = '행사소개' " +
            "ORDER BY e.content_id DESC " +
            "LIMIT :limit OFFSET :offset", nativeQuery = true)
	List<EventDetailProjection> findPagedEventDetails(@Param("limit") int limit, @Param("offset") int offset);
	
	@Query(value = "SELECT CEIL(COUNT(*) / 12.0) FROM event_detail e JOIN content c ON e.content_id = c.content_id WHERE c.cat2 = 'A0208' AND e.infoname = '행사소개'", nativeQuery = true)
	int countEventListTotalPage();

}

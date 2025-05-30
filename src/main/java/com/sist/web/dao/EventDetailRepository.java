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
	
	@Query(value = "SELECT " +
	        "e.content_id AS content_id, " +
	        "e.event_startdate AS event_startdate, " +
	        "e.event_enddate AS event_enddate, " +
	        "e.sponsor1 AS sponsor1, " +
	        "e.sponsor2 AS sponsor2, " +
	        "e.playtime AS playtime, " +
	        "e.charge AS charge, " +
	        "e.spendtime AS spendtime, " +
	        "e.agelimit AS agelimit, " +
	        "e.price AS price, " +
	        "e.price_info AS price_info, " +
	        "c.title AS title, " +
	        "c.addr1 AS addr1, " +
	        "c.first_image AS first_image, " +
	        "c.mapy AS mapy, " +
	        "c.mapx AS mapx, " +
	        "c.tel AS tel, " +
	        "d.info_id AS info_id, " +
	        "d.infoname AS infoname, " +
	        "d.infotext AS infotext " +
	        "FROM event e " +
	        "JOIN content c ON e.content_id = c.content_id " +
	        "JOIN event_detail d ON e.content_id = d.content_id " +
	        "WHERE e.content_id = :content_id", nativeQuery = true)
	List<EventDetailProjection> findEventDetailByContentId(@Param("content_id") int contentId);
	

}

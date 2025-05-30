package com.sist.web.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.sist.web.dto.EventDetailProjection;

public interface EventDetailService {
	List<EventDetailProjection> getEventDetails();
	List<EventDetailProjection> getPagedEventList(Pageable pageable);
	int getEventListTotalPage();
}

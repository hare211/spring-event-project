package com.sist.web.service;

import java.util.List;

import com.sist.web.dto.EventDetailProjection;

public interface EventDetailService {
	List<EventDetailProjection> getEventDetails();
}

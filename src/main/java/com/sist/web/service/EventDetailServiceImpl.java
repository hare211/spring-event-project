package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.dao.EventDetailRepository;
import com.sist.web.dto.EventDetailProjection;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventDetailServiceImpl implements EventDetailService {
	
	private final EventDetailRepository eDao;
	@Override
	public List<EventDetailProjection> getEventDetails() {
		
		return eDao.findEventDetailLimited();
	}

}

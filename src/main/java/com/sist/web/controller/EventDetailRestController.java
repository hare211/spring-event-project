package com.sist.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dto.EventDetailProjection;
import com.sist.web.service.EventDetailService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EventDetailRestController {
	
	private final EventDetailService eService;
	
	@GetMapping("/event-details")
	public List<EventDetailProjection> getEventDetails() {
		return eService.getEventDetails();
	}
}

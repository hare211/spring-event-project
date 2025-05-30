package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/event/list")
	public ResponseEntity<Map<String, Object>> getPagedEventList(
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {
		Pageable pageable = PageRequest.of(page, size);
		List<EventDetailProjection> result = eService.getPagedEventList(pageable);
		int totalPage = eService.getEventListTotalPage();
		
		Map<String, Object> res = new HashMap<>();
		res.put("list", result);
		res.put("totalPage", totalPage);
		return ResponseEntity.ok(res);
	}
}

package com.sist.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.entity.ContentEntity;
import com.sist.web.service.ContentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/content")
public class ContentRestController {
	private final ContentService cService;
	
	@GetMapping("/list")
	public List<ContentEntity> getContentList() {
		List<ContentEntity> list = new ArrayList<>();
		try {
			list = cService.getContentList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
}

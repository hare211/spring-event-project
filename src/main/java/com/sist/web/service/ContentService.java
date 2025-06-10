package com.sist.web.service;

import java.util.List;

import com.sist.web.entity.ContentEntity;

public interface ContentService {
	List<ContentEntity> getContentList();
	List<ContentEntity> getTodayContentList();
}

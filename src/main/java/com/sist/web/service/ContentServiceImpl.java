package com.sist.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.dao.ContentRepository;
import com.sist.web.entity.ContentEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContentServiceImpl implements ContentService{
	private final ContentRepository cDao;
	
	@Override
	public List<ContentEntity> getContentList() {
		List<ContentEntity> list = new ArrayList<>();
		try {
			list = cDao.selectContentList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
}

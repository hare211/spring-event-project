package com.sist.web.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
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
	
	@Override
	public List<EventDetailProjection> getPagedEventList(Pageable pageable) {
		int limit = pageable.getPageSize();
		int offset = pageable.getPageNumber() * limit;
		return eDao.findPagedEventDetails(limit, offset);
	}
	
	@Override
	public int getEventListTotalPage() {
		return eDao.countEventListTotalPage();
	}
	
	@Override
	public Map<String, Object> getEventDetailByContentId(int contentId) {
		List<EventDetailProjection> rows = eDao.findEventDetailByContentId(contentId);
		
		if (rows.isEmpty()) {
			return Collections.emptyMap();
		}
		
		EventDetailProjection first = rows.get(0); // 공통 필드 추출

	    Map<String, Object> result = new LinkedHashMap<>();
	    result.put("content_id", first.getContent_id());
	    result.put("title", first.getTitle());
	    result.put("event_startdate", first.getEventStartdate());
	    result.put("event_enddate", first.getEventEnddate());
	    result.put("sponsor1", first.getSponsor1());
	    result.put("sponsor2", first.getSponsor2());
	    result.put("playtime", first.getPlaytime());
	    result.put("charge", first.getCharge());
	    result.put("spendtime", first.getSpendtime());
	    result.put("agelimit", first.getAgelimit());
	    result.put("price", first.getPrice());
	    result.put("price_info", first.getPriceInfo());
	    result.put("addr1", first.getAddr1());
	    result.put("first_image", first.getFirst_image());
	    result.put("mapx", first.getMapx());
	    result.put("mapy", first.getMapy());
	    result.put("tel", first.getTel());
	    
        
        List<Map<String, String>> infoList = new ArrayList<>();
        for (EventDetailProjection row : rows) {
            String name = row.getInfoname();
            String text = row.getInfotext();

            if (name != null && !name.isBlank() && text != null && !text.isBlank()) {
                Map<String, String> infoItem = new LinkedHashMap<>();
                infoItem.put("infoname", name.trim());
                infoItem.put("infotext", text.trim());
                infoList.add(infoItem);
            }
        }
        result.put("info", infoList);

		return result;
	}

}

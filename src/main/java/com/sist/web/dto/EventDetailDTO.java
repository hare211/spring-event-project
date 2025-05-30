package com.sist.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EventDetailDTO {
	private int info_id;
	private int content_id;
	private String infoname;
	private String infotext;
	
}

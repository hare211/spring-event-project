package com.sist.web.dto;

import lombok.Data;

@Data
public class BoardDTO {
	private String name;
	private String pwd;
	private String subject;
	private String content;
}

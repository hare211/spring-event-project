package com.sist.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "board")
@Getter @Setter
public class BoardEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;
	private String name;
	private String subject;
	private String content;
	@Column(insertable = true, updatable = false)
	private String pwd;
	@Column(insertable = false, updatable = false)
	private String regdate;
	@Column(insertable = false)
	private int hit;

}

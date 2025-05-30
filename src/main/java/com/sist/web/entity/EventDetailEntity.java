package com.sist.web.entity;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity(name = "event_detail")
@Getter @Service
@DynamicUpdate
public class EventDetailEntity {
	@Id
	private int info_id;
	private int content_id;
	private String infoname;
	private String infotext;
	@ManyToOne
	private ContentEntity content;
}

package com.sist.web.entity;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "event")
@Getter @Setter
@DynamicUpdate
public class EventEntity {
	@Id
	private int content_id;
	private String event_startdate;
	private String event_enddate;
	private String sponsor1;
	private String sponsor2;
	private String playtime;
	private String charge;
	private String spendtime;
	private String agelimit;
	private int price;
	private String price_info;
}

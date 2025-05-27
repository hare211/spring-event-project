package com.sist.web.entity;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "content")
@Getter @Setter
@DynamicUpdate
public class ContentEntity {
	@Id
	private int content_id;
	private int contenttype_id;
	private String title;
	private String addr1;
	private String addr2;
	private int zipcode;
	private int sigungucode;
	private int areacode;
	private String first_image;
	private String first_image2;
	private double mapx;
	private double mapy;
	private String tel;
	private String cat1;
	private String cat2;
	private String cat3;
	private int review_count;
	private int review_total;
	
}

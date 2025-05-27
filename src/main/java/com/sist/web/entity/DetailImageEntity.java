package com.sist.web.entity;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "event_detail_image")
@Getter @Setter
@DynamicUpdate
public class DetailImageEntity {
	@Id
	private int img_id;
	private int content_id;
	private String origin_img;
	private String thumb_img;
	
}

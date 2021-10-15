package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ApartVO {
	private Long apt_bno;
	private String apt_name, apt_lat, apt_lng, apt_admin;
	private Date regdate;
}

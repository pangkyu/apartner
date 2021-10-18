package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class FacilityVO {

	private Long fac_bno;
	private String fac_name, fac_lat, fac_lng, fac_admin, fac_aptname, fac_info, fac_opentime, fac_closetime;
	private int fac_numperson, fac_usingperson;
	private Date regdate;
	
}

package org.zerock.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class ReserveVO {
	private String fac_name, fac_aptname, userId, start_time, finish_time;
	private Date reserve_date;	
}

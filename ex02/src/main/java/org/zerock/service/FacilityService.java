package org.zerock.service;

import java.util.List;

import org.zerock.domain.FacilityVO;

public interface FacilityService {

	int register(FacilityVO facilityVO);
	
	FacilityVO get(Long fac_bno);
	
	int modify(FacilityVO facilityVO);
	
	int remove(Long fac_bno);
	
	List<FacilityVO> getList();
	
}

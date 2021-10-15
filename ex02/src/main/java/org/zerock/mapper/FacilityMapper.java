package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.FacilityVO;

public interface FacilityMapper {

	List<FacilityVO> getList();
	
	int insert(FacilityVO facilityVO);
	
	FacilityVO read(Long fac_bno);
	
	int delete(Long fac_bno);
	
	int updateUser(FacilityVO facilityVO);
	
}

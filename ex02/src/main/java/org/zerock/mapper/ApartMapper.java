package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.ApartVO;

public interface ApartMapper {

	List<ApartVO> getList();
	
	int insert(ApartVO apartVO);
	
	ApartVO read(Long apt_bno);
	
	int delete(Long apt_bno);
	
	int update(ApartVO apartVO);
	
}

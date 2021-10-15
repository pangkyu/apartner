package org.zerock.service;

import java.util.List;

import org.zerock.domain.ApartVO;

public interface ApartService {

	int register(ApartVO apartVO);
	
	ApartVO get(Long apt_bno);
	
	int modify(ApartVO apartVO);
	
	int remove(Long apt_bno);
	
	List<ApartVO> getList();
	
}

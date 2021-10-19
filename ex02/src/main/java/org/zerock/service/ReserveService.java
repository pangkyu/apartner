package org.zerock.service;

import java.util.List;

import org.zerock.domain.ReserveVO;

public interface ReserveService {
	
	int register(ReserveVO reserveVO);
	
	List<ReserveVO> get(ReserveVO reserveVO);
	
	int remove(ReserveVO reserveVO);

}

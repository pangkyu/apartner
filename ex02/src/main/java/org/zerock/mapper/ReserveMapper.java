package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.ReserveVO;

public interface ReserveMapper {
	
	List<ReserveVO> getInfo(ReserveVO reserveVO);
	
	int insert(ReserveVO reserveVO);
	
	int delete(ReserveVO reserveVO);

}

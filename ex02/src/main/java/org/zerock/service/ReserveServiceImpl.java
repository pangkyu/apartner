package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.ReserveVO;
import org.zerock.mapper.ReserveMapper;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
@ToString
public class ReserveServiceImpl implements ReserveService{
	private ReserveMapper reserveMapper;
	
	@Override
	public int register(ReserveVO reserveVO) {
		// TODO Auto-generated method stub
		return reserveMapper.insert(reserveVO);
	}

	@Override
	public List<ReserveVO> get(ReserveVO reserveVO) {
		// TODO Auto-generated method stub
		return reserveMapper.getInfo(reserveVO);
	}

	@Override
	public int remove(ReserveVO reserveVO) {
		// TODO Auto-generated method stub
		return reserveMapper.delete(reserveVO);
	}

}

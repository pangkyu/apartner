package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.ApartVO;
import org.zerock.mapper.ApartMapper;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
@ToString
public class ApartServiceImpl implements ApartService{
	
	private final ApartMapper apartMapper;

	@Override
	public int register(ApartVO apartVO) {
		// TODO Auto-generated method stub
		
		return apartMapper.insert(apartVO);
	}

	@Override
	public ApartVO get(Long apt_bno) {
		// TODO Auto-generated method stub
		return apartMapper.read(apt_bno);
	}

	@Override
	public int modify(ApartVO apartVO) {
		// TODO Auto-generated method stub
		return apartMapper.update(apartVO);
	}

	@Override
	public int remove(Long apt_bno) {
		// TODO Auto-generated method stub
		return apartMapper.delete(apt_bno);
	}

	@Override
	public List<ApartVO> getList() {
		// TODO Auto-generated method stub
		return apartMapper.getList();
	}

}

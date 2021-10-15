package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
@ToString
public class BoardServiceImpl implements BoardService{
	
	private final BoardMapper boardMapper;

	@Override
	public Long register(BoardVO board) {
		// TODO Auto-generated method stub
		boardMapper.insertSelectKey(board);
		return board.getBno();
	}

	@Override
	public BoardVO get(Long bno) {
		// TODO Auto-generated method stub
		return boardMapper.read(bno);
	}

	@Override
	public int modify(BoardVO board) {
		// TODO Auto-generated method stub
		return boardMapper.update(board);
	}

	@Override
	public int remove(Long bno) {
		// TODO Auto-generated method stub
		return boardMapper.delete(bno);
	}

	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		return boardMapper.getList();
	}
	
	

}

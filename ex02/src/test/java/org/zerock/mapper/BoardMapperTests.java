package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void testGetList() {
		log.info("-------------");
		boardMapper.getList();
	}

	@Test
	public void testInsert() {
		BoardVO vo = new BoardVO();
		vo.setTitle("Test 테스트");
		vo.setContent("Content 테스트");
		vo.setWriter("tester");
		
		boardMapper.insert(vo);
	}
	
	@Test
	public void testInsertSelectKey() {
		BoardVO vo = new BoardVO();
		vo.setTitle("AATest 테스트");
		vo.setContent("AAContent 테스트");
		vo.setWriter("AAtester");
		
		boardMapper.insertSelectKey(vo);
	}
	
	@Test
	public void testRead() {
		
		BoardVO board = boardMapper.read(21L);
		log.info(board);
		
	}
	
	@Test
	public void testDelete() {
		int count = boardMapper.delete(2L);
		log.info("count----"+count);
		
	}
	
	@Test
	public void testUpdate() {
		BoardVO vo = new BoardVO();
		vo.setBno(1L);
		vo.setTitle("Update Title");
		vo.setContent("Update Content");
		vo.setWriter("user00");
		
		log.info("count:-----"+boardMapper.update(vo));
	}
}

package com.spring.pr1_17.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.pr1_17.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession session;
	
	@Override
	public List<BoardDTO> getSearchBoard(Map<String, Object> searchInfo) throws Exception {
		// TODO Auto-generated method stub
		// 0209로 업데이트 확인
		return session.selectList("com.spring.mapper.BoardMapper.getSearchBoard",searchInfo);
	}

	@Override
	public int getAllBoardCount(Map<String, String> searchCountInfo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne("com.spring.mapper.BoardMapper.getAllBoardCount",searchCountInfo);
	}

}

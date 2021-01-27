package com.spring.boardEx01.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.boardEx01.dto.BoardDTO;

@Repository					// Data Access Object(DAO) = 데이터 접근 객체 , Repository 어노테이션을 명시해야한다. = (@Repository)
public class BoardDAOImpl implements BoardDAO {
	
	@Inject					// DI(Dependency Injection) 의존관계 주입
	private SqlSession session;	// SqlSession 객체를 슾프링에서 생성하여 주입시켜준다.
	
	@Override
	public List<BoardDTO> getAllBoard() {
		return session.selectList("com.spring.mapper.BoardMapper.getAllBoard");
	}

	@Override
	public void insertBoard(BoardDTO bdto) {
		session.insert("com.spring.mapper.BoardMapper.insertBoard",bdto);
	}
	
	
}

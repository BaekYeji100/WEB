package com.spring.boardEx01.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.boardEx01.dao.BoardDAO;
import com.spring.boardEx01.dto.BoardDTO;

@Service	// 서비스(비즈니스 로직)은 Service어노데이션을 명시해야한다.
			// (service bean으로 등록)
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	@Override
	public List<BoardDTO> listAll() {
		// TODO Auto-generated method stub
		return dao.getAllBoard();
	}

}

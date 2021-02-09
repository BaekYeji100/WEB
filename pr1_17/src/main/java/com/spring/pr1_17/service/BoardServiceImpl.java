package com.spring.pr1_17.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.pr1_17.dao.BoardDAO;
import com.spring.pr1_17.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {
	@Inject
	private BoardDAO dao;
	@Override
	public List<BoardDTO> getSearchBoard(Map<String, Object> searchInfo) throws Exception {
		// TODO Auto-generated method stub
		return dao.getSearchBoard(searchInfo);
	}
	@Override
	public int getAllBoardCount(Map<String, String> searchCountInfo) throws Exception {
		// TODO Auto-generated method stub
		return dao.getAllBoardCount(searchCountInfo);
	}

}

package com.spring.pr1_17.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.spring.pr1_17.dao.BoardDAO;
import com.spring.pr1_17.dto.BoardDTO;

public interface BoardService {

	public List<BoardDTO> getSearchBoard(Map<String, Object>searchInfo) throws Exception;
	public int getAllBoardCount(Map<String, String> searchCountInfo) throws Exception;
	public BoardDTO getOneBoard(int num) throws Exception;
	public void insertBoard(BoardDTO bdto) throws Exception;
}

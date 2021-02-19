package com.spring.pr1_17.dao;

import java.util.List;
import java.util.Map;

import com.spring.pr1_17.dto.BoardDTO;

public interface BoardDAO {
	public List<BoardDTO> getSearchBoard(Map<String, Object>searchInfo) throws Exception;
	public int getAllBoardCount(Map<String, String>searchCountInfo) throws Exception;
	public BoardDTO getOneBoard(int num) throws Exception;
	public void increaseReadCount(int num) throws Exception;
	public void insertBoard(BoardDTO bdto) throws Exception;
	
	public void deleteBoard(int num) throws Exception;
}

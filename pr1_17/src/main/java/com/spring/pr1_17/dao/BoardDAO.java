package com.spring.pr1_17.dao;

import java.util.List;
import java.util.Map;

import com.spring.pr1_17.dto.BoardDTO;

public interface BoardDAO {
	public List<BoardDTO> getSearchBoard(Map<String, Object> searchInfo) throws Exception;
	public int getAllBoardCount(Map<String, String> searchCountInfo) throws Exception;

}

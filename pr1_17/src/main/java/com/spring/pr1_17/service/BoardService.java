package com.spring.pr1_17.service;

import java.util.List;
import java.util.Map;

import com.spring.pr1_17.dto.BoardDTO;

public interface BoardService {
	public List<BoardDTO> getSearchBoard(Map<String, Object> searchInfo) throws Exception;
	
}

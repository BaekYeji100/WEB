package com.spring.pr1_17.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.pr1_17.dto.BoardDTO;
import com.spring.pr1_17.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService service;
	
	@RequestMapping(value = "/" , method = RequestMethod.GET)		
	public String main() {
		return "redirect:boardList";
	}
	
	@RequestMapping(value = "/boardList")
	public String boardList(@RequestParam(name = "onePageViewCount"  , defaultValue = "10")    int onePageViewCount,
							@RequestParam(name = "currentPageNumber" , defaultValue = "1")     int currentPageNumber,
							@RequestParam(name = "searchKeyword"     , defaultValue = "total") String searchKeyword,
							@RequestParam(name = "searchWord"        , defaultValue = "")      String searchWord,
							Model model) throws Exception{

		// 페이지의 시작 게시글 인덱스
		int startBoardIdx =  (currentPageNumber -1) * onePageViewCount; // 0*10 0
		 
		// 관련 정보 MAP 생성( 한페이지에 보여줄 게시글 숫자, 시작페이지의 인덱스, 검색 키워드, 검색어 )
		Map<String, Object> searchInfo = new HashMap<String, Object>();
		searchInfo.put("onePageViewCount", onePageViewCount);
		searchInfo.put("startBoardIdx", startBoardIdx);
		searchInfo.put("searchKeyword", searchKeyword);
		searchInfo.put("searchWord", searchWord);
		
		List<BoardDTO> boardList = service.getSearchBoard(searchInfo);
		
		
		return "dd";
	}

}

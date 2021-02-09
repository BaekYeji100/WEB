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
		int startBoardIdx =  (currentPageNumber -1) * onePageViewCount; // 1-1 * 10
		 
		// 관련 정보 MAP 생성( 한페이지에 보여줄 게시글 숫자, 시작페이지의 인덱스, 검색 키워드, 검색어 )
		Map<String, Object> searchInfo = new HashMap<String, Object>();
		searchInfo.put("onePageViewCount", onePageViewCount);
		searchInfo.put("startBoardIdx", startBoardIdx);
		searchInfo.put("searchKeyword", searchKeyword);
		searchInfo.put("searchWord", searchWord);
		List<BoardDTO> boardList = service.getSearchBoard(searchInfo);
		
		// 게시글의 전체 개수를 반환하는 관련정보 MAP 생성 ( 검색 키워드, 검색어 )
		Map<String, String> searchCountInfo = new HashMap<String, String>();
		searchCountInfo.put("searchKeyword", searchKeyword);
		searchCountInfo.put("searchWord", searchWord);
		
		// 전체페이지 개수 = 전체게시글 수 / 한페이지에서 보여지는 글수
		int totalBoardCount = service.getAllBoardCount(searchCountInfo);
		int addPage = totalBoardCount % onePageViewCount == 0? 0 : 1; // 나머지가 0이면 추가 x , 나머지가 0이 아니면 +1 페이지 처리
		int totalPageCount = totalBoardCount / onePageViewCount + addPage;
		
		// 시작페이지
		int startPage = 1;
		
		if(currentPageNumber % 10 == 0) startPage = (currentPageNumber / 10 - 1) * 10 + 1;
		else						    startPage = (currentPageNumber / 10) * 10 + 1;
		
		// 끝페이지
		int endPage = startPage + 9;
		
		// 끝페이지가 전체 페이지 개수보다 크다면
		if (endPage > totalPageCount) {
			endPage = totalPageCount;
		}
		
		// 게시물이 한페이지에 보여지는 것보다 작다면
		if(onePageViewCount > totalBoardCount) {
			startPage = 1;
			endPage = 0;
		}

		model.addAttribute("startPage" , startPage);
		model.addAttribute("endPage" , endPage);
		model.addAttribute("totalBoardCount" , totalBoardCount);
		model.addAttribute("onePageViewCount" , onePageViewCount);
		model.addAttribute("currentPageNumber" , currentPageNumber);
		model.addAttribute("searchKeyword" , searchKeyword);
		model.addAttribute("searchWord" , searchWord);
		model.addAttribute("boardList",boardList);	
		
		
		return "boardEx02/bList";
	}

}

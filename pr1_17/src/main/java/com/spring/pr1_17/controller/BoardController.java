package com.spring.pr1_17.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebParam.Mode;

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
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main() {
		return "redirect:boardList";
	}
	
	@RequestMapping(value = "/boardList")
	public String boardList(@RequestParam(name = "currentPageNumber", defaultValue = "1") int currentPageNumber,
							@RequestParam(name = "onePageViewCount", defaultValue = "10") int onePageViewCount,
							@RequestParam(name = "searchKeyword", defaultValue = "total") String searchKeyword,
							@RequestParam(name = "searchWord", defaultValue = "") String searchWord,
							Model model) throws Exception{
		
		// 페이지의 시작 게시글 인덱스
		int startBoardIdx = (currentPageNumber -1) * onePageViewCount;
		
		// 관련 정보 MAP 생성 (한페이지에 보여줄 게시글 숫자, 시작페이지인덱스, 키워드, 검색어)
		Map<String, Object> searchInfo = new HashMap<String, Object>();
		searchInfo.put("onePageViewCount", onePageViewCount);
		searchInfo.put("startBoardIdx",startBoardIdx);
		searchInfo.put("searchKeyword",searchKeyword);
		searchInfo.put("searchWord",searchWord);
		List<BoardDTO> boardList = service.getSearchBoard(searchInfo);
		
		// 게시글의 전체개수를 반환하는 관련정보 MAP 생성( 검색 키워드 , 검색어 )
		Map<String, String> searchCountInfo = new HashMap<String, String>();
		searchCountInfo.put("searchKeyword", searchKeyword);
		searchCountInfo.put("searchWord", searchWord);
		
		int totalBoardCount = service.getAllBoardCount(searchCountInfo);
		int addPage = totalBoardCount % onePageViewCount == 0? 0 : 1;
		int totalPageCount = totalBoardCount / onePageViewCount + addPage;
		
		int startPage = 1;
		if(currentPageNumber % 10 == 0) startPage = (currentPageNumber / 10 - 1) * 10 + 1;
		else						    startPage = (currentPageNumber / 10 ) * 10 + 1;
		
		int endPage = startPage + 9;
		
		if(endPage > totalPageCount) endPage = totalPageCount;
		if(onePageViewCount > totalBoardCount) {
			startPage = 1;
			endPage = 0;
		}
		model.addAttribute("startPage",startPage);
		model.addAttribute("endPage",endPage);
		model.addAttribute("totalBoardCount", totalBoardCount);
		model.addAttribute("onePageViewCount",onePageViewCount);
		model.addAttribute("currentPageNumber",currentPageNumber);
		model.addAttribute("searchKeyword",searchKeyword);
		model.addAttribute("searchWord",searchWord);
		model.addAttribute("boardList",boardList);
		
		System.out.println("====================================");
		System.out.println("startPage : " + startPage);
		System.out.println("endPage : " + endPage);
		System.out.println("totalBoardCount : " + totalBoardCount);
		System.out.println("onePageViewCount : " + onePageViewCount);
		System.out.println("currentPageNumber : " + currentPageNumber);
		System.out.println("searchKeyword : " + searchKeyword);
		System.out.println("searchWord : " + searchWord);
		System.out.println("====================================\n");
		
		return "boardEx02/bList";
	}
	
	@RequestMapping(value = "/boardInfo")
	public String boardInfo(@RequestParam("num") int num, Model model) throws Exception{
		BoardDTO bdto = service.getOneBoard(num);
		model.addAttribute("bdto",bdto);
		
		return "boardEx02/bInfo";
	}
	
	@RequestMapping(value = "/boardWrite", method = RequestMethod.GET)
	public String boardWrite(Model model) throws Exception{
		return "boardEx02/bWrite";
	}
	
	@RequestMapping(value = "/boardWrite", method = RequestMethod.POST)
	public String boardWrite(Model model,BoardDTO bdto) throws Exception{
		service.insertBoard(bdto);
		return "redirect:boardList";
	}
}

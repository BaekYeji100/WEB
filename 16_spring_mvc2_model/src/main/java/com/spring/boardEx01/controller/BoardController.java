package com.spring.boardEx01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.boardEx01.dto.BoardDTO;
import com.spring.boardEx01.service.BoardService;

@Controller			// 컨트롤러임을 명시(controller bean에 등록시킴)
public class BoardController {
	
	@Autowired							// DI (의존성 주입)
	private BoardService boardService; // Service 호출을 위한 객체 생성
	
	
	
	
	// (URL주소 	,	요청타입)
	@RequestMapping(value = "/main", method=RequestMethod.GET)		//
	public String main() {
		return "boardEx01/main";	// servlet-context.xml 에 명시된 대로   => spring > appServlet > servlet-context.xml
									// 포워팅 시킬 jsp파일을 작성해준다
	}
	
	@RequestMapping(value = "/boardList")
	public String boardList(Model model) {
		
		List<BoardDTO> boardList = boardService.listAll();
		model.addAttribute("boardList", boardList);
		
		
		return "boardEx01/bList";
	}
	
//	@RequestMapping(value = "/boardWrite" ,method = RequestMethod.GET)
//	public String boardWriteForm() {
//		return "boardEx01/bWrite";
//	}
//	
//	@RequestMapping(value = "/boardWrite" ,method = RequestMethod.POST)
//	public String boardWriteAction() {
//		return "";
//	}
}

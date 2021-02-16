package com.spring.basic.step04_tiles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TilesController {
	@RequestMapping(value = "/content1", method = RequestMethod.GET)
	public String content1() {
		return "tiles/content1"; // tiles.xml의 definition 태그의 name과 매칭 
	}
	
	@RequestMapping(value = "/content2", method = RequestMethod.GET)
	public String content2() {
		return "tiles/content2";
	}
	
	@RequestMapping(value = "/content3", method = RequestMethod.GET)
	public String content3() {
		return "tiles/content3";
	}
}

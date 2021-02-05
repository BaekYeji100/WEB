package com.spring.basic.step02_dataTransfer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DataTransferEx01 {

	/* Controller > View 데이터 전송 */
	
	// 예시 1) Model 인터페이스 이용
	@RequestMapping(value = "/dataTransferEx01")
	public String dataTransferEx01(Model model) {
		model.addAttribute("method1", "방법1"); // 
		model.addAttribute("productCode", "0000-97531"); // 
		model.addAttribute("productName", "멀티리더기"); // 
		model.addAttribute("productPrice", 50000);
		 
		
		return "dataTransferPro";
	}
	
	// 예시 2) ModelAndView 클래스 이용
	@RequestMapping(value = "/dataTransferEx02")
	public ModelAndView dataTransferEx02() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("dataTransferPro");
		mv.addObject("method","방법2");
		mv.addObject("productCode","0000-97531");
		mv.addObject("productName","멀티리더기");
		mv.addObject("productPrice",50000);
		
		return mv;
	}	
	
	// 예시 3) httpServeletRequest 인터페이스 이용
	@RequestMapping(value = "/dataTransferEx03")
	public String dataTransferEx03(HttpServletRequest request) {
		
		request.setAttribute("method", "방법3");
		request.setAttribute("productCode", "0000-97531");
		request.setAttribute("productName", "멀티리더기");
		request.setAttribute("productPrice", 50000);
		
		return "dataTransferPro";
		
	}	
	
}

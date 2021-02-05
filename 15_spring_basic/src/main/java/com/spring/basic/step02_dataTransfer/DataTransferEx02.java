package com.spring.basic.step02_dataTransfer;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DataTransferEx02 {
	/* View > Controller 데이터 전송 */
	
	@RequestMapping(value = "/dataTransferEx04")
	public String dataTransferEx04() {
		return "form";
	}
	
	
	// 예시1) DTO 클래스 이용
	@RequestMapping(value = "/dataTransferEx05")
	public String dataTransferEx05(Member member) {
		System.out.println("\n======= dataTransferEx05 전달 받은 파라메타 확인 =======");
		System.out.println("name : "    + member.getName());
		System.out.println("id : "      + member.getId());
		System.out.println("pwd : "     + member.getPwd());
		System.out.println("content : " + member.getContent());
		return "home";
	}
	
	// 예시 2) Map 컬렉션 프레임워크 이용
	@RequestMapping(value = "/dataTransferEx06")
	public String dataTransferEx06(@RequestParam Map<String,String>param) {
		
		System.out.println("\n======= dataTransferEx05 전달 받은 파라메타 확인 =======");
		System.out.println("name : "    + param.get("name"));
		System.out.println("id : "      + param.get("id"));
		System.out.println("pwd : "     + param.get("pwd"));
		System.out.println("content : " + param.get("content"));
		
		return "home";
		
	}
	
	// 예시 3) HttpServletRequest 이용
	@RequestMapping(value = "/dataTransferEx07")
	public String dataTransferEx07(HttpServletRequest request) {
		
		System.out.println("\n======= dataTransferEx06 전달 받은 파라메타 확인 =======");
		System.out.println("name : "    + request.getParameter("name"));		
		System.out.println("id : "      + request.getParameter("id"));
		System.out.println("pwd : "     + request.getParameter("pwd"));
		System.out.println("content : " + request.getParameter("content"));
		
		return "home";
		
	}
	
	
	// 예시 4) parameter에 직접 form태그의 name값 입력
	@RequestMapping(value = "/dataTransferEx08")
	public String dataTransferEx08(String id , String pwd ) {
		
		System.out.println("\n======= dataTransferEx08 전달 받은 파라메타 확인 =======");
		System.out.println("id : " + id);
		System.out.println("pwd : " + pwd);
		
		return "home";
		
	}
	
	// 예시 5) @RequestParma을 이용
	@RequestMapping(value = "/dataTransferEx09")
	public String dataTransferEx09(@RequestParam("id") String memberId , 
							       @RequestParam(name="pwd" , defaultValue = "1111") String memberPwd) {
		
		System.out.println("\n======= dataTransferEx09 전달 받은 파라메타 확인 =======");
		System.out.println("id : "  + memberId);
		System.out.println("pwd : " + memberPwd);
		
		return "home";
		
	}
}

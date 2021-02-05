package com.spring.basic.step02_dataTransfer;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DataTransferEx03 {

	/* DAO > Mybatis-Mapper 데이터 전송 */
	
	@Autowired
	SqlSession session;
	
	
	@RequestMapping(value = "/dataTransferEx10")
	public String dataTransferEx10() {
		
		Member member = new Member();
		member.setName("팀 버너스리");
		member.setId("www");
		member.setPwd("q1w2e3r4");
		member.setContent("특이사항 없음");
		
		session.insert("tester.insertData1",member);
		
		
		return "home";
		
	}
	// 예시 2) Map 컬렉션 프레임워크 이용 ( 특정 데이터를 묶음으로 전송할 때 사용 ) 
	@RequestMapping(value = "/dataTransferEx11")
	public String dataTransferEx11() {
		
		//HashMap<String, String> map = new HashMap<String, String>();
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("id" , "qqqq1234");
		map.put("pwd" , "1q2w3e4r");
		
		session.insert("tester.insertData1" , map);
		
		return "home";
		
	}
	// 예시 3) 메서드의 파라메타로 전달 ( 하나의 데이터 전송시 사용 ) 
	@RequestMapping(value = "/dataTransferEx12")
	public String dataTransferEx12() {
		
		String name = "앨런 튜링";
		
		session.insert("tester.insertData3",name);
		
		return "home";
		
	}
	
	
}

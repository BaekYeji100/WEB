package com.spring.basic.step01_DI;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DIEx04 {
	@Autowired 
	ClassTester1 classTester1_1;
	
	@Inject
	ClassTester1 classTester1_2;
	
	@Resource(name="resourceTester")
	ClassTester1 classTester1_3;
	
	@Autowired
	ClassTester2 classTester2_1;
	
	@Autowired
	ClassTester2 classTester2_2;
	
	@Autowired
	ClassTester2 classTester2_3;
	
	@Autowired
	ClassTester3 classTester3;
	
	
	@RequestMapping(value="/test4" )
	public String main() {
		
		System.out.println("\n ======= ClassTester1 =======");
		
		classTester1_1.printInfo();
		classTester1_2.printInfo();
		classTester1_3.printInfo();
		
		System.out.println("\n ======= ClassTester2 =======");
		
		classTester2_1.print();
		classTester2_2.print();
		classTester2_3.print();
		
		System.out.println("\n ======= ClassTester2\3 =======");	
		for (String data : classTester3.getTestList()) {
			System.out.println(data);
		}
		System.out.println();
		
		for (String key : classTester3.getTestMap().keySet()) {
			System.out.println("key : "  + key  + " : " + classTester3.getTestMap().get(key));
		}
		System.out.println();
		
		for (String key : classTester3.getTestMapObj().keySet()) {
			classTester3.getTestMapObj().get(key).printInfo();
		}
		
		return "home";
	}
}

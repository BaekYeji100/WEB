package com.spring.basic.step01_DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DIEx02 {
	@RequestMapping(value = "/test2")
	public String main() {
		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:CharacterApplicationContext.xml");


		//CharacterManager2 cm2 = context.getBean("characterManager2",CharacterManager2.class);	// xml파일의 bean id값 명시
		//CharacterManager2 cm2 = (CharacterManager2) context.getBean("characterManager2");	// xml파일의 bean id값 명시
		CharacterManager2 cm2 = context.getBean(CharacterManager2.class);	
		
		Character1 char1 = context.getBean(Character1.class);
		Character2 char2 = context.getBean(Character2.class);
		Character3 char3 = context.getBean(Character3.class);
		System.out.println("\n====================== DIEx02 ====================");
		
		cm2.setChar1(char1);
		cm2.printCharacter1Info();
		
		cm2.setChar2(char2);
		cm2.printCharacter2Info();
		
		cm2.setChar3(char3);
		cm2.printCharacter3Info();
		return "home";
	}
}

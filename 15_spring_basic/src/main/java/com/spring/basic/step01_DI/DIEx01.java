package com.spring.basic.step01_DI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DIEx01 {
	@RequestMapping(value = "/test1")
	public String main() {
		
		System.out.println("======================DIEx01=================");
		System.out.println("\n1. 클래스 내부에서 외부 객체를 생성한 예시\n");
		
		CharacterManager1 cm1 = new CharacterManager1();
		cm1.printCharacter1Info();
		cm1.printCharacter2Info();
		cm1.printCharacter3Info();
		
		System.out.println("\n2. 생성자를 통하여 외부의 객체를 주입한 예시\n");
		
		CharacterManager2 cm2 = new CharacterManager2(new Character1());
		cm2.printCharacter1Info();
		
		cm2 = new CharacterManager2(new Character2());
		cm2.printCharacter2Info();
		
		cm2 = new CharacterManager2(new Character3());
		cm2.printCharacter3Info();		
		
		System.out.println("\n3. setter를 통하여 외부의 객체를 주입한 예시\n");
		
		cm2 = new CharacterManager2();
		cm2.setChar1(new Character1());
		cm2.printCharacter1Info();
		
		cm2 = new CharacterManager2();
		cm2.setChar2(new Character2());
		cm2.printCharacter2Info();
		
		cm2 = new CharacterManager2();
		cm2.setChar3(new Character3());
		cm2.printCharacter3Info();
		return "home";
	}
}



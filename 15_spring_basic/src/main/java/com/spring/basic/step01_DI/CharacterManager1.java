package com.spring.basic.step01_DI;

public class CharacterManager1 {
	Character1 char1 = new Character1();
	Character2 char2 = new Character2();
	Character3 char3 = new Character3();
	
	void printCharacter1Info() {
		
		System.out.println("\n=====================");
		System.out.println(char1.occupation);
		System.out.println(char1.level);
		System.out.println(char1.power);
		System.out.println(char1.dex);
		System.out.println(char1.mana);
		System.out.println("=====================\n");
	}
	
	void printCharacter2Info() {
		
		System.out.println("\n=====================");
		System.out.println(char2.occupation);
		System.out.println(char2.level);
		System.out.println(char2.power);
		System.out.println(char2.dex);
		System.out.println(char2.mana);
		System.out.println("=====================\n");
	}
	
	void printCharacter3Info() {
		
		System.out.println("\n=====================");
		System.out.println(char3.occupation);
		System.out.println(char3.level);
		System.out.println(char3.power);
		System.out.println(char3.dex);
		System.out.println(char3.mana);
		System.out.println("=====================\n");
	}
}

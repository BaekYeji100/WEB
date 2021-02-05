package com.spring.basic.step01_DI;

public class CharacterManager2 {
	Character1 char1;
	Character2 char2;
	Character3 char3;
	
	public CharacterManager2() {}
	
	public CharacterManager2(Character1 char1) {
		this.char1 = char1;
	}
	public CharacterManager2(Character2 char2) {
		this.char2 = char2;
	}
	public CharacterManager2(Character3 char3) {
		this.char3 = char3;
	}

	public Character1 getChar1() {
		return char1;
	}

	public void setChar1(Character1 char1) {
		this.char1 = char1;
	}

	public Character2 getChar2() {
		return char2;
	}

	public void setChar2(Character2 char2) {
		this.char2 = char2;
	}

	public Character3 getChar3() {
		return char3;
	}

	public void setChar3(Character3 char3) {
		this.char3 = char3;
	}
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

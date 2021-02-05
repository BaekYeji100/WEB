package com.spring.basic.step01_DI;
/*

# POJO (Plain Old Java Object) = DTO

- EJB 등에서 사용되는 Java Bean이 아닌 Getter 와 Setter 로 구성된 가장 순수한 형태의 기본 클래스 
- Spring에서 핵심적인 부분을 구성하는 가장 기본적인 요소로 사용

*/
public class Character3 {
	String occupation = "궁수";
	int level = 1;
	int power = 5;
	int dex   = 10;
	int mana  = 5;
	
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getDex() {
		return dex;
	}
	public void setDex(int dex) {
		this.dex = dex;
	}
	public int getMana() {
		return mana;
	}
	public void setMana(int mana) {
		this.mana = mana;
	}
	
	
}

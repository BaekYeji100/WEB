package com.spring.basic.step01_DI;

// 생성자 주입 테스트 예시
public class ClassTester2 {
	ClassTester1 classTester1;

	public ClassTester2(ClassTester1 classTester1) {
		this.classTester1 = classTester1;
	}

	public ClassTester1 getClassTester1() {
		return classTester1;
	}

	public void setClassTester1(ClassTester1 classTester1) {
		this.classTester1 = classTester1;
	}
	
	public void print() {
		this.classTester1.printInfo();
	}
	
	
}

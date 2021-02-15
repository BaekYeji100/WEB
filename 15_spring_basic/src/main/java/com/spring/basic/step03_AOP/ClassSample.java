package com.spring.basic.step03_AOP;

public class ClassSample {

	// sample1 예시
	public void sample1() {
		
		// Boss , Employee , Manager 공통
		System.out.println("출근 한다.");
		
		// Boss , Employee , Manager마다 업무가 다르다. 
		System.out.println("사장의 일을 한다.");
		System.out.println("관리자의 일을 한다.");
		System.out.println("직원의 일을 한다.");
		
		
		// Boss , Employee , Manager 공통
		System.out.println("퇴근한다. ");
	}
	
	
	
	// sample2 예시
	public void sample2() {
		
		try {
			
			// DB 연결 객체 생성 (insert, update , delete , select 공통 )
			
			
			// insert , update , delete ,select마다 다르다.
			
		} catch (Exception e) {
			// 예외처리  (insert, update , delete , select 공통 )
		}
	}
	
	
	
	
	// sample3 예시
	public void sample3() {
		
		// 로깅 , 응답 속도 테스트
		
		// 핵심 로직
		
		// 로깅 , 응답 속도 테스트
		
	}
	
	
	
}

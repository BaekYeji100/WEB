package com.spring.basic.step03_AOP;

import org.springframework.stereotype.Component;

@Component
public class ClassEmployee implements IPosition {

	@Override
	public void work() {
		System.out.println("직원의 일을 한다.");
	}

	@Override
	public void getWorkTime() {
		for (int i = 0; i < 10000000; i++) {
			
		}
	}

	@Override
	public void normal() {
		
	}

	@Override
	public void mistake() {

	}

}

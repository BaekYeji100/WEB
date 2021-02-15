package com.spring.basic.step03_AOP;

import org.springframework.stereotype.Component;

@Component
public class ClassBoss implements IPosition {

	@Override
	public void work() {
		System.out.println("사장의 일을 한다.");
	}

	@Override
	public void getWorkTime() {
		try {
			Thread.sleep(300); // 0.3초
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void normal() {

	}

	@Override
	public void mistake() {

	}

}

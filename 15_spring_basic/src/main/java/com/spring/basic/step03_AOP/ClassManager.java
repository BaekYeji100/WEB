package com.spring.basic.step03_AOP;

import org.springframework.stereotype.Component;

@Component
public class ClassManager implements IPosition {

	@Override
	public void work() {
		System.out.println("관리자의 일을 한다");
	}

	@Override
	public void getWorkTime() {
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
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

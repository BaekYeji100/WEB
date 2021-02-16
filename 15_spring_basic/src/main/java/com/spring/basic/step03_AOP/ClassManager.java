package com.spring.basic.step03_AOP;

import org.springframework.stereotype.Component;

@Component("classManager") // Component를 통하여 xml파일에 명시하지 않고 Component-scan으로 주입이 가능하다. 
							// Component("이름")을 통하여 빈 이름(id)를 지정할 수 있다.
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

package com.spring.basic.step03_AOP;

import org.springframework.stereotype.Component;

@Component("classEmployee") // Component를 통하여 xml파일에 명시하지 않고 Component-scan으로 주입이 가능하다. 
							// Component("이름")을 통하여 빈 이름(id)를 지정할 수 있다.
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
	public void normal() { // AfterReturning Advice 예시
		System.out.println("정상적으로 업무를 보고 있다.");
	}

	@Override
	public void mistake() { // AffterThrowing Adive 예시
		System.out.println("실수로 보고서를 다른 상사에게 보냈다");
	}

}

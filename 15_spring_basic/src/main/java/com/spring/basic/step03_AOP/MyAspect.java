package com.spring.basic.step03_AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// 공통기능이 들어감.
@Component
@Aspect		// AOP에서 Aspect로 사용하겠다는 어노테이션
public class MyAspect {
/*
	 
	Logger객체 생성 (private) static Logger logger = LoggerFactory.getLogger(클래스이름.class);
 	
 	- log4j 로깅방식을 통해서 여러개발자가 협업을 하는 경우 로깅방법을 통일할 수 있다.
 	- log4j 를 이용하여 체계적인 로그관리가 가능하다.
 	- 원하는 로그만 기록 가능하다.
 	
 	1) FATAL : 가장 심각한 에러 발생시 사용
 	2) ERROR : 일반 에러 발생시 사용
 	3) WARN  : 에러는 아니지만 주의할 필요가 있을경우 사용
 	4) INFO  : 일반 정보를 나타낼 경우 사용
 	5) DEBUG : 일반 정보를 상세히 나타낼 경우 사용

  	로깅 레벨을 설정하면 그 이상 레벨을 로깅할 수 있다.
	

*/	
	private static Logger logger = LoggerFactory.getLogger(MyAspect.class);
	
	@Pointcut("execution(* work())") // 중복되는 메서드를 기술
	private void pointcut() {
		// 특별한 의미가 없다.
	}
	
	//@Before("execution(public void com.spring.basic.step03_AOP.ClassBoss.work())")
	// 특정 패키지.특정클래스.특정메서드 동작 전에 메서드 실행
	// 메서드 호출 전
	@Before("pointcut()") // 모든패키지.모든클래스의 work메서드 동작 전에 실행
	public void before(JoinPoint joinPoint) { // JoinPoint를 통해서 메서드의 파라메타를 전달받을 수 있다.
		//System.out.println("AOP Before 메소드 호출 : 출근한다.");
		logger.info("AOP before 메소드 호출 : 출근한다.");
	}
	// 메서드 호출 후
	@After("pointcut()") // 모든패키지.모든클래스의 work메서드 동작 전에 실행
	public void after(JoinPoint joinPoint) {
		//System.out.println("AOP after 메소드 호출 : 퇴근한다.\n");
		logger.info("AOP after 메소드 호출 : 퇴근한다.\n.");
	}
	
	///////////////////////////////////////////////////////////////////////////////
	// 메서드 호출 전 후
	@Around("execution(* getWorkTime())")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		// 메서드 호출 전
		logger.info("============================");
		long startTime = System.currentTimeMillis();
		
		// 메서드 호출
		pjp.proceed();
		
		// 메서드 호출 후
		long endTime = System.currentTimeMillis();
		logger.info("업무 소요시간 : " + (endTime - startTime) + "초");
		logger.info("============================\n");
	}
	
	//////////////////////////////////////////////
	// 호출된 메서드가 성공적으로 실행 된 후
	@AfterReturning("execution(public void com.spring.basic.step03_AOP.ClassEmployee.normal())")
	public void afterReturning(JoinPoint joinPoint) {
		logger.info("AOP afterReturning 메소드 호출 : 정상적으로 업무를 마무리 하였다. \n");
	}
	
	// 호출된 메서드에서 예외발생 후 
	@AfterThrowing("execution(public void com.spring.basic.step03_AOP.ClassEmployee.mistake())")
	public void afterThrowing(JoinPoint joinPoint) {
		logger.info("AOP afterThrowing 메소드 호출 : 보고서를 보낸 것을 눈치챘다. \n");
	}
}

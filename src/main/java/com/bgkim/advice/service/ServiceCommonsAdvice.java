package com.bgkim.advice.service;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

/**
 * 
 * @author bgkim
 *
 * root-context에서 beans 함. AOP
 * Commons와 패키지 분리 함.
 */
@Component
@Aspect
@Log4j

/*
 * Aspect pure java쪽인 @Service를 대상으로 advice 연결시킴
 * 대상 joinPoint(메소드)에 pontcut(aspectj 문법)하여 advice 연결 시킴
 * controller는 @ControllerAdvice에서 함.
 * mybatis는 slf4j로 함.
 * security는 filter에서 함.
 * 
 * */

public class ServiceCommonsAdvice {
	@Around("execution(* com.bgkim.service.*.*(..))")
	public Object logAdvice(ProceedingJoinPoint pjp) {
		log.info("Target : " + pjp.getTarget());
		log.info("Param : " + Arrays.toString(pjp.getArgs()));
		
		//invoke method
		Object result = null;
		
		try {
			result = pjp.proceed();
			log.info("result : " + result);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
//	//Target의 joinPoint를 호출 하기 전에
//	@Before("execution(* org.zerock.service.SampleService*.*(..))")
//	public void logBefore() {
//		log.info("===========================");
//	}
//	
//	//Target의 joinPoint를 호출 하기 전에  파라미터 타입설정  타입이 맞아야 하는 불편한 문제 발생
//	@Before("execution(* org.zerock.service.SampleService*.doAdd(String, String)) && args(str1, str2)")
//	public void logBeforeWithParam(String str1, String str2) {
//		log.info("str1 : " + str1);
//		log.info("str2 : " + str2);
//		
//	}
//	
//	//예외 발생 시 동작
//	@AfterThrowing(pointcut="execution(* org.zerock.service.SampleService*.*(..))", throwing="exception")
//	public void logException(Exception exception) {
//		log.info("Exception....!!!!!");
//		log.info("exception : " + exception);
//				
//	}	
}

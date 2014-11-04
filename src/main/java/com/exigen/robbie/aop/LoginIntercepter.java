package com.exigen.robbie.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginIntercepter {

	@Before("execution(public org.springframework.data.domain.Page com.exigen.robbie.service.impl.StudentService.findAll(..))")
	public void before() {
		System.out
				.println("====================Method start!==================");
	}

	public void after() {
		System.out
				.println("====================MethodAfterAdvice!==================");
	}
}

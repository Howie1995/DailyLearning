package org.TinySpring.AOP.Test;

import java.lang.reflect.Method;

import org.TinySpring.AOP.Advisor.BeforeMethodAdvice;

public class StartTimeBeforeMethod implements BeforeMethodAdvice {

	public void before(Method method, Object[] args, Object target) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		System.out.println("开始计时！");
		System.out.println("方法开始时间"+startTime);
	}

}
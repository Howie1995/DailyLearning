package org.TinySpring.AOP.Test;

import java.lang.reflect.Method;

import org.TinySpring.AOP.Advisor.AfterRunningAdvice;

public class EndTimeAfterMethod implements AfterRunningAdvice {

	public Object after(Object returnVal, Method method, Object[] args,
			Object targer) {
		// TODO Auto-generated method stub
		long endTime = System.currentTimeMillis();
		System.out.println("方法结束时间："+endTime);
		return returnVal;
	}

}

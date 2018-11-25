package org.TinySpring.AOP.Adaptor;

import org.TinySpring.AOP.Advisor.Advisor;
import org.TinySpring.AOP.Advisor.BeforeMethodAdvice;
import org.TinySpring.AOP.Interceptor.AopMethodInterceptor;
import org.TinySpring.AOP.Interceptor.BeforeMethodAdviceInterceptor;

public class BeforeMethodAdviceAdapter implements AdviceAdapter {

	public BeforeMethodAdviceAdapter() {
		
	}

	private static final BeforeMethodAdviceAdapter INSTANTS = 
			new BeforeMethodAdviceAdapter();
	
	public static BeforeMethodAdviceAdapter getInstants(){
		return INSTANTS;
	}
	
	public AopMethodInterceptor getInterceptor(Advisor advisor) {
		// TODO Auto-generated method stub
		BeforeMethodAdvice advice = (BeforeMethodAdvice) advisor.getAdvice();
		return new BeforeMethodAdviceInterceptor(advice);
	}

}
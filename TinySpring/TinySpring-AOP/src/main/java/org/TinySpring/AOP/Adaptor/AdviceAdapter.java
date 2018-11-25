package org.TinySpring.AOP.Adaptor;

import org.TinySpring.AOP.Advisor.Advisor;
import org.TinySpring.AOP.Interceptor.AopMethodInterceptor;

public interface AdviceAdapter {

	AopMethodInterceptor getInterceptor(Advisor advisor);
	
}

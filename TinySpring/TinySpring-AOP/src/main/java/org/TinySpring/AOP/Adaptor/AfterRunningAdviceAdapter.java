package org.TinySpring.AOP.Adaptor;

import org.TinySpring.AOP.Advisor.Advisor;
import org.TinySpring.AOP.Advisor.AfterRunningAdvice;
import org.TinySpring.AOP.Interceptor.AfterRunningAdviceInterceptor;
import org.TinySpring.AOP.Interceptor.AopMethodInterceptor;

public class AfterRunningAdviceAdapter implements AdviceAdapter {

	private AfterRunningAdviceAdapter(){

    }

    private static final AfterRunningAdviceAdapter INSTANTS = 
    		new AfterRunningAdviceAdapter();
    
    public static AfterRunningAdviceAdapter getInstants(){
        return INSTANTS;
    }

    public AopMethodInterceptor getInterceptor(Advisor advisor) {
        AfterRunningAdvice advice = (AfterRunningAdvice) advisor.getAdvice();
        return new AfterRunningAdviceInterceptor(advice);
    }
}
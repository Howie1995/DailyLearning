package org.TinySpring.AOP.Interceptor;

import org.TinySpring.AOP.Advisor.AfterRunningAdvice;
import org.TinySpring.AOP.Invocation.MethodInvocation;

/**
 * @author hongyang.jiang
 */
public class AfterRunningAdviceInterceptor implements AopMethodInterceptor {

    private AfterRunningAdvice advice;

    public AfterRunningAdviceInterceptor(AfterRunningAdvice advice) {
        this.advice = advice;
    }

    public Object invoke(MethodInvocation mi) throws Throwable {
        Object returnVal = mi.proceed();
        advice.after(returnVal,mi.getMethod(),mi.getArguments(),mi);
        return returnVal;
    }
}

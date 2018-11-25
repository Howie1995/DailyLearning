package org.TinySpring.AOP.Interceptor;

import org.TinySpring.AOP.Advisor.BeforeMethodAdvice;
import org.TinySpring.AOP.Invocation.MethodInvocation;

public class BeforeMethodAdviceInterceptor implements AopMethodInterceptor {

    private BeforeMethodAdvice advice;

    public BeforeMethodAdviceInterceptor(BeforeMethodAdvice advice) {
        this.advice = advice;
    }

    public Object invoke(MethodInvocation mi) throws Throwable {
        advice.before(mi.getMethod(),mi.getArguments(),mi);
        return mi.proceed();
    }
}

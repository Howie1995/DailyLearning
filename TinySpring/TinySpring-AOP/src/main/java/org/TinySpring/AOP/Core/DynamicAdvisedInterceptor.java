package org.TinySpring.AOP.Core;

import java.lang.reflect.Method;
import java.util.List;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import org.TinySpring.AOP.Advisor.TargetSource;
import org.TinySpring.AOP.Interceptor.AopMethodInterceptor;
import org.TinySpring.AOP.Invocation.CglibMethodInvocation;
import org.TinySpring.AOP.Invocation.MethodInvocation;

public class DynamicAdvisedInterceptor implements MethodInterceptor {

	protected final List<AopMethodInterceptor> interceptorList;
	protected final TargetSource targetSource;
	
	public DynamicAdvisedInterceptor(List<AopMethodInterceptor> interceptorLists,
			TargetSource targetSource){
		this.interceptorList = interceptorLists;
		this.targetSource = targetSource;
	}
	
	public Object intercept(Object obj, Method method, Object[] arg,
			MethodProxy proxy) throws Throwable {

        MethodInvocation invocation = new CglibMethodInvocation(obj,targetSource.getTargetObject(),method, arg,interceptorList,proxy);
		return invocation.proceed();
	}

}

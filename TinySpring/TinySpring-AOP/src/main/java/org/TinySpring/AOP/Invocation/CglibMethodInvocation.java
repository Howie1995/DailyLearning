package org.TinySpring.AOP.Invocation;

import java.lang.reflect.Method;
import java.util.List;

import net.sf.cglib.proxy.MethodProxy;

import org.TinySpring.AOP.Interceptor.AopMethodInterceptor;

public class CglibMethodInvocation extends ReflectioveMethodeInvocation {

    private MethodProxy methodProxy;

    public CglibMethodInvocation(Object proxy, Object target, Method method, Object[] arguments, List<AopMethodInterceptor> interceptorList, MethodProxy methodProxy) {
        super(proxy, target, method, arguments, interceptorList);
        this.methodProxy = methodProxy;
    }

    @Override
    protected Object invokeOriginal() throws Throwable {
        return methodProxy.invoke(target,arguments);
    }
}
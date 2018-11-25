package org.TinySpring.AOP.Core;

public interface AopProxy {

	Object getProxy();
	
	Object getProxy(ClassLoader classLoader);
	
}

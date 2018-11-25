package org.TinySpring.AOP;

import org.TinySpring.AOP.Core.AopApplicationContext;
import org.TinySpring.AOP.Test.TestService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 同样地这里先读取配置，这里面配置了目标类以及要进行代理的类
		 */
		AopApplicationContext aopApplicationContext = 
				new AopApplicationContext("application.json");		
        aopApplicationContext.init();
        TestService testService;
		try {
			testService = (TestService) aopApplicationContext.getBean("TestService");
			testService.testMethod();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

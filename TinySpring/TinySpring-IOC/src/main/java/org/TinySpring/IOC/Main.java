package org.TinySpring.IOC;

import org.TinySpring.IOC.Core.JsonApplicationContext;
import org.TinySpring.IOC.Entity.Robot;

public class Main {

	/**
	 * 读取配置文件，apc里面完成初始化
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	       JsonApplicationContext applicationContext = 
	    		   new JsonApplicationContext("application.json"); 
	       applicationContext.init();		//读取配置文件中配置的类，最终将其实例加载到map中
	       try {
	    	   Robot aiRobot = (Robot) applicationContext.getBean("robot");		//创建类实例
	    	   aiRobot.show();													//使用类
	       } catch (Exception e) {
	    	   // TODO Auto-generated catch block
	    	   e.printStackTrace();
	       }
	}

}

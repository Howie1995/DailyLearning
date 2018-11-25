package org.TinySpring.IOC.Core;

import java.io.InputStream;
import java.util.List;

import org.TinySpring.IOC.Bean.BeanDefinition;
import org.TinySpring.Utils.JsonUtils;

import com.fasterxml.jackson.core.type.TypeReference;

public class JsonApplicationContext extends BeanFactoryImpl {

	private String fileName;
	
	public JsonApplicationContext(String fileName){
		this.fileName = fileName;
	}
	
	public void init(){
		loadFile();
	}

	private void loadFile() {
		// TODO Auto-generated method stub
		InputStream is = Thread.currentThread().getContextClassLoader().
				getResourceAsStream(fileName);		//读取文件，加载到输入流
		List<BeanDefinition> beanDefinitions = JsonUtils.readValue
				(is,new TypeReference<List<BeanDefinition>>(){});		//存储类的描述信息及属性参数值
		if(beanDefinitions!=null&&!beanDefinitions.isEmpty()){
			for(BeanDefinition beanDefinition:beanDefinitions){
				registerBean(beanDefinition.getName(),beanDefinition);	//将类和类的信息缓存进static map,用以随用随创建
			}
		}
	} 
	
}
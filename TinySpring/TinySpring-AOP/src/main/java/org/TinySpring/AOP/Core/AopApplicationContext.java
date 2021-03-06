package org.TinySpring.AOP.Core;

import java.io.InputStream;
import java.util.List;

import org.TinySpring.AOP.Bean.AopBeanDefinition;
import org.TinySpring.IOC.Bean.BeanDefinition;
import org.TinySpring.Utils.ClassUtils;
import org.TinySpring.Utils.JsonUtils;

import com.fasterxml.jackson.core.type.TypeReference;

public class AopApplicationContext extends AopBeanFactoryImpl {

	private String fileName;

	public AopApplicationContext(String fileName) {
		this.fileName = fileName;
	}

	public void init() {
		loadFile();
	}

	private void loadFile() {

		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(fileName);
		List<AopBeanDefinition> beanDefinitions = JsonUtils.readValue(is,
				new TypeReference<List<AopBeanDefinition>>() {
				});

		if (beanDefinitions != null && !beanDefinitions.isEmpty()) {

			for (AopBeanDefinition beanDefinition : beanDefinitions) {

				Class<?> clz = ClassUtils.loadClass(beanDefinition
						.getClassName());

				if (clz == ProxyFactoryBean.class) {

					registerBean(beanDefinition.getName(), beanDefinition);

				} else {

					registerBean(beanDefinition.getName(),
							(BeanDefinition) beanDefinition);

				}

			}

		}

	}
}

### AOP
#### Spring的AOP实现
* 初始化AOP容器
* 读取配置文件
* 将配置文件装换为AOP能够识别的数据结构-Advisor;Advisor又包含2个数据结构，一个是Advice(描述一个切面的行为)，一个Pointcut(切面的位置)。
* Spring将Advisor转换为自己能够识别的数据结构-AdvisorSupport。Spring动态的将这些方法拦截器植入到对应的方法中
* 生成动态代理代理
* 提供调用，在调用的时候，调用方调用的就是代理方法。也就是已经织入了增强方法的方法

#### 代码结构
* invacation:描述的就是一个方法的调用
* interceptor:拦截器,拦截invocation包里面的调用
* advisor:用来描述切面的数据结构
* adaptor:适配器方法，将advice包里的对象适配为interceptor
* bean:描述我们json配置文件的对象，在IOC的BeanDefinition的基础上加上了描述AOP的target和interceptor字段
* core:框架的核心逻辑

#### 流程描述
从配置文件中读取目标类和拦截类，初始化容器，最终配置文件描述的类信息会被存储进AOPBeanFactoryImpl中的beanDefinition中;
使用时从容器中获取目标类的实例，初次使用时要从beanDefinition中构建AdvisedSupport类，里面描述了目标类和拦截器类;
最后，从CglibAopProxy中获取代理生成的目标类（实际上是目标类的子类，里面包含了拦截器的描述--关于[动态代理原理](http://ifeve.com/jdk%E5%8A%A8%E6%80%81%E4%BB%A3%E7%90%86%E4%BB%A3%E7%90%86%E4%B8%8Ecglib%E4%BB%A3%E7%90%86%E5%8E%9F%E7%90%86%E6%8E%A2%E7%A9%B6/)的复习）
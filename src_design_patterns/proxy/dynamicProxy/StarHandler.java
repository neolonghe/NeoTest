package proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StarHandler implements InvocationHandler{
	Star realStar;

	/**
	 * 构造器
	 * @param realStar
	 */
	public StarHandler(Star realStar) {
		super();
		this.realStar = realStar;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object obj = null;
		System.out.println("------>这里做统一流程控制<------");
		System.out.println("唱歌之前的一系列操作。。。");
		if ("sing".equals(method.getName())) {
			obj = method.invoke(realStar, args);
		}
		System.out.println("唱歌之后的一系列操作。。。");
		return obj;
	}



}

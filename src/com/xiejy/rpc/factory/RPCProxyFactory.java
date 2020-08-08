package com.xiejy.rpc.factory;

import java.lang.reflect.Proxy;

public class RPCProxyFactory {
	/**
	 * 你传一个什么接口给我，我给你返回什么对象（实现了该接口）
	 * 
	 * @param <T>
	 * @param clazz
	 * @return
	 */
	public static <T> T getProxyInstanceByInterfaceClazz(Class<T> clazz) {
		// 通过jdk动态代理的方式完成clazz接口实体创建
		// 三个参数分别是类加载器、接口的字节码对象以及InvocationHandler对象
		// 字节码的重组的方式，在我们的jvm中动态创建一个类，此类名一般为$Proxy+num，若是第一次的话就是$Proxy0，
		// 此类实现了传入的接口的字节码，比如我们传入的是IUserService.class，那么它就是实现了IUserService接口
		return (T) Proxy.newProxyInstance(RPCProxyFactory.class.getClassLoader(),
				new Class[] { clazz }, new RPCInvocationHandler(clazz));
	}
}

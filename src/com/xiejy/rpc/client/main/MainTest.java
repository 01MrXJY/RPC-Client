package com.xiejy.rpc.client.main;

import com.xiejy.rpc.api.IUserService;
import com.xiejy.rpc.factory.RPCProxyFactory;

public class MainTest {
	public static void main(String[] args) {
		// 传入一个什么接口，就通过jdk的动态代理创建出一个代理了该接口的对象
		IUserService proxyInstance = RPCProxyFactory.getProxyInstanceByInterfaceClazz(IUserService.class);
		// 这里调用了insertUser方法，实际上去执行了RPCInvocationHandler类里面的invoke方法
		proxyInstance.insertUser("tom", 23);
	} 
}

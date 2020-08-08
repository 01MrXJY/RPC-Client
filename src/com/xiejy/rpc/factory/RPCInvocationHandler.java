package com.xiejy.rpc.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.xiejy.rpc.api.ServiceMapped;
import com.xiejy.rpc.dto.RPCTransFormObj;
import com.xiejy.rpc.net.ClientSocket;

public class RPCInvocationHandler implements InvocationHandler {
	
	private Class<?> clazz;
	public RPCInvocationHandler(Class<?> clazz) {
		this.clazz = clazz;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
//		System.out.println("hello,it is me");
//		System.out.println(method.getName());
//		for (int i = 0;i<args.length;i++) {
//			System.out.println(args[i]);
//		}
		// 网络通信，去请求远程接口，完成整个服务的调用
		RPCTransFormObj rpcTransFormObj = null;
		String fullClassName = clazz.getAnnotation(ServiceMapped.class).mapped();
		rpcTransFormObj.setFullClassName(fullClassName);
		rpcTransFormObj.setMethodName(method.getName());
		rpcTransFormObj.setParameters(args);
		// 发起网络请求
		return ClientSocket.callRemoteService(rpcTransFormObj, "127.0.0.1", 10000);
	}

}

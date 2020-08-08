package com.xiejy.rpc.dto;

import java.io.Serializable;

public class RPCTransFormObj implements Serializable {
	private static final long serialVersionUID = 2L;
	private String classFullName;
	private String methodName;
	private Object[] parameters;

	public String getClassFullName() {
		return classFullName;
	}

	public void setFullClassName(String classFullName) {
		this.classFullName = classFullName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Object[] getParameters() {
		return parameters;
	}

	public void setParameters(Object[] parameters) {
		this.parameters = parameters;
	}

}

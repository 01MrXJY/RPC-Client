package com.xiejy.rpc.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Retention定义的是这个注解在什么情况下还会保留
 * @Target定义的是该注解是给谁用的
 * @Target(ElementType.Type)就是说不管是在接口还是类上都可以使用该注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ServiceMapped {
	String mapped();

}

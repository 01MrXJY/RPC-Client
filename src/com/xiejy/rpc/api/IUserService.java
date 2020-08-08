package com.xiejy.rpc.api;

import com.xiejy.rpc.dto.UserDTO;

// 等于就是说对于此接口来说，给它指定了一个默认的实现
@ServiceMapped(mapped = "com.xiejy.rpc.impl.UserServiceImpl")
public interface IUserService {
	public abstract UserDTO insertUser(String name,int age);
}

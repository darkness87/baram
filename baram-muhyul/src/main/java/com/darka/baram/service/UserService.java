package com.darka.baram.service;

import java.util.List;

import com.darka.baram.vo.UserVO;

public interface UserService {

	public List<UserVO> getUserList();
	public UserVO getUserByUserId(String userId);
	public UserVO getUserByUserName(String userName);

}
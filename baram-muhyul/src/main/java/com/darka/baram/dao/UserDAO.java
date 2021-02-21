package com.darka.baram.dao;

import java.util.List;

import com.darka.baram.vo.UserVO;

public interface UserDAO {
	public List<UserVO> getUserList();
	public UserVO getUser(String userId);
}

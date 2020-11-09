package com.darka.baram.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darka.baram.mapper.UserMapper;
import com.darka.baram.vo.UserVO;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public void addUser(String userName, String userClass) throws SQLException {
		UserVO userVO = new UserVO(userName, userClass);
		userMapper.insertUser(userVO);
	}

	public List<UserVO> getUserList() {
		return userMapper.selectUserList();
	}

	public int modifyUserLevel(String userName, int level) throws SQLException {
		UserVO userVO = new UserVO(userName, level);
		return userMapper.updateUserLevel(userVO);
	}
}
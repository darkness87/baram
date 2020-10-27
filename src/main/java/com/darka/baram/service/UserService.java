package com.darka.baram.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darka.baram.mapper.UserMapper;
import com.darka.baram.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public List<UserVO> getUserInfo() {
		try {
			return userMapper.selectUserList();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}
}
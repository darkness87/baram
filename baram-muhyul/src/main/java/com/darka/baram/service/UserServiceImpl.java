package com.darka.baram.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.darka.baram.dao.UserDAO;
import com.darka.baram.repository.UserRepository;
import com.darka.baram.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepository userRepository;

	@Autowired
	public UserDAO userDAO;

	@Override
	public List<UserVO> getUserList() {
		List<UserVO> userList = userRepository.findAll();
		log.debug("{}", userList);

		return userList;
	}

	@Override
	public UserVO getUserByUserId(String userId) {
		UserVO userVO = userDAO.getUser(userId);
		UserVO userVO2 = userRepository.findByUserId(userId);
		log.debug("{}", userVO);
		log.debug("{}", userVO2);

		return userVO;
	}

	@Override
	public UserVO getUserByUserName(String userName) {
		UserVO userVO = userRepository.findByUserName(userName);
		log.debug("{}", userVO);

		return userVO;
	}

}
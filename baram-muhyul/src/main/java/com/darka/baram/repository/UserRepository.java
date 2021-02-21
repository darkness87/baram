package com.darka.baram.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.darka.baram.vo.UserVO;

public interface UserRepository extends JpaRepository<UserVO, String> {

	public UserVO findByUserId(String id);

	public UserVO findByUserName(String userName);

}
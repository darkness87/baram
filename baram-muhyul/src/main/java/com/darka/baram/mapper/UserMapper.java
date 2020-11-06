package com.darka.baram.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.darka.baram.vo.UserVO;

@Mapper
public interface UserMapper {
	public List<UserVO> selectUserList() throws Exception;
	public int selectUserCount();
	public int updateUserLevel(UserVO userVO);
}
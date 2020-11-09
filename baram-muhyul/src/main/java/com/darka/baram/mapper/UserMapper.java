package com.darka.baram.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.darka.baram.vo.UserVO;

@Mapper
public interface UserMapper {
	public int insertUser(UserVO userVO) throws SQLException;
	public List<UserVO> selectUserList();
	public int updateUserLevel(UserVO userVO) throws SQLException;
}
package com.darka.baram.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.darka.baram.vo.UserInfoVO;

@Mapper
public interface UserInfoMapper {
	public List<UserInfoVO> selectUserInfoList() throws Exception;
	public int selectUserInfoCount();
}
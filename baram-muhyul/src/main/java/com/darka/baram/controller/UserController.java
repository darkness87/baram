package com.darka.baram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.darka.baram.service.UserService;
import com.darka.baram.vo.UserVO;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/userList.do")
	@ResponseBody public List<UserVO> userList() {
		List<UserVO> userList = userService.getUserList();

		return userList;
	}

	@GetMapping("/user.do")
	@ResponseBody public UserVO user(String userId) {
		UserVO userVO = userService.getUserByUserId(userId);

		return userVO;
	}
}
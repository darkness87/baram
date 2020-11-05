package com.darka.baram.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserVO {
	private String userId;
	private String userName;
	private String password;
	private String userClass;
	private Date createDate;
	private Date destroyDate;
	private int base_score;
	private int level;
	private boolean status;

	public void setUserStatus(String userStatus) {
		status = Boolean.parseBoolean(userStatus);
	}
}
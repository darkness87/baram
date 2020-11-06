package com.darka.baram.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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

	public UserVO(String userName) {
		this(userName, "전사", 0);

		this.userId = getUniqueID(this.createDate);
	}

	public UserVO(String userName, String userClass, int level) {
		this.userName = userName;
		this.password = "1";
		this.userClass = userClass;
		this.createDate = new Date();
		this.destroyDate = null;
		this.base_score = 0;
		this.level = level;
		this.status = true;

		this.userId = getUniqueID(this.createDate);
	}

	public void setUserStatus(String userStatus) {
		status = Boolean.parseBoolean(userStatus);
	}

	private static String getUniqueID(Date date) {
		return getUniqueID(date.getTime());
	}

	private static synchronized String getUniqueID(long date) {
		String keyID = Long.toString(date, 36);

		try {
			Thread.sleep(1);
		} catch(InterruptedException ine) {
			log.debug(ine.getMessage());
		}

		return keyID;
	}
}
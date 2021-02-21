package com.darka.baram.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="BR_USER")
public class UserVO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String userId;
	private String userName;
	private String password;
	private String userClass;
	private Date createDate;
	private Date destroyDate;
	private int baseScore;
	private int userLevel;
	private boolean userStatus;
}
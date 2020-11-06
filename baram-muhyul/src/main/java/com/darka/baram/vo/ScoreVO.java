package com.darka.baram.vo;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter @Setter @ToString
public class ScoreVO {
	private String userName;
	@Getter(value=AccessLevel.NONE)
	private Date bDate;
	private int score;

	public ScoreVO(String baseDate) {
		setBaseDate(baseDate);
	}

	public ScoreVO(String userName, Date bDate) {
		this(userName, bDate, 0);
	}

	public ScoreVO(String userName, Date bDate, int score) {
		this.userName = userName;
		this.bDate = bDate;
		this.score = score;
	}

	public ScoreVO(String userName, String baseDate) {
		this(userName, baseDate, 0);
	}

	public ScoreVO(String userName, String baseDate, int score) {
		this.userName = userName;
		setBaseDate(baseDate);
		this.score = score;
	}

	public ScoreVO(String userName, String baseDate, BigDecimal score) {
		this.userName = userName;
		setBaseDate(baseDate);
		this.score = score.intValue();
	}

	public String getBaseDate() throws Exception {
		if (this.bDate == null) {
			throw new Exception("날짜 지정이 안되었습니다.");
		}

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		return format.format(bDate);
	}

	public void setBaseDate(String baseDate) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		try {
			bDate = format.parse(baseDate);
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
			bDate = null;
		}
	}
}
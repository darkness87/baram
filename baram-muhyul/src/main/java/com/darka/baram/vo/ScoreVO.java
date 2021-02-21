package com.darka.baram.vo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity(name="BR_USER_SCORE")
public class ScoreVO {
	@EmbeddedId
	private ScorePK scorePK;
	private int score;
	private int userLevel;

	protected ScoreVO() {
		this.scorePK = new ScorePK();
	}

	public ScoreVO(String baseDate) {
		this.scorePK.setBaseDate(baseDate);
	}

	public ScoreVO(String userName, String baseDate) {
		this(userName, baseDate, 0);
	}

	public ScoreVO(String userName, String baseDate, int score) {
		this.scorePK.setUserName(userName);
		this.scorePK.setBaseDate(baseDate);
		this.score = score;
	}
}
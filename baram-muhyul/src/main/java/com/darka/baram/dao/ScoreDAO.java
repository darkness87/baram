package com.darka.baram.dao;

import java.util.List;

import com.darka.baram.vo.ScoreVO;

public interface ScoreDAO {

	public void addScore(ScoreVO scoreVO);
	public List<ScoreVO> getScoreListByDate(String baseDate);
	public List<ScoreVO> getScoreListByName(String userName);

}

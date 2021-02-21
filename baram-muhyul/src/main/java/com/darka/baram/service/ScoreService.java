package com.darka.baram.service;

import java.util.List;

import com.darka.baram.vo.ScoreVO;

public interface ScoreService {

	public void addScore(ScoreVO scoreVO);
	public void addScoreList(List<ScoreVO> scoreList);
	public ScoreVO getScore(String userName, String baseDate);
	public List<ScoreVO> getScoreListByDate(String baseDate);
	List<ScoreVO> getScoreListByName(String userName);

}
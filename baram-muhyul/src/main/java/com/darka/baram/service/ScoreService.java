package com.darka.baram.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darka.baram.mapper.ScoreMapper;
import com.darka.baram.vo.ScoreVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ScoreService {

	@Autowired
	private ScoreMapper scoreMapper;

	public void addUser(ScoreVO scoreVO) throws SQLException {
		scoreMapper.insertScore(scoreVO);
	}

	public ScoreVO getScore(String userName, String baseDate) {
		try {
			ScoreVO scoreVO = new ScoreVO(userName, baseDate);
			return scoreMapper.selectScore(scoreVO);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

	public List<ScoreVO> getScoreListByName(String userName) throws SQLException {
		return scoreMapper.selectScoreListByName(userName);
	}

	public List<ScoreVO> getScoreListByDate(String baseDate) throws SQLException {
		return scoreMapper.selectScoreListByDate(new ScoreVO(baseDate));
	}
}
package com.darka.baram.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.darka.baram.dao.ScoreDAO;
import com.darka.baram.repository.ScoreRepository;
import com.darka.baram.vo.ScorePK;
import com.darka.baram.vo.ScoreVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional(readOnly = true)
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	public ScoreRepository scoreRepository;

	@Autowired
	public ScoreDAO scoreDAO;

	@Transactional
	public void addScore(ScoreVO scoreVO) {
		scoreRepository.save(scoreVO);
	}

	@Transactional
	public void addScoreList(List<ScoreVO> scoreList) {
		scoreRepository.saveAll(scoreList);
	}

	@Override
	public ScoreVO getScore(String userName, String baseDate) {
		try {
			return scoreRepository.findByScorePK(new ScorePK(userName, baseDate));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public List<ScoreVO> getScoreListByDate(String baseDate) {
		try {
			return scoreDAO.getScoreListByDate(baseDate);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public List<ScoreVO> getScoreListByName(String userName) {
		try {
			return scoreDAO.getScoreListByName(userName);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

}
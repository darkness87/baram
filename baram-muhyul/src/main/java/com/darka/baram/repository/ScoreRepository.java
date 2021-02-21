package com.darka.baram.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.darka.baram.vo.ScorePK;
import com.darka.baram.vo.ScoreVO;

public interface ScoreRepository extends JpaRepository<ScoreVO, ScorePK> {

	public ScoreVO findByScorePK(ScorePK scorePK);
	public List<ScoreVO> findAllByScorePK(ScorePK scorePK);

}
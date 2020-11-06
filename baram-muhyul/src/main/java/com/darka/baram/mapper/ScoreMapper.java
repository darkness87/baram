package com.darka.baram.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.darka.baram.vo.ScoreVO;

@Mapper
public interface ScoreMapper {
	public int insertScore(ScoreVO scoreVO) throws SQLException;
	public ScoreVO selectScore(ScoreVO scoreVO) throws SQLException;
	public List<ScoreVO> selectScoreListByName(String userName) throws SQLException;
	public List<ScoreVO> selectScoreListByDate(ScoreVO scoreVO) throws SQLException;
}
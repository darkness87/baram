package com.darka.baram.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.darka.baram.service.ScoreService;
import com.darka.baram.vo.ScoreVO;

@Controller
public class ScoreController {
	@Autowired
	private ScoreService scoreService;

	@GetMapping("/addScore.do")
	@ResponseBody public ScoreVO addScore(
			@RequestParam(required=true) String userName,
			@RequestParam(required=true) String baseDate,
			@RequestParam(required=true) int score) {
		ScoreVO scoreVO = new ScoreVO(userName, baseDate, score);
		try {
			scoreService.addUser(scoreVO);
			return scoreVO;
		} catch (SQLException e) {
			return null;
		}
	}

	@GetMapping("/getScore.do")
	@ResponseBody public ScoreVO getScore(
			@RequestParam(required=true) String userName,
			@RequestParam(required=true) String baseDate) {
		return scoreService.getScore(userName, baseDate);
	}

	@GetMapping("/getScoreList.do")
	@ResponseBody public List<ScoreVO> getScoreList(
			@RequestParam(required=false) String userName,
			@RequestParam(required=false) String baseDate) {
		try {
			if (StringUtils.isEmpty(userName) && !StringUtils.isEmpty(baseDate)) {
				return scoreService.getScoreListByDate(baseDate);
			} else if (!StringUtils.isEmpty(userName) && StringUtils.isEmpty(baseDate)) {
				return scoreService.getScoreListByName(userName);
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
}

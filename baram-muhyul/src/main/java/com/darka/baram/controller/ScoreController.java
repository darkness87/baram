package com.darka.baram.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.darka.baram.service.ScoreService;
import com.darka.baram.vo.ScoreVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("score")
public class ScoreController {
	@Autowired
	private ScoreService scoreService;

	@GetMapping("/addScore.do")
	@ResponseBody public void addScore(
			@RequestParam(required=true) String userName,
			@RequestParam(required=true) String baseDate,
			@RequestParam(required=true) int score) {
		ScoreVO scoreVO = new ScoreVO(userName, baseDate, score);
		scoreService.addScore(scoreVO);
	}

	@GetMapping("/addScoreList.do")
	@ResponseBody public void addScoreList(
			@RequestParam(required=true) String userName,
			@RequestParam(required=true) String baseDate,
			@RequestParam(required=true) int score) {
		ScoreVO scoreVO = new ScoreVO(userName, baseDate, score);
		scoreService.addScoreList(Arrays.asList(scoreVO));
	}

	@RequestMapping("/getScore.do")
	@ResponseBody public ScoreVO getScore(
			@RequestParam(required=true) String userName,
			@RequestParam(required=true) String baseDate) {
		return scoreService.getScore(userName, baseDate);
	}

	@GetMapping("/getScoreList.do")
	@ResponseBody public List<ScoreVO> getScoreList(
//			@PathVariable String userId,
			@RequestParam(required=false) String userName,
			@RequestParam(required=false) String baseDate) {

		try {
			if (Strings.isEmpty(userName) && !Strings.isEmpty(baseDate)) {
				return scoreService.getScoreListByDate(baseDate);
			} else if (!Strings.isEmpty(userName) && Strings.isEmpty(baseDate)) {
				return scoreService.getScoreListByName(userName);
			} else {
				return null;
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

}

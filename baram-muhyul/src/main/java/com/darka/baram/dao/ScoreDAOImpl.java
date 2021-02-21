package com.darka.baram.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Repository;

import com.darka.baram.vo.ScoreVO;

@Repository
public class ScoreDAOImpl extends AbsDAO implements ScoreDAO {

	@Override
	public void addScore(ScoreVO scoreVO) {
		em.persist(scoreVO);
	}

	@Override
	public List<ScoreVO> getScoreListByDate(String baseDate) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<ScoreVO> query = builder.createQuery(ScoreVO.class);
		Root<ScoreVO> root = query.from(ScoreVO.class);

		List<Predicate> predicates = new ArrayList<>();

		if (Strings.isNotEmpty(baseDate)) {
			predicates.add(builder.equal(root.get("scorePK").get("baseDate"), baseDate));
		}

		query.select(root)
				.where(predicates.toArray(new Predicate[0]));

		return em.createQuery(query).getResultList();
	}

	@Override
	public List<ScoreVO> getScoreListByName(String userName) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<ScoreVO> query = builder.createQuery(ScoreVO.class);
		Root<ScoreVO> root = query.from(ScoreVO.class);

		List<Predicate> predicates = new ArrayList<>();

		if (Strings.isNotEmpty(userName)) {
			predicates.add(builder.equal(root.get("scorePK").get("userName"), userName));
		}

		query.select(root)
				.where(predicates.toArray(new Predicate[0]));

		return em.createQuery(query).getResultList();
	}

}

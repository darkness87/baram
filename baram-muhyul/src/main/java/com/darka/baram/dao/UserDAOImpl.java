package com.darka.baram.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Repository;

import com.darka.baram.vo.UserVO;

@Repository
public class UserDAOImpl extends AbsDAO implements UserDAO {

	@Override
	public List<UserVO> getUserList() {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<UserVO> query = builder.createQuery(UserVO.class);
		Root<UserVO> root = query.from(UserVO.class);
		query.select(root);

		return em.createQuery(query).getResultList();
	}

	@Override
	public UserVO getUser(String userId) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<UserVO> query = builder.createQuery(UserVO.class);
		Root<UserVO> root = query.from(UserVO.class);

		List<Predicate> predicates = new ArrayList<>();

		if (Strings.isNotEmpty(userId)) {
			predicates.add(builder.equal(root.get("userId"), userId));
		}

		query.select(root)
				.where(predicates.toArray(new Predicate[0]));

		return em.createQuery(query).getSingleResult();
	}

}

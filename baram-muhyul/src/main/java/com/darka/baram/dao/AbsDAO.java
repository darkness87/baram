package com.darka.baram.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AbsDAO {
	@PersistenceContext
	protected EntityManager em;
}

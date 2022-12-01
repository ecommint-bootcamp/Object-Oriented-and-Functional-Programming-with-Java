package org.javaturk.jpa.ch13.plain.tx.annotation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.NEVER)
public class LogDao implements LogDaoI {
	
	@PersistenceContext(unitName="springPlainTxAnnotation")
	private EntityManager em;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void log(String desc) {
		Log log = new Log(desc);
		em.persist(log);
	}

}

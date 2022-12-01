package org.javaturk.jpa.ch13.plain.tx.xml;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;

public class LogDao implements LogDaoI {
	
	@PersistenceContext(unitName="springPlainTxXml")
	private EntityManager em;

	@Override
	public void log(String desc) {
		Log log = new Log(desc);
		em.persist(log);
	}

}

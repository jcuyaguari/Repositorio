package com.inbox.DAO;
// Generated 07/09/2020 16:24:22 by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Empresa.
 * @see com.inbox.DAO.Empresa
 * @author Hibernate Tools
 */
@Stateless
public class EmpresaHome {

	private static final Log log = LogFactory.getLog(EmpresaHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Empresa transientInstance) {
		log.debug("persisting Empresa instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Empresa persistentInstance) {
		log.debug("removing Empresa instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Empresa merge(Empresa detachedInstance) {
		log.debug("merging Empresa instance");
		try {
			Empresa result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Empresa findById(int id) {
		log.debug("getting Empresa instance with id: " + id);
		try {
			Empresa instance = entityManager.find(Empresa.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}

package com.inbox.DAO;
// Generated 07/09/2020 16:24:22 by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Presentacion.
 * @see com.inbox.DAO.Presentacion
 * @author Hibernate Tools
 */
@Stateless
public class PresentacionHome {

	private static final Log log = LogFactory.getLog(PresentacionHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Presentacion transientInstance) {
		log.debug("persisting Presentacion instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Presentacion persistentInstance) {
		log.debug("removing Presentacion instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Presentacion merge(Presentacion detachedInstance) {
		log.debug("merging Presentacion instance");
		try {
			Presentacion result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Presentacion findById(int id) {
		log.debug("getting Presentacion instance with id: " + id);
		try {
			Presentacion instance = entityManager.find(Presentacion.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}

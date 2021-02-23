package com.inbox.DAO;
// Generated 07/09/2020 16:24:22 by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Detalle.
 * @see com.inbox.DAO.Detalle
 * @author Hibernate Tools
 */
@Stateless
public class DetalleHome {

	private static final Log log = LogFactory.getLog(DetalleHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Detalle transientInstance) {
		log.debug("persisting Detalle instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Detalle persistentInstance) {
		log.debug("removing Detalle instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Detalle merge(Detalle detachedInstance) {
		log.debug("merging Detalle instance");
		try {
			Detalle result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Detalle findById(int id) {
		log.debug("getting Detalle instance with id: " + id);
		try {
			Detalle instance = entityManager.find(Detalle.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}

package com.inbox.DAO;
// Generated 07/09/2020 16:24:22 by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Rolsistema.
 * @see com.inbox.DAO.Rolsistema
 * @author Hibernate Tools
 */
@Stateless
public class RolsistemaHome {

	private static final Log log = LogFactory.getLog(RolsistemaHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Rolsistema transientInstance) {
		log.debug("persisting Rolsistema instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Rolsistema persistentInstance) {
		log.debug("removing Rolsistema instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Rolsistema merge(Rolsistema detachedInstance) {
		log.debug("merging Rolsistema instance");
		try {
			Rolsistema result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Rolsistema findById(int id) {
		log.debug("getting Rolsistema instance with id: " + id);
		try {
			Rolsistema instance = entityManager.find(Rolsistema.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}

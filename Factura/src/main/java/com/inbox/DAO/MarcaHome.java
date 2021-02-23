package com.inbox.DAO;
// Generated 07/09/2020 16:24:22 by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.inbox.Model.Marca;

/**
 * Home object for domain model class Marca.
 * @see com.inbox.DAO.Marca
 * @author Hibernate Tools
 */
@Stateless
public class MarcaHome {

	private static final Log log = LogFactory.getLog(MarcaHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Marca transientInstance) {
		log.debug("persisting Marca instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Marca persistentInstance) {
		log.debug("removing Marca instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Marca merge(Marca detachedInstance) {
		log.debug("merging Marca instance");
		try {
			Marca result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Marca findById(int id) {
		log.debug("getting Marca instance with id: " + id);
		try {
			Marca instance = entityManager.find(Marca.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}

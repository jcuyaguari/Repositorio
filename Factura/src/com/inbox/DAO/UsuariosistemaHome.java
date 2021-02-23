package com.inbox.DAO;
// Generated 07/09/2020 16:24:22 by Hibernate Tools 5.2.12.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Usuariosistema.
 * @see com.inbox.DAO.Usuariosistema
 * @author Hibernate Tools
 */
@Stateless
public class UsuariosistemaHome {

	private static final Log log = LogFactory.getLog(UsuariosistemaHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Usuariosistema transientInstance) {
		log.debug("persisting Usuariosistema instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Usuariosistema persistentInstance) {
		log.debug("removing Usuariosistema instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Usuariosistema merge(Usuariosistema detachedInstance) {
		log.debug("merging Usuariosistema instance");
		try {
			Usuariosistema result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Usuariosistema findById(int id) {
		log.debug("getting Usuariosistema instance with id: " + id);
		try {
			Usuariosistema instance = entityManager.find(Usuariosistema.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}

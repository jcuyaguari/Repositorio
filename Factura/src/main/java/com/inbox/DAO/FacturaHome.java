package com.inbox.DAO;
// Generated 07/09/2020 16:24:22 by Hibernate Tools 5.2.12.Final

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.inbox.Model.Factura;

/**
 * Home object for domain model class Factura.
 * @see com.inbox.DAO.Factura
 * @author Hibernate Tools
 */
@Stateless
public class FacturaHome {

	private static final Log log = LogFactory.getLog(FacturaHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Factura transientInstance) {
		log.debug("persisting Factura instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Factura persistentInstance) {
		log.debug("removing Factura instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Factura merge(Factura detachedInstance) {
		log.debug("merging Factura instance");
		try {
			Factura result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Factura findById(int id) {
		log.debug("getting Factura instance with id: " + id);
		try {
			Factura instance = entityManager.find(Factura.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List <Factura> findAll() {
		try {
			String query="SELECT f FROM Factura f";
			Query q = entityManager.createQuery(query, Factura.class);
			return q.getResultList();
		} catch (RuntimeException re) {
			throw re;
		}
	}
}

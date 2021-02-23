package com.inbox.DAO;
// Generated 07/09/2020 16:24:22 by Hibernate Tools 5.2.12.Final

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.inbox.Model.Persona;


/**
 * Home object for domain model class Persona.
 * @see com.inbox.DAO.Persona
 * @author Hibernate Tools
 */
@Stateless
public class PersonaHome {

	private static final Log log = LogFactory.getLog(PersonaHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Persona transientInstance) {
		log.debug("persisting Persona instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Persona persistentInstance) {
		log.debug("removing Persona instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Persona merge(Persona detachedInstance) {
		log.debug("merging Persona instance");
		try {
			Persona result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

//	public Persona findById(int id) {
//		log.debug("getting Persona instance with id: " + id);
//		try {
//			Persona instance = entityManager.find(Persona.class, id);
//			log.debug("get successful");
//			return instance;
//		} catch (RuntimeException re) {
//			log.error("get failed", re);
//			throw re;
//		}
//	}
	
	
	  public Persona findById(int id) throws Exception {
	        try {
	        	String jpql = "SELECT p FROM Persona p WHERE p.perId = :id ";
	            Query q = entityManager.createQuery(jpql, Persona.class);
	            q.setParameter("id", id);
	            System.out.println("----idllega->"+id);
	            System.out.println("----q->"+q.toString());
	            System.out.println("----qsinlge->"+q.getSingleResult().toString());
	            return (Persona) q.getSingleResult();
	            
	        } catch (Exception e) {
	            throw new Exception("Erro buscar por  ID " +e.getMessage());
	        }
	        
	    }
	
		
	public List<Persona> findAll (){
		try {
			String jpql ="SELECT p FROM Persona p";
			Query q = entityManager.createQuery(jpql, Persona.class);
			return q.getResultList();
		} catch (RuntimeException re) {
			throw re;
		}
	}
}

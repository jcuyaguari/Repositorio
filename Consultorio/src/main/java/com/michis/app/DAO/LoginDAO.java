package com.michis.app.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.michis.app.modelo.Login;

@Stateless
public class LoginDAO {

	@PersistenceContext
	private EntityManager em; 
	
	public void insertarLogin(Login l) {
		em.persist(l);
	}
	
	
}

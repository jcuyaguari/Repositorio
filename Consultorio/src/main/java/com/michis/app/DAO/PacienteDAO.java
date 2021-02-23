package com.michis.app.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.michis.app.modelo.Paciente;

@Stateless
public class PacienteDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insertar(Paciente p) {
		em.persist(p);
	}
	
	
}

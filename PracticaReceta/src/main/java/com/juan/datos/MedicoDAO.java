package com.juan.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.juan.modelo.Medico;
import com.juan.modelo.Productos;

@Stateless
public class MedicoDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insertarMedico(Medico medico) {
		em.persist(medico);
	}
	
	public List<Medico> getMedicos(String filtro){
		String jpql ="SELECT m FROM Medico m "
				+ "WHERE nombre LIKE:filtro";
		Query q= em.createQuery(jpql,Medico.class);
		q.setParameter("filtro", filtro+"%");
		System.out.println("ListaMedicos-->"+q.getResultList());
		return q.getResultList();
	}
}

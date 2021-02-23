package com.juan.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.juan.modelo.Receta;
import com.juan.modelo.RecetaDetalle;

@Stateless
public class RecetaDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insertarReceta(Receta receta) {
		em.persist(receta);
	}
	
	public List<Receta> getReceta(String codigo){
		String jpql = "SELECT r FROM Receta r " 
				+ "WHERE codigo LIKE:codigo";
		Query q = em.createNamedQuery(jpql, Receta.class);
		q.setParameter("codigo", codigo+"%");
		return q.getResultList();
	}
	
}

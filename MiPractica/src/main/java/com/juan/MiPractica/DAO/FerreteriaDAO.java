package com.juan.MiPractica.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.juan.MiPractica.modelo.Fproducto;
import com.juan.MiPractica.modelo.Fproveedores;

@Stateless
public class FerreteriaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Fproducto> getInventario() {
		String jpql = "SELECT f FROM Fproducto f";
		Query q = em.createQuery(jpql, Fproducto.class);
		//q.setParameter("filtro", filtro+"%");
		System.out.println("hola"+q.getFirstResult());
		return q.getResultList();
	}
	
	public List<Fproveedores> getproveedores(){
		String jpql = "SELECT p FROM Fproveedores p";
		Query q = em.createQuery(jpql, Fproveedores.class);
		
		return q.getResultList();
	}

}

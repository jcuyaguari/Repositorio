package com.juan.MiPractica.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.juan.MiPractica.modelo.Fproducto;

@Stateless
public class ProductoDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insertarProdcutos(Fproducto producto) {
		em.persist(producto);
	}
	
}

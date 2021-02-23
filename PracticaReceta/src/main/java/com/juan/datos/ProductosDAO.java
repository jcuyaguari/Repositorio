package com.juan.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.juan.modelo.Productos;
import com.juan.modelo.Receta;

@Stateless
public class ProductosDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insertarProducto (Productos p) {
		em.persist(p);
	}
	
	public List<Productos> getProductos(String filtro){
		String jpql ="SELECT p FROM Productos p "
				+ "WHERE nombre LIKE:filtro";
		Query q= em.createQuery(jpql,Productos.class);
		q.setParameter("filtro", filtro+"%");
		System.out.println("ListaProdustos-->"+q.getResultList());
		return q.getResultList();
	}
	
}

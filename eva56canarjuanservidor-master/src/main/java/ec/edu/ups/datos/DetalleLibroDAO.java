package ec.edu.ups.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.modelo.Detalle;
import ec.edu.ups.modelo.Libro;

@Stateless
public class DetalleLibroDAO {

	@PersistenceContext
	private EntityManager em;
	
	public DetalleLibroDAO (){
		
	}
	
	public void insertar(Detalle d) {
		em.persist(d);
	}
	
	 public List<Libro> getDetalles(String filtro) {
		 
		 
			String jpql = "SELECT l FROM Libro l " 
					+ "WHERE codigo LIKE:filtro";
			Query q = em.createQuery(jpql, Libro.class);
			q.setParameter("filtro", filtro+"%");
			return q.getResultList();
	
}
	
}

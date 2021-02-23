package ec.edu.ups.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.modelo.Autor;

@Stateless
public class AutorDAO {
	
	@PersistenceContext
	private EntityManager em;
	
    public List<Autor> getAutoresAll() {
		String jpql = "SELECT p FROM Autor p ";
		Query q = em.createQuery(jpql, Autor.class);
		return q.getResultList();

	}
}

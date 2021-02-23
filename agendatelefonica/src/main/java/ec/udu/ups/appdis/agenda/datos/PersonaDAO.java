package ec.udu.ups.appdis.agenda.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.udu.ups.appdis.agenda.modelo.Persona;
import ec.udu.ups.appdis.agenda.modelo.Telefono;
//import ec.udu.ups.appdis.agenda.utilidades.Conexion;

@Stateless
public class PersonaDAO {

	@PersistenceContext
	private EntityManager em;
	
    public PersonaDAO() {
    }

    public void insertar(Persona p) throws Exception {
    	em.persist(p);
    }

    public void update(Persona p) throws Exception {
    	em.merge(p);
    }

    public Persona read(Integer id) {
		return em.find(Persona.class, id);
	}
    
//    public List<Persona> getPersonas(String filtro) {
//		String jpql = "SELECT p FROM Persona p " 
//				+ "WHERE cedula LIKE:filtro";
//		Query q = em.createQuery(jpql, Persona.class);
//		q.setParameter("filtro", filtro+"%");
//		return q.getResultList();
//
//	}
    
    public List<Persona> getPersonasAll() {
		String jpql = "SELECT p FROM Persona p ";
		Query q = em.createQuery(jpql, Persona.class);
		return q.getResultList();

	}
    
    public void removeContacto(Persona per) {
 	   Persona p = read(per.getId());
 	   em.remove(p);
 	   System.out.println("Se fue  >>>>> ->>>>" +p.getId());
 	   
    }
    
    
//    public List<Persona> getAllTelefonoByPersona(Integer id) {
//    	int parametro=read(id).getId();
//		String jpql = "from Persona, Telefono JOIN telefono on persona.id=telefono.id_persona where persona.id:parametro";
//		Query q = em.createQuery(jpql, Persona.class);
//		q.setParameter("parametro", parametro);
//		return q.getResultList();
//
//	}
    
    //Delete 
    
//    public void eliminar(Integer id) throws Exception {
//    	Persona p = read(id);
//    	System.out.println("id  que llega eliminar ---->>>>" +p.getId()+ "----"+p.getNombre());
//    	em.remove(p);
//    }




}

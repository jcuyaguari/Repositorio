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
public class TelfDAO {

    public TelfDAO() {
    }
    
    @PersistenceContext
    private EntityManager em;
    
    public void insertar(Telefono t){
    	try {
    		em.persist(t);
    		System.out.println("llega al DAO >>>>>> : "+t.getNumeros());
		} catch (Exception e) {
		}
    }    
    
    public void update(Telefono t) throws Exception{
    	em.merge(t);

    }
    
//    public List<Telefono> listar(int id) throws Exception{
//
//    	String jpql = "SELECT f FROM Telefono f " 
//				+ "WHERE fk_persona = :id";
//		Query q = em.createQuery(jpql, Persona.class);
//		q.setParameter("id", id);
//		return q.getResultList();
//
//    }
    
    public void delete(Telefono t){
    	try {
    		em.remove(t);
		} catch (Exception e) {
		}
    } 

}

package com.inbox.Business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.inbox.DAO.PersonaHome;
import com.inbox.Model.Persona;

/**
 * Session Bean implementation class ClienteON
 */
@Stateless
public class PersonaON implements PersonaONRemote, PersonaONLocal {
	@Inject
	PersonaHome personaDAO;
	
	
    /**
     * Default constructor. 
     */
    public PersonaON() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void crear(Persona per) {
		personaDAO.persist(per);
	}

	@Override
	public List<Persona> findAll() {
		return personaDAO.findAll();
	}

	@Override
	public Persona findById(int id) {
		
		try {
			return personaDAO.findById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
}

package com.inbox.Business;

import java.util.List;

import javax.ejb.Remote;

import com.inbox.Model.Persona;

@Remote
public interface PersonaONRemote {
	public void crear(Persona per); 
	public List<Persona> findAll ();
	public Persona findById(int id);
}

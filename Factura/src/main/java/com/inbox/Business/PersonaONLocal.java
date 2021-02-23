package com.inbox.Business;

import java.util.List;

import javax.ejb.Local;

import com.inbox.Model.Persona;

@Local
public interface PersonaONLocal {
	public void crear(Persona per); 
	public List<Persona> findAll ();
	public Persona findById(int id);
}

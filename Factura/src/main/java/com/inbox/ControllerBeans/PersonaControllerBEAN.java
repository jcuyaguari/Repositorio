package com.inbox.ControllerBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.inbox.Business.PersonaON;
import com.inbox.Business.PersonaONLocal;
import com.inbox.Model.Persona;

@ManagedBean
@ViewScoped
public class PersonaControllerBEAN {

	@Inject
	private PersonaONLocal clienteON;
	
	private Persona newPersona;
	//private Persona auxPersona;
	private List<Persona> _newListPersona;
	
	@PostConstruct
	public void init() {
		newPersona = new Persona();
		_newListPersona = new ArrayList<Persona>();
		listarPersona();
		//auxPersona = new Persona(); 
	}

	/**
	 * Setters & Getters
	 * */
	
	public Persona getNewPersona() {
		return newPersona;
	}

	public void setNewPersona(Persona newPersona) {
		this.newPersona = newPersona;
	}
			
//	public Persona getAuxPersona() {
//		return auxPersona;
//	}
//
//	public void setAuxPersona(Persona auxPersona) {
//		this.auxPersona = auxPersona;
//	}

	public List<Persona> get_newListPersona() {
		return _newListPersona;
	}

	public void set_newListPersona(List<Persona> _newListPersona) {
		this._newListPersona = _newListPersona;
	}

	
	
	public String registrarCliente () {
		System.out.println("Se llama al registrar desdel el INDEX"+ newPersona.getPerNombre() +" Fecha registrda :"+ newPersona.getPerFechnac() );
		clienteON.crear(newPersona);
		return null;
	}
	
	public String listarPersona() {
		_newListPersona = clienteON.findAll();
		return null;
	}

	public String editarCliente(int id) {
		System.out.println("llega al actualizar por id "+ id);
		newPersona = clienteON.findById(id);
		System.out.println(newPersona.getPerCedula()+"---"+newPersona.getPerId());
		return null;
	}
	
	
}

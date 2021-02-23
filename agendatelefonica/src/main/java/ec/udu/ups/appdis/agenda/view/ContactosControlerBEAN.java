package ec.udu.ups.appdis.agenda.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.metamodel.ListAttribute;

import ec.udu.ups.appdis.agenda.business.ContactoEJBBeanLocal;
import ec.udu.ups.appdis.agenda.modelo.Persona;
import ec.udu.ups.appdis.agenda.modelo.Telefono;

@ManagedBean
@ViewScoped
public class ContactosControlerBEAN {

	@Inject
	private ContactoEJBBeanLocal onlocal;

	private Persona newpersona;
	private Telefono newtelefono;
	private List<Persona> _listPer = new ArrayList<Persona>();

	@PostConstruct
	public void init() {
		newpersona = new Persona();
		newtelefono = new Telefono();
		newpersona.getListaTelefonos().add(new Telefono()); //crea telefono vacio
		//newpersona.addTelefono(new Telefono());
		loadPersonas();
	}

	public Persona getNewpersona() {
		return newpersona;
	}

	public void setNewpersona(Persona newpersona) {
		this.newpersona = newpersona;
	}
	
	public Telefono getNewtelefono() {
		return newtelefono;
	}

	public void setNewtelefono(Telefono newtelefono) {
		this.newtelefono = newtelefono;
	}
	
	public List<Persona> get_listPer() {
		return _listPer;
	}

	public void set_listPer(List<Persona> _listPer) {
		this._listPer = _listPer;
	}
	
	
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++
	//logica de N



	public String guardarContacto() {
		try {
			onlocal.insertContacto(newpersona);
			System.out.println("paso el insertControBean");
		} catch (Exception e) {
		}
		return "Listado";
	}
		
	
	public String addTelefono() {
		newpersona.getListaTelefonos().add(new Telefono());
		//newpersona.addTelefono(new Telefono());
		return null;
	}
	
	public void loadPersonas() {
		_listPer=onlocal.getPersonasAll();
	}

}

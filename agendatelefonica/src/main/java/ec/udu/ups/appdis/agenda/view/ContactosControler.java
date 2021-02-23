package ec.udu.ups.appdis.agenda.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import ec.udu.ups.appdis.agenda.business.ContactoEJBBeanLocal;
import ec.udu.ups.appdis.agenda.modelo.Persona;
import ec.udu.ups.appdis.agenda.modelo.Telefono;

@ManagedBean
public class ContactosControler {

	@Inject
	private ContactoEJBBeanLocal onlocal;

	private String cedula;
	private String nombre;
	
	private Persona newpersona;
	
	
	private String numeros;
	private String tipo;

	public ContactosControler() {
		// numeros="pone el numero";
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public String getNumeros() {
		return numeros;
	}

	public void setNumeros(String numeros) {
		this.numeros = numeros;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	
	
	public void guardarContacto() {
		System.out.println("LLEGA ToString" + this.toString());

		List<Telefono> lista = new ArrayList<Telefono>();

		Persona p = new Persona();

		p.setCedula(cedula);
		p.setNombre(nombre);
		// p.getListaTelefonos().add(t);

		for (int i = 0; i < 2; i++) {
			Telefono t = new Telefono();
			t.setNumeros(numeros);
			t.setTipo(tipo);
			t.setPersona(p);
			lista.add(t);
		}

		//onlocal.insertContacto(lista);
	}

}

package ec.udu.ups.appdis.agenda.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import ec.udu.ups.appdis.agenda.modelo.Persona;
import ec.udu.ups.appdis.agenda.modelo.Telefono;

@Remote
public interface ContactoEJBBeanRemoto {

	//public void insertContacto(List<Telefono> telefonos);
	public void insertContacto(Persona persona);
	
	public void actualizarContacto(List<Telefono> t);
	
	public Persona listarContactos(Persona p);
	
	//public List<Persona> getPersonas(String filtro);
	
	public void eliminar(List<Telefono> telefonos);
	
	public void removeContacto(Persona per); 

	//prueba
	public List<Persona> getPersonasAll();
	//public void actualizarTelefono(Telefono t);

	//public void eliminarContacto(Persona p);
	

}

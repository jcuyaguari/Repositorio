package ec.udu.ups.appdis.agenda.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import ec.udu.ups.appdis.agenda.business.ContactoEJBBeanLocal;
import ec.udu.ups.appdis.agenda.business.ContactosEJBBean;
import ec.udu.ups.appdis.agenda.modelo.Persona;

@WebService
public class PersonasServicesSOAP {
	
	@Inject
	private ContactoEJBBeanLocal gc ;
	
	@WebMethod
	public String saludar(String nombre) {
		return "Hola: " + nombre;
	}
	
	@WebMethod
	public List<Persona> listaPersonas(){
		List<Persona> listado = new ArrayList<Persona>();
		listado = gc.getPersonasAll();
		
		return listado;
	}
	
	@WebMethod
	public String deposito(String cuentaOrigen, double valor) {
		//meotodos q llaman al on para realizar un deposito
		return null;
	}
	
//	@WebMethod
//	public String deposito2(Transaccion trx) {
//		
//		return null;
//	}
}

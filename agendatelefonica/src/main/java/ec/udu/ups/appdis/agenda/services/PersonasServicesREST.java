package ec.udu.ups.appdis.agenda.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import ec.udu.ups.appdis.agenda.business.ContactoEJBBeanLocal;
import ec.udu.ups.appdis.agenda.modelo.Persona;

@Path("/personas")
public class PersonasServicesREST {
	
	@Inject
	private ContactoEJBBeanLocal gc ;
	
	@GET
	@Path("/saludar")
	@Produces("application/json")
	public String saludar(@QueryParam("name") String nombre) {
		return "Hola: " + nombre;
	}
	
	@GET
	@Path("/saludar/{name}/{usr}")
	@Produces("application/json")
	public String saludar2(@PathParam("name") String nombre,@PathParam("usr") String usuario) {
		return "Hola: " + nombre + " eres "+usuario;
	}
	
	@GET
	@Produces("application/json")
	public List<Persona> listaPersonas(){
		List<Persona> listado = new ArrayList<Persona>();
		listado = gc.getPersonasAll();
		
		return listado;
	}
	
	
	public String deposito(String cuentaOrigen, double valor) {
	
		
		return null;
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public String deposito2(String trx) {
			System.out.println("Hola mundo soy Juanc deposito2");
		return null;
	}
}

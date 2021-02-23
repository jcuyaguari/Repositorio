package ec.udu.ups.appdis.agenda.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.udu.ups.appdis.agenda.business.ContactoEJBBeanLocal;
import ec.udu.ups.appdis.agenda.business.ContactosEJBBean;
import ec.udu.ups.appdis.agenda.modelo.Persona;
import ec.udu.ups.appdis.agenda.modelo.Telefono;

/**
 * Servlet implementation class contactosView
 */
@WebServlet("/contactosView")
public class contactosView extends HttpServlet {
	     
    
    @Inject
    private ContactoEJBBeanLocal contactBean;
    
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		
		response.getWriter().println("EGOOO");
		Persona p = new Persona();
		//p.setId(1);
		p.setCedula("8761534324");
		p.setNombre("Angiee");
	/**	
		ArrayList<Telefono> listaTelefono = new ArrayList<Telefono>();
		for (int i = 0; i < 3; i++) {
			Telefono t = new Telefono();
			//t.setId(1);
			t.setNumeros("08459"+i);
			t.setTipo("FIJO");
			t.setPersona(p);
			listaTelefono.add(t);
		}
		
		contactBean.insertContacto(listaTelefono);
	**/	
		
		//ArrayList<Telefono> listaTelefono = new ArrayList<Telefono>();
		//Telefono t = new Telefono();
		//t.setId(4);
		//t.setPersona(p);
		//listaTelefono.add(t);
		//p.setListaTelefonos(listaTelefono);
		
		//contactBean.removeContacto(p);
		
		//Persona respuesta=contactBean.listarContactos(p);
		//if(respuesta!=null)
		//response.getWriter().println(respuesta.getCedula()+"   "+ respuesta.getNombre());
	
		List<Persona> listaPersonas= new ArrayList<Persona>();
		listaPersonas=contactBean.getPersonasAll();
		for (Persona persona : listaPersonas) {
			
			//response.getWriter().println(persona.getCedula()+"  "+ persona.getNombre()+" -"+ persona.getListaTelefonos().get(0).getTipo() +"- "+ persona.getListaTelefonos()..get(0).getNumeros());//+"  TelefonoPers  "+ persona.getListaTelefonos().get(0).getTipo());
		}
		
		
		
	
//		ArrayList<Telefono> listaTelefono = new ArrayList<Telefono>();
//		for (int i = 0; i < 3; i++) {
//			Telefono t = new Telefono();
//			t.setId(1);
//			t.setNumeros("08459");
//			t.setTipo("MOVIL");
//			t.setPersona(p);
//			listaTelefono.add(t);
//		}
//		
		//contactBean.insertContacto(listaTelefono);
		//contactBean.actualizarContacto(listaTelefono);
        //p.setId(1);
//		ArrayList<Persona> lista=null;
//		
//			try {
//				//lista = contactBean.listarTelefonos(p);
//				//lista = contactBean.listarAll(p);
//				for (Persona re : lista) {
//			           // p.setId(re.getId());
//			            response.getWriter().println(re.getNombre()+" - "+re.getCedula());
//			            response.getWriter().println("\n");
//			             //ArrayList<Telefono> listaTele = co.listarTelefonos(p);
//			            
//			        }
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			
					
		}
		
		
	}


package ec.edu.ups.vista;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.modelo.Detalle;
import ec.edu.ups.modelo.Libro;
import ec.edu.ups.negocio.LibrosONLocal;

@WebServlet("/View")
public class vistaLibro extends HttpServlet {
     
	@Inject
	private LibrosONLocal ejbLocal;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().println("Llega");
	
		Libro l = new Libro();
		l.setCodigo("123");
		l.setNombre("Viaje al centro de la tierra");
		
		ArrayList<Detalle> libroDet = new ArrayList<Detalle>();
		for (int i = 0; i < 2; i++) {
			Detalle det= new Detalle();
			det.setVolumen("Volumen 1");
			det.setLibro(l);
			libroDet.add(det);
		}
		
		ejbLocal.guardarLibro(libroDet);
		
		
		
		//List <Detalle> listaLe=ejbLocal.getDetalles(123);
		for (Libro detalle : ejbLocal.getDetalles("123")) {
			response.getWriter().println("libro es: "+detalle.getNombre());
		}
		
	}
}

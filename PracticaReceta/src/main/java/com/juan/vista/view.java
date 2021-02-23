package com.juan.vista;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.juan.modelo.Productos;
import com.juan.modelo.Receta;
import com.juan.modelo.RecetaDetalle;
import com.juan.negocio.RecetaON;




@WebServlet("/view")
public class view extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private RecetaON recetaOn;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//try {
			
			response.getWriter().println("Bienvenido");
			List<Productos> lisp = new ArrayList<Productos>();
			
			Receta r = new Receta();
			r.setCodigo("12DC");
			r.setNombreCliente("Mayc");
			
			RecetaDetalle rd = new RecetaDetalle();
			rd.setCantidad(12);
			rd.setPrecio(54.0);
			
			r.getLista().add(rd);
					
			recetaOn.insertarReceta(r);
			
			
			lisp =recetaOn.getProductos("Pa");
			for (Productos productos :lisp) {
				response.getWriter().println("-..-"+ productos.getNombre());
			}
			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
	
	}


}

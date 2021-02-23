package com.michis.app.vista;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.michis.app.modelo.Paciente;

/**
 * Servlet implementation class VistaTest
 */
@WebServlet("/VistaTest")
public class VistaTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public VistaTest() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("LEGOOO");
		
		Paciente p = new Paciente();
		p.setPaciCedula("3232");
		p.setPaciNombre("Juanc Clros");
		p.setPaciEdad(23);
		p.setPaciFechanac(new Date());
		p.setPaciPeso("gordo");
	}



}

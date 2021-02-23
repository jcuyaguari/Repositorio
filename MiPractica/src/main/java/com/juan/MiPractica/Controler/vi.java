package com.juan.MiPractica.Controler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.juan.MiPractica.ON.FerreteriaON;
import com.juan.MiPractica.modelo.Fproveedores;

@WebServlet("/vi")
public class vi extends HttpServlet {
	
	@Inject
	FerreteriaON FerreteriaON;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Fproveedores> lis = new ArrayList<Fproveedores>();
		//lis=FerreteriaON.getInventario();
		for (Fproveedores fproveedores : lis) {
			response.getWriter().println("Bienvenido"+fproveedores.getProvNombre());
		}
		
		
	}



}

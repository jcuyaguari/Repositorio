package com.inbox.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inbox.Business.PersonaONLocal;
import com.inbox.Business.FacturaON;
import com.inbox.Business.FacturaONLocal;
import com.inbox.Business.LoginON;
import com.inbox.Business.LoginONLocal;
import com.inbox.Model.Detalle;
import com.inbox.Model.Factura;
import com.inbox.Model.Usuariosistema;
import com.sun.xml.bind.v2.util.FatalAdapter;

/**
 * Servlet implementation class Principal
 */
@WebServlet("/Principal")
public class Principal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Principal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Inject
    FacturaONLocal facON;
    @Inject
    PersonaONLocal cliON;
    @Inject
    LoginONLocal loginON;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Usuariosistema user = new Usuariosistema();
		user.setUserEmail("admin@gmail.com");
		user.setUserPassword("1234");
		user= loginON.read(user);
		if (user!=null) {
			if (user.getUserEmail().length()>0) {
				response.getWriter().append("los datos login  son: "+user.getUserEmail()+ " Pss:  "+user.getUserPassword()+"/n");
				
			}
		}
		else response.getWriter().append(" eno hay texo ");
		
		
		
		/*
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Factura fac= new Factura();
		fac.setFacFecha(new Date());
		fac.setFacNumero(1234);
		
		List<Detalle> listdet = new ArrayList<Detalle>();
		for (int i=1; i<4 ;i++) {
			Detalle det = new Detalle();
			det.setFactura(fac);
			det.setDetCantidad(i+10);
			fac.getDetalles().add(det);
		}
		
		facON.crear(fac);
		
		List<Factura> lisFac = new ArrayList<Factura>();
		lisFac= facON.read();
		for (Factura factura : lisFac) {
			response.getWriter().append("las facturas son: "+factura.getFacId()+ " Fact_num:  "+factura.getFacNumero()+"/n");
			for (Detalle detalle : factura.getDetalles()) {
				response.getWriter().append("");
				response.getWriter().append("los detalles son: "+detalle.getDetId()+ " Det Cantidad:  "+detalle.getDetCantidad()+"/n");
				
			}
		}
		
		Cliente cli= new Cliente();
		cli.setCliNombre("Juancho");
		cliON.crear(cli);
		*/
		
//		fac.setFacId(1);
//		fac.setFacFecha(new Date());
//		fac.setFacNumero(1235);
//		
//		facON.update(fac);
		
		
	}

//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}

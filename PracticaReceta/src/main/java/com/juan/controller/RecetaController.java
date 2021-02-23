package com.juan.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.juan.modelo.Medico;
import com.juan.modelo.Productos;
import com.juan.modelo.Receta;
import com.juan.modelo.RecetaDetalle;
import com.juan.negocio.MedicoON;
import com.juan.negocio.RecetaON;

@ManagedBean
@ViewScoped
public class RecetaController {
	
	@Inject
	private RecetaON recetaON;
	@Inject
	private MedicoON medicoON;
	
	private Receta newReceta;
	private List<Productos> lisP = new ArrayList<Productos>();
	private String filtro;
	private String filtromedico;
	private RecetaDetalle nRecetadetalle;
	private Medico newMedico;
	private List<Medico> lisM = new ArrayList<Medico>();
	
	
	@PostConstruct
	public void init() {
//		loadProductos();
		newReceta = new Receta();
		nRecetadetalle = new RecetaDetalle();
		newMedico = new Medico();
		lisP = new ArrayList<Productos>();
		lisM = new ArrayList<Medico>();
	}
	
	
	
	public Receta getNewReceta() {
		return newReceta;
	}

	public void setNewReceta(Receta newReceta) {
		this.newReceta = newReceta;
	}

	public List<Productos> getLisP() {
		return lisP;
	}

	public void setLisP(List<Productos> lisP) {
		this.lisP = lisP;
	}
	
	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
	
	public RecetaDetalle getnRecetadetalle() {
		return nRecetadetalle;
	}

	public void setnRecetadetalle(RecetaDetalle nRecetadetalle) {
		this.nRecetadetalle = nRecetadetalle;
	}
	
	public List<Medico> getLisM() {
		return lisM;
	}

	public void setLisM(List<Medico> lisM) {
		this.lisM = lisM;
	}

	public String getFiltromedico() {
		return filtromedico;
	}

	public void setFiltromedico(String filtromedico) {
		this.filtromedico = filtromedico;
	}
	
	public Medico getNewMedico() {
		return newMedico;
	}

	public void setNewMedico(Medico newMedico) {
		this.newMedico = newMedico;
	}
	
	
	/*----------------------------------------*/

	public String buscarProducto() {
		System.out.println("es el buscarProduc");
		lisP=recetaON.getProductos(filtro);
		return null;
	}
	
	public String buscarMedico() {
		System.out.println("medicooooo");
		lisM= medicoON.getMedicos(filtromedico);
		return null;
	}
	
	public String addDetalle(Productos p) {
		nRecetadetalle = new RecetaDetalle();
		nRecetadetalle.setProductos(p);
		newReceta.getLista().add(nRecetadetalle);
		System.out.println(p);
		return null;
	}
	
	public String guardarReceta() {
		recetaON.insertarReceta(newReceta);
		return null;
	}
	
	public String guardarMedico() {
		try {
			medicoON.insertarMedico(newMedico);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

//	public String loadProductos() {
//		lisP = recetaON.getProductos("Pa");
//		return null;
//	}
}

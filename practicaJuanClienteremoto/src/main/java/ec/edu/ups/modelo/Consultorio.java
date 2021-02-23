package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Consultorio implements Serializable {
	private static  final long serialVersionUID =1L;
	
	public Consultorio() {
	}
	
	private int id;
	private String numeroConsultorio;
	private int piso;
	private List<Medico> listaMedicos;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumeroConsultorio() {
		return numeroConsultorio;
	}
	public void setNumeroConsultorio(String numeroConsultorio) {
		this.numeroConsultorio = numeroConsultorio;
	}
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
	public List<Medico> getListaMedicos() {
		return listaMedicos;
	}
	public void setListaMedicos(List<Medico> listaMedicos) {
		this.listaMedicos = listaMedicos;
	}
	
}

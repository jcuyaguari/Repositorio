package com.juan.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Receta implements Serializable {
	private static  final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_receta")
	private int id_receta;
	private String codigo;
	private String nombreCliente;
	//mappedBy = "receta",
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_receta")
	private List<RecetaDetalle> lista  = new ArrayList<RecetaDetalle>();

	@ManyToOne
	@JoinColumn(name = "id_medico")
	private Medico medico;
	
	public int getId_receta() {
		return id_receta;
	}

	public void setId_receta(int id_receta) {
		this.id_receta = id_receta;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public List<RecetaDetalle> getLista() {
		return lista;
	}

	public void setLista(List<RecetaDetalle> lista) {
		this.lista = lista;
	}
	
	
}

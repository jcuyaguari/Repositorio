package com.juan.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Productos implements Serializable{
	private static  final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_producto")
	private int id_producto;
	private String nombre;
	
	
	@OneToMany( fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "id_producto")
	private List<RecetaDetalle> lista = new ArrayList<RecetaDetalle>();
	
	
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<RecetaDetalle> getLista() {
		return lista;
	}
	public void setLista(List<RecetaDetalle> lista) {
		this.lista = lista;
	}
	
	
}

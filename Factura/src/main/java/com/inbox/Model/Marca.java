package com.inbox.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the marca database table.
 * 
 */
@Entity
@NamedQuery(name="Marca.findAll", query="SELECT m FROM Marca m")
public class Marca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mar_id")
	private Integer marId;

	@Column(name="mar_codigo")
	private String marCodigo;

	@Column(name="mar_nombre")
	private String marNombre;

	@Column(name="mar_paisorigen")
	private String marPaisorigen;

	@Column(name="mar_web")
	private String marWeb;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="marca", fetch=FetchType.EAGER)
	private List<Producto> productos;

	public Marca() {
	}

	public Integer getMarId() {
		return this.marId;
	}

	public void setMarId(Integer marId) {
		this.marId = marId;
	}

	public String getMarCodigo() {
		return this.marCodigo;
	}

	public void setMarCodigo(String marCodigo) {
		this.marCodigo = marCodigo;
	}

	public String getMarNombre() {
		return this.marNombre;
	}

	public void setMarNombre(String marNombre) {
		this.marNombre = marNombre;
	}

	public String getMarPaisorigen() {
		return this.marPaisorigen;
	}

	public void setMarPaisorigen(String marPaisorigen) {
		this.marPaisorigen = marPaisorigen;
	}

	public String getMarWeb() {
		return this.marWeb;
	}

	public void setMarWeb(String marWeb) {
		this.marWeb = marWeb;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setMarca(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setMarca(null);

		return producto;
	}

}
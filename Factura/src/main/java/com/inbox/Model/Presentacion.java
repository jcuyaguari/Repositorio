package com.inbox.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the presentacion database table.
 * 
 */
@Entity
@NamedQuery(name="Presentacion.findAll", query="SELECT p FROM Presentacion p")
public class Presentacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pre_id")
	private Integer preId;

	@Column(name="pre_codigo")
	private String preCodigo;

	@Column(name="pre_descripcion")
	private String preDescripcion;

	@Column(name="pre_nombre")
	private String preNombre;

	//bi-directional many-to-one association to Producto
	@OneToMany(mappedBy="presentacion", fetch=FetchType.EAGER)
	private List<Producto> productos;

	public Presentacion() {
	}

	public Integer getPreId() {
		return this.preId;
	}

	public void setPreId(Integer preId) {
		this.preId = preId;
	}

	public String getPreCodigo() {
		return this.preCodigo;
	}

	public void setPreCodigo(String preCodigo) {
		this.preCodigo = preCodigo;
	}

	public String getPreDescripcion() {
		return this.preDescripcion;
	}

	public void setPreDescripcion(String preDescripcion) {
		this.preDescripcion = preDescripcion;
	}

	public String getPreNombre() {
		return this.preNombre;
	}

	public void setPreNombre(String preNombre) {
		this.preNombre = preNombre;
	}

	public List<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto addProducto(Producto producto) {
		getProductos().add(producto);
		producto.setPresentacion(this);

		return producto;
	}

	public Producto removeProducto(Producto producto) {
		getProductos().remove(producto);
		producto.setPresentacion(null);

		return producto;
	}

}
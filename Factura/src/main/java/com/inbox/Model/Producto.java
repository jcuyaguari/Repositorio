package com.inbox.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pro_id")
	private Integer proId;

	@Column(name="pro_codigo")
	private String proCodigo;

	@Column(name="pro_color")
	private String proColor;

	@Column(name="pro_descripcion")
	private String proDescripcion;

	@Column(name="pro_foto")
	private byte[] proFoto;

	@Column(name="pro_iva")
	private double proIva;

	@Column(name="pro_modelo")
	private String proModelo;

	@Column(name="pro_nombre")
	private String proNombre;

	@Column(name="pro_peso")
	private double proPeso;

	@Column(name="pro_preciounit")
	private double proPreciounit;

	@Column(name="pro_stock")
	private Integer proStock;

	@Column(name="pro_talla")
	private String proTalla;

	@Column(name="pro_ubicacion")
	private String proUbicacion;

	@Column(name="pro_unidad")
	private String proUnidad;

	//bi-directional many-to-one association to Detalle
	@OneToMany(mappedBy="producto", fetch=FetchType.EAGER)
	private List<Detalle> detalles;

	//bi-directional many-to-one association to Marca
	@ManyToOne
	@JoinColumn(name="mar_id_fk")
	private Marca marca;

	//bi-directional many-to-one association to Presentacion
	@ManyToOne
	@JoinColumn(name="pre_id_fk")
	private Presentacion presentacion;

	public Producto() {
	}

	public Integer getProId() {
		return this.proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public String getProCodigo() {
		return this.proCodigo;
	}

	public void setProCodigo(String proCodigo) {
		this.proCodigo = proCodigo;
	}

	public String getProColor() {
		return this.proColor;
	}

	public void setProColor(String proColor) {
		this.proColor = proColor;
	}

	public String getProDescripcion() {
		return this.proDescripcion;
	}

	public void setProDescripcion(String proDescripcion) {
		this.proDescripcion = proDescripcion;
	}

	public byte[] getProFoto() {
		return this.proFoto;
	}

	public void setProFoto(byte[] proFoto) {
		this.proFoto = proFoto;
	}

	public double getProIva() {
		return this.proIva;
	}

	public void setProIva(double proIva) {
		this.proIva = proIva;
	}

	public String getProModelo() {
		return this.proModelo;
	}

	public void setProModelo(String proModelo) {
		this.proModelo = proModelo;
	}

	public String getProNombre() {
		return this.proNombre;
	}

	public void setProNombre(String proNombre) {
		this.proNombre = proNombre;
	}

	public double getProPeso() {
		return this.proPeso;
	}

	public void setProPeso(double proPeso) {
		this.proPeso = proPeso;
	}

	public double getProPreciounit() {
		return this.proPreciounit;
	}

	public void setProPreciounit(double proPreciounit) {
		this.proPreciounit = proPreciounit;
	}

	public Integer getProStock() {
		return this.proStock;
	}

	public void setProStock(Integer proStock) {
		this.proStock = proStock;
	}

	public String getProTalla() {
		return this.proTalla;
	}

	public void setProTalla(String proTalla) {
		this.proTalla = proTalla;
	}

	public String getProUbicacion() {
		return this.proUbicacion;
	}

	public void setProUbicacion(String proUbicacion) {
		this.proUbicacion = proUbicacion;
	}

	public String getProUnidad() {
		return this.proUnidad;
	}

	public void setProUnidad(String proUnidad) {
		this.proUnidad = proUnidad;
	}

	public List<Detalle> getDetalles() {
		return this.detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}

	public Detalle addDetalle(Detalle detalle) {
		getDetalles().add(detalle);
		detalle.setProducto(this);

		return detalle;
	}

	public Detalle removeDetalle(Detalle detalle) {
		getDetalles().remove(detalle);
		detalle.setProducto(null);

		return detalle;
	}

	public Marca getMarca() {
		return this.marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Presentacion getPresentacion() {
		return this.presentacion;
	}

	public void setPresentacion(Presentacion presentacion) {
		this.presentacion = presentacion;
	}

}
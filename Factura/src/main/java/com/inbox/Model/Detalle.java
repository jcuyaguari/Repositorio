package com.inbox.Model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalle database table.
 * 
 */
@Entity
@NamedQuery(name="Detalle.findAll", query="SELECT d FROM Detalle d")
public class Detalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="det_id")
	private Integer detId;

	@Column(name="det_cantidad")
	private Integer detCantidad;

	@Column(name="det_valtotal")
	private double detValtotal;

	@Column(name="det_valunidad")
	private double detValunidad;

	//bi-directional many-to-one association to Factura
	@ManyToOne
	@JoinColumn(name="fac_id_fk")
	private Factura factura;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="pro_id_fk")
	private Producto producto;

	public Detalle() {
	}

	public Integer getDetId() {
		return this.detId;
	}

	public void setDetId(Integer detId) {
		this.detId = detId;
	}

	public Integer getDetCantidad() {
		return this.detCantidad;
	}

	public void setDetCantidad(Integer detCantidad) {
		this.detCantidad = detCantidad;
	}

	public double getDetValtotal() {
		return this.detValtotal;
	}

	public void setDetValtotal(double detValtotal) {
		this.detValtotal = detValtotal;
	}

	public double getDetValunidad() {
		return this.detValunidad;
	}

	public void setDetValunidad(double detValunidad) {
		this.detValunidad = detValunidad;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
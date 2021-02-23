package com.jonathan.modelo;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_venta", catalog = "bd_venta")
public class DetalleVenta implements java.io.Serializable {

	private static final long serialVersionUID = 2121267698705677871L;
	
	private int dvId;
	private Producto producto;
	private Venta venta;
	private int dvCantidad;
	private double dvPrecioart;
	private double dvTotal;

	public DetalleVenta() {
	}

	public DetalleVenta(Producto producto, Venta venta) {
		this.producto = producto;
		this.venta = venta;
	}

	public DetalleVenta(Producto producto, Venta venta, int dvCantidad,
			double dvPrecioart, double dvTotal) {
		this.producto = producto;
		this.venta = venta;
		this.dvCantidad = dvCantidad;
		this.dvPrecioart = dvPrecioart;
		this.dvTotal = dvTotal;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "dv_id", unique = true, nullable = false)
	public int getDvId() {
		return this.dvId;
	}

	public void setDvId(int dvId) {
		this.dvId = dvId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dv_producto", nullable = false)
	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dv_venta", nullable = false)
	public Venta getVenta() {
		return this.venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	@Column(name = "dv_cantidad")
	public int getDvCantidad() {
		return this.dvCantidad;
	}

	public void setDvCantidad(int dvCantidad) {
		this.dvCantidad = dvCantidad;
	}

	@Column(name = "dv_precioart", precision = 8)
	public double getDvPrecioart() {
		return this.dvPrecioart;
	}

	public void setDvPrecioart(double dvPrecioart) {
		this.dvPrecioart = dvPrecioart;
	}

	@Column(name = "dv_total", precision = 8)
	public double getDvTotal() {
		return (dvCantidad * dvPrecioart);
	}

	public void setDvTotal(double dvTotal) {
		this.dvTotal = dvTotal;
	}

}

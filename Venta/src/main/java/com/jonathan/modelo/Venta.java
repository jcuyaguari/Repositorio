package com.jonathan.modelo;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "venta", catalog = "bd_venta")
public class Venta implements java.io.Serializable {

	private static final long serialVersionUID = 8622868830366439057L;
	
	private Integer venId;
	private Usuarios usuarios;
	private Date venFecha;
	private double venMonto;
	private List<DetalleVenta> detalleVentas = new ArrayList<DetalleVenta>(0);

	public Venta() {
	}

	public Venta(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	public Venta(Usuarios usuarios, Date venFecha, double venMonto,
			List<DetalleVenta> detalleVentas) {
		this.usuarios = usuarios;
		this.venFecha = venFecha;
		this.venMonto = venMonto;
		this.detalleVentas = detalleVentas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ven_id", unique = true, nullable = false)
	public Integer getVenId() {
		return this.venId;
	}

	public void setVenId(Integer venId) {
		this.venId = venId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ven_usuario", nullable = false)
	public Usuarios getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ven_fecha", length = 19)
	public Date getVenFecha() {
		return this.venFecha;
	}

	public void setVenFecha(Date venFecha) {
		this.venFecha = venFecha;
	}

	@Column(name = "ven_monto", precision = 8)
	public double getVenMonto() {
		return this.venMonto;
	}

	public void setVenMonto(double venMonto) {
		this.venMonto = venMonto;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "venta", cascade=CascadeType.ALL)
	public List<DetalleVenta> getDetalleVentas() {
		return this.detalleVentas;
	}

	public void setDetalleVentas(List<DetalleVenta> detalleVentas) {
		this.detalleVentas = detalleVentas;
	}

}

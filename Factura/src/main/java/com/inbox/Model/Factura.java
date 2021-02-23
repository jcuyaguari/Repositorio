package com.inbox.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the factura database table.
 * 
 */
@Entity
@NamedQuery(name="Factura.findAll", query="SELECT f FROM Factura f")
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fac_id")
	private Integer facId;

	@Column(name="fac_estado")
	private String facEstado;

	@Temporal(TemporalType.DATE)
	@Column(name="fac_fecha")
	private Date facFecha;

	@Column(name="fac_iva")
	private double facIva;

	@Column(name="fac_numero")
	private Integer facNumero;

	@Column(name="fac_pordescuento")
	private Integer facPordescuento;

	@Column(name="fac_subtotal")
	private double facSubtotal;

	@Column(name="fac_total")
	private double facTotal;

	@Column(name="fac_valdescuento")
	private double facValdescuento;

	//bi-directional many-to-one association to Detalle
	@OneToMany(mappedBy="factura", fetch=FetchType.EAGER)
	private List<Detalle> detalles;

	//bi-directional many-to-one association to Empresa
	@ManyToOne
	@JoinColumn(name="emp_id_fk")
	private Empresa empresa;

	//bi-directional many-to-one association to Usuariosistema
	@ManyToOne
	@JoinColumn(name="user_id_fk")
	private Usuariosistema usuariosistema;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="per_id_fk")
	private Persona persona;

	public Factura() {
	}

	public Integer getFacId() {
		return this.facId;
	}

	public void setFacId(Integer facId) {
		this.facId = facId;
	}

	public String getFacEstado() {
		return this.facEstado;
	}

	public void setFacEstado(String facEstado) {
		this.facEstado = facEstado;
	}

	public Date getFacFecha() {
		return this.facFecha;
	}

	public void setFacFecha(Date facFecha) {
		this.facFecha = facFecha;
	}

	public double getFacIva() {
		return this.facIva;
	}

	public void setFacIva(double facIva) {
		this.facIva = facIva;
	}

	public Integer getFacNumero() {
		return this.facNumero;
	}

	public void setFacNumero(Integer facNumero) {
		this.facNumero = facNumero;
	}

	public Integer getFacPordescuento() {
		return this.facPordescuento;
	}

	public void setFacPordescuento(Integer facPordescuento) {
		this.facPordescuento = facPordescuento;
	}

	public double getFacSubtotal() {
		return this.facSubtotal;
	}

	public void setFacSubtotal(double facSubtotal) {
		this.facSubtotal = facSubtotal;
	}

	public double getFacTotal() {
		return this.facTotal;
	}

	public void setFacTotal(double facTotal) {
		this.facTotal = facTotal;
	}

	public double getFacValdescuento() {
		return this.facValdescuento;
	}

	public void setFacValdescuento(double facValdescuento) {
		this.facValdescuento = facValdescuento;
	}

	public List<Detalle> getDetalles() {
		return this.detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}

	public Detalle addDetalle(Detalle detalle) {
		getDetalles().add(detalle);
		detalle.setFactura(this);

		return detalle;
	}

	public Detalle removeDetalle(Detalle detalle) {
		getDetalles().remove(detalle);
		detalle.setFactura(null);

		return detalle;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Usuariosistema getUsuariosistema() {
		return this.usuariosistema;
	}

	public void setUsuariosistema(Usuariosistema usuariosistema) {
		this.usuariosistema = usuariosistema;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
package com.inbox.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="per_id")
	private Integer perId;

	@Column(name="per_apellido")
	private String perApellido;

	@Column(name="per_cedula")
	private String perCedula;

	@Column(name="per_celular")
	private String perCelular;

	@Column(name="per_direccion")
	private String perDireccion;

	@Column(name="per_email")
	private String perEmail;

	@Temporal(TemporalType.DATE)
	@Column(name="per_fechnac")
	private Date perFechnac;

	@Column(name="per_genero")
	private String perGenero;

	@Column(name="per_nombre")
	private String perNombre;

	@Column(name="per_ruc")
	private String perRuc;

	@Column(name="per_telefono")
	private String perTelefono;

	@Column(name="per_tipo")
	private String perTipo;

	@Column(name="per_tipodoc")
	private String perTipodoc;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="persona", fetch=FetchType.EAGER)
	private List<Factura> facturas;

	public Persona() {
	}

	public Integer getPerId() {
		return this.perId;
	}

	public void setPerId(Integer perId) {
		this.perId = perId;
	}

	public String getPerApellido() {
		return this.perApellido;
	}

	public void setPerApellido(String perApellido) {
		this.perApellido = perApellido;
	}

	public String getPerCedula() {
		return this.perCedula;
	}

	public void setPerCedula(String perCedula) {
		this.perCedula = perCedula;
	}

	public String getPerCelular() {
		return this.perCelular;
	}

	public void setPerCelular(String perCelular) {
		this.perCelular = perCelular;
	}

	public String getPerDireccion() {
		return this.perDireccion;
	}

	public void setPerDireccion(String perDireccion) {
		this.perDireccion = perDireccion;
	}

	public String getPerEmail() {
		return this.perEmail;
	}

	public void setPerEmail(String perEmail) {
		this.perEmail = perEmail;
	}

	public Date getPerFechnac() {
		return this.perFechnac;
	}

	public void setPerFechnac(Date perFechnac) {
		this.perFechnac = perFechnac;
	}

	public String getPerGenero() {
		return this.perGenero;
	}

	public void setPerGenero(String perGenero) {
		this.perGenero = perGenero;
	}

	public String getPerNombre() {
		return this.perNombre;
	}

	public void setPerNombre(String perNombre) {
		this.perNombre = perNombre;
	}

	public String getPerRuc() {
		return this.perRuc;
	}

	public void setPerRuc(String perRuc) {
		this.perRuc = perRuc;
	}

	public String getPerTelefono() {
		return this.perTelefono;
	}

	public void setPerTelefono(String perTelefono) {
		this.perTelefono = perTelefono;
	}

	public String getPerTipo() {
		return this.perTipo;
	}

	public void setPerTipo(String perTipo) {
		this.perTipo = perTipo;
	}

	public String getPerTipodoc() {
		return this.perTipodoc;
	}

	public void setPerTipodoc(String perTipodoc) {
		this.perTipodoc = perTipodoc;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura addFactura(Factura factura) {
		getFacturas().add(factura);
		factura.setPersona(this);

		return factura;
	}

	public Factura removeFactura(Factura factura) {
		getFacturas().remove(factura);
		factura.setPersona(null);

		return factura;
	}

}
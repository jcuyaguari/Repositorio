package com.inbox.Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
@NamedQuery(name="Empresa.findAll", query="SELECT e FROM Empresa e")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_id")
	private Integer empId;

	@Column(name="emp_direccion")
	private String empDireccion;

	@Column(name="emp_email")
	private String empEmail;

	@Column(name="emp_ruc")
	private String empRuc;

	@Column(name="emp_sucursal")
	private String empSucursal;

	@Column(name="emp_telefono")
	private String empTelefono;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="empresa", fetch=FetchType.EAGER)
	private List<Factura> facturas;

	public Empresa() {
	}

	public Integer getEmpId() {
		return this.empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpDireccion() {
		return this.empDireccion;
	}

	public void setEmpDireccion(String empDireccion) {
		this.empDireccion = empDireccion;
	}

	public String getEmpEmail() {
		return this.empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpRuc() {
		return this.empRuc;
	}

	public void setEmpRuc(String empRuc) {
		this.empRuc = empRuc;
	}

	public String getEmpSucursal() {
		return this.empSucursal;
	}

	public void setEmpSucursal(String empSucursal) {
		this.empSucursal = empSucursal;
	}

	public String getEmpTelefono() {
		return this.empTelefono;
	}

	public void setEmpTelefono(String empTelefono) {
		this.empTelefono = empTelefono;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura addFactura(Factura factura) {
		getFacturas().add(factura);
		factura.setEmpresa(this);

		return factura;
	}

	public Factura removeFactura(Factura factura) {
		getFacturas().remove(factura);
		factura.setEmpresa(null);

		return factura;
	}

}
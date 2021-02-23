package ec.edu.ups.Server;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cajera implements Serializable {
	
	@Id
	private int id;
	private int cuenta;
	private String celular;
	private double recarga;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCuenta() {
		return cuenta;
	}
	public void setCuenta(int cuenta) {
		this.cuenta = cuenta;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public double getRecarga() {
		return recarga;
	}
	public void setRecarga(double recarga) {
		this.recarga = recarga;
	}
	
	
	
	
	

}

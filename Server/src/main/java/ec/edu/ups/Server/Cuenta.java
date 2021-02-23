package ec.edu.ups.Server;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cuenta implements Serializable{
	
	@Id
	private int id;
	private int cuentanumero;
	private int saldo;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCuentanumero() {
		return cuentanumero;
	}
	public void setCuentanumero(int cuentanumero) {
		this.cuentanumero = cuentanumero;
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
	

}

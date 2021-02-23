package ec.udu.ups.appdis.agenda.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Telefono implements Serializable{
	private static  final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_telefono")
	private int id;
    private String numeros;
    private String tipo;
    private int fk_persona;
    
    
    //@ManyToOne
    //@JoinColumn(name="id_persona")
    private Persona persona;

    public Telefono() {
    }

    
    public Telefono(int id, String numeros, String tipo, int fk_persona) {
        this.id = id;
        this.numeros = numeros;
        this.tipo = tipo;
        this.fk_persona = fk_persona;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeros() {
        return numeros;
    }

    public void setNumeros(String numeros) {
        this.numeros = numeros;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getFk_persona() {
        return fk_persona;
    }

    public void setFk_persona(int fk_persona) {
        this.fk_persona = fk_persona;
    }


	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}
    
    
}

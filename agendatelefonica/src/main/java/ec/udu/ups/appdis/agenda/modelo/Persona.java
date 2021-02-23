package ec.udu.ups.appdis.agenda.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Persona implements Serializable{
    private static  final long serialVersionUID =1L;
	
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Access(AccessType.PROPERTY)
	@Column(name="id_persona", updatable=false,insertable=false)
	private int id;
    private String cedula;
    private String nombre;
    
   //mappedBy = "persona",
    @OneToMany( fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="id_persona")
    private List<Telefono> listaTelefonos = new ArrayList<Telefono>();

    public Persona() {
    }

    public Persona(int id, String cedula, String nombre, List<Telefono> listaTelefonos) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.listaTelefonos = listaTelefonos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

	public List<Telefono> getListaTelefonos() {
		return listaTelefonos;
	}

	public void setListaTelefonos(List<Telefono> listaTelefonos) {
		this.listaTelefonos = listaTelefonos;
	}

//    public  void addTelefono(Telefono telefono) {
//    	if (listaTelefonos == null) 
//			listaTelefonos = new ArrayList<Telefono>();
//		listaTelefonos.add(telefono);
//    	
//    }

      
}

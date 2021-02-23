package ec.edu.ups.negocios;

import javax.ejb.Remote;

import ec.edu.ups.modelo.Consultorio;
import ec.edu.ups.modelo.Medico;

@Remote
public interface HospitalOnRemoto {

	public void guardarHospital(Consultorio c);
}

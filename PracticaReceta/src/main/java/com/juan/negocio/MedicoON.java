package com.juan.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.juan.datos.MedicoDAO;
import com.juan.modelo.Medico;

@Stateless
public class MedicoON {
	
	@Inject
	private MedicoDAO medicoDAO;
	
	public void insertarMedico(Medico medico) throws Exception {
		try {
			medicoDAO.insertarMedico(medico);
		} catch (Exception e) {
			throw new Exception("Error al insert medico");
		}
		
	}
	
	public List<Medico> getMedicos(String filtro){
		medicoDAO.getMedicos(filtro);
		return null;
	}
}

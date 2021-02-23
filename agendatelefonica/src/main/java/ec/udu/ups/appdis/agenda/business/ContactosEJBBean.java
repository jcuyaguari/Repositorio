package ec.udu.ups.appdis.agenda.business;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.udu.ups.appdis.agenda.datos.PersonaDAO;
import ec.udu.ups.appdis.agenda.datos.TelfDAO;
import ec.udu.ups.appdis.agenda.modelo.Persona;
import ec.udu.ups.appdis.agenda.modelo.Telefono;

@Stateless
public class ContactosEJBBean implements ContactoEJBBeanLocal, ContactoEJBBeanRemoto {

	@Inject
	PersonaDAO pd;

	@Inject
	TelfDAO td;

	public ContactosEJBBean() {
		// pd = new PersonaDAO();
		// td = new TelfDAO();
	}

	public void insertContacto(Persona persona) {
		
//Inserta varios detalles List<Telefono> telefonos
//		try {
//			for (Telefono telf : telefonos) {
//				td.insertar(telf);
//				System.out.println("llega: "+telf.getNumeros());
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
		try {
			pd.insertar(persona);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void actualizarContacto(List<Telefono> t) {
		try {
			for (Telefono telefono : t) {
				td.update(telefono);
			}
			
		} catch (Exception ex) {
			Logger.getLogger(ContactosEJBBean.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
			// throw new Exception("No se puede Actualizar contacto");
		}

	}
	
	public Persona listarContactos(Persona p) {
		Persona aux=null;
		try {
			aux=pd.read(p.getId());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aux;
	}
	
//	 public List<Persona> getPersonas(String filtro) {
//		return pd.getPersonas(filtro);
//		
//		
//	}
	 public List<Persona> getPersonasAll() {
			return pd.getPersonasAll();
						
	}
	 
	public void eliminar(List<Telefono> telefonos) {
		
		try {
			//pd.eliminar(p.getId());
			for (Telefono telf : telefonos) {
				td.delete(telf);
			}
		//	System.out.println("id  que llega ---->>>>" +p.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//Se utiliza ahora
	public void removeContacto(Persona per) {
		pd.removeContacto(per);
	}
	

//	public void guardarContacto(Persona p, ArrayList<Telefono> t) throws Exception  {
//
////	        if (validarCedula(p.getCedula())==true) {
//		
//			pd.insertar(p);
//			//td.insertar(t, p);
//		
////	             } else {
////	            throw new Exception("Error cedula Incorrecta");
////	        }
//
//	}

	

//	public ArrayList<Telefono> listarTelefonos(Persona p) { // throws Exception{
//		ArrayList<Telefono> listatel = null;
//		try {
//			listatel = pd.listartelefonos(p);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return listatel;
//	}

	
//	public void actualizarTelefono(Telefono t) {
//		try {
//			td.update(t);
//		} catch (Exception ex) {
//			Logger.getLogger(ContactosEJBBean.class.getName()).log(Level.SEVERE, null, ex);
//		}
//	}
	/**
	public void eliminarContacto(Persona p) { // throws Exception{
		try {
			pd.eliminar(p);
		} catch (Exception ex) {
			Logger.getLogger(ContactosEJBBean.class.getName()).log(Level.SEVERE, null, ex);
			// throw new Exception("ERROR ELIMINANDO");
		}

	}
**/
	public boolean validarCedula(String c) {
		boolean bandera = false;
		try {
			int numero = Integer.parseInt(c);
		} catch (Exception e) {
			bandera = false;
		}
		if (c.length() == 10) {
			int tercerDigito = Integer.parseInt(c.substring(2, 3));
			if (tercerDigito < 6) {
				// Coeficientes de validación cédula
				// El decimo digito es digito verificador
				int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
				int verificador = Integer.parseInt(c.substring(9, 10));
				int suma = 0;
				int digito = 0;
				for (int i = 0; i < (c.length() - 1); i++) {
					digito = Integer.parseInt(c.substring(i, i + 1)) * coefValCedula[i];
					suma += ((digito % 10) + (digito / 10));
				}
				if (suma != 0) {

					if ((suma % 10 == 0) && (suma % 10 == verificador)) {
						bandera = true;
					} else if ((10 - (suma % 10)) == verificador) {
						bandera = true;
					} else {
						bandera = false;
					}
				} else {
					bandera = false;
				}
			} else {
				bandera = false;
			}

		} else {
			bandera = false;
		}
		return bandera;
	}


}

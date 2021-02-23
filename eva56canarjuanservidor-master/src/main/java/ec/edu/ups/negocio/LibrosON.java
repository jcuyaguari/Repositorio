package ec.edu.ups.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.datos.AutorDAO;
import ec.edu.ups.datos.DetalleLibroDAO;
import ec.edu.ups.modelo.Autor;
import ec.edu.ups.modelo.Detalle;
import ec.edu.ups.modelo.Libro;

@Stateless
public class LibrosON implements LibrosONLocal,LibrosONRemoto{

	@Inject
	DetalleLibroDAO detallelibrodao;
	@Inject
	AutorDAO autordao;
	
	public void guardarLibro(List<Detalle> detalleLibro) {
		for (Detalle det: detalleLibro) {
			detallelibrodao.insertar(det);
		}
	}
	
	public List<Libro> getDetalles(String codigo) {
		return detallelibrodao.getDetalles(codigo);
	}

    public List<Autor> getAutoresAll() {
    	return autordao.getAutoresAll();
    }
	
	
}

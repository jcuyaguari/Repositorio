package test;

import static org.junit.Assert.*;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com.jonathan.modelo.Producto;
import com.jonathan.modelo.Usuarios;
import com.jonathan.service.LoginService;
import com.jonathan.service.ProductoService;
import com.jonathan.serviceImpl.LoginServiceImpl;
import com.jonathan.serviceImpl.ProductoServiceImpl;
import com.jonathan.util.HibernateUtil;

public class Prueba {

	// @Test
	public void test() {
		List<Producto> productos = null;
		ProductoService productoService = new ProductoServiceImpl();
		productos = productoService.findAll();
		for (Producto producto : productos) {
			System.out.println("Producto : " + producto.getProdNombre());
		}
	}
	
	public static double redondear(double numero)
    {
        return Math.rint(numero*100)/100;
    }
	
	@Test
	public void dar(){
		double numer =  24.65434534;
		double nume2 = redondear(numer);
		System.out.println(nume2);
		
	}
	
}

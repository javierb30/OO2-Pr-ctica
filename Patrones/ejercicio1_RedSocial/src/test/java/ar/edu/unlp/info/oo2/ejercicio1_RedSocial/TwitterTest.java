package ar.edu.unlp.info.oo2.ejercicio1_RedSocial;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TwitterTest {
	Twitter app;
	Usuario a1,a2;
	
	@BeforeEach
	void setUp() {
		app = new Twitter();
		a2 = new Usuario("juansito");
		app.crearUsuario("javier00");
		
	}
	
	@Test
	public void testCrearUsuario() {
		assertNotNull(app.crearUsuario("javier01"));
		assertNull(app.crearUsuario("javier01"));
		assertNotNull(app.crearUsuario("javier02"));
	}
	
	@Test
	public void testEliminarUsuario() {
		assertEquals(1,app.cantidadUsuarios());
		app.agregarUsuario(a2);
		assertEquals(2,app.cantidadUsuarios());
		app.eliminarUsuario(a2);
		assertEquals(1,app.cantidadUsuarios());
	}
}

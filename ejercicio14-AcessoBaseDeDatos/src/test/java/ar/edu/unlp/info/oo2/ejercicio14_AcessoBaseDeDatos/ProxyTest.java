package ar.edu.unlp.info.oo2.ejercicio14_AcessoBaseDeDatos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProxyTest {
	 private DatabaseRealAccess database;
	 private Proxy proxy;

	    @BeforeEach
	    void setUp() throws Exception {
	        this.database = new DatabaseRealAccess();
	        this.proxy = new Proxy(database,"javier");
	    }

	    @Test
	    void testIniciarSesion() {
	    	RuntimeException excepcion = assertThrows(RuntimeException.class,  () -> {
				proxy.iniciarSesion("juansito");
				});
			
			String expectedMessage = "Acceso denegado. Contraseña inválida.";
			String actualMessage = excepcion.getMessage();
			
			assertTrue(actualMessage.contains(expectedMessage));
			//Opcion 2
			assertEquals(excepcion.getMessage(), "Acceso denegado. Contraseña inválida.");
			
			//Inicio sesión
			this.proxy.iniciarSesion("javier");
			assertTrue(this.proxy.getSesionIniciada());
			
			RuntimeException excepcion2 = assertThrows(RuntimeException.class,  () -> {
				proxy.iniciarSesion("juansito");
				});
			
			String expectedMessage2 = "Ya se encuentra la sesión iniciada.";
			String actualMessage2 = excepcion2.getMessage();
			assertTrue(actualMessage2.contains(expectedMessage2));
			//Opcion 2
			assertEquals(excepcion2.getMessage(), "Ya se encuentra la sesión iniciada.");
			
	    }
	    
	    @Test
	    void testCerrarSesion() {
	    	RuntimeException excepcion = assertThrows(RuntimeException.class,  () -> {
				proxy.cerrarSesion();
				});
			
			String expectedMessage = "No se encuentra logueado. Debe iniciar sesión.";
			String actualMessage = excepcion.getMessage();
			
			assertTrue(actualMessage.contains(expectedMessage));
			
			//Inicio y cierre
			this.proxy.iniciarSesion("javier");
			assertTrue(this.proxy.getSesionIniciada());
			this.proxy.cerrarSesion();
			assertTrue(!this.proxy.getSesionIniciada());
	    }
	    
	    @Test
	    void testGetSearchResults() {
	    	RuntimeException excepcion = assertThrows(RuntimeException.class,  () -> {
				proxy.getSearchResults("select * from comics where id=1");
				});
			
			String expectedMessage = "Acceso denegado";
			String actualMessage = excepcion.getMessage();
			
			assertTrue(actualMessage.contains(expectedMessage));
	    
	        //inicia sesion
			this.proxy.iniciarSesion("javier");
	        assertEquals(Arrays.asList("Spiderman", "Marvel"), this.proxy.getSearchResults("select * from comics where id=1"));
	        assertEquals(Collections.emptyList(), this.proxy.getSearchResults("select * from comics where id=10"));
		}
	    
	    @Test
	    void testInsertNewRow() {
	    	RuntimeException excepcion = assertThrows(RuntimeException.class,  () -> {
				proxy.getSearchResults("select * from comics where id=1");
				});
			
			String expectedMessage = "Acceso denegado";
			String actualMessage = excepcion.getMessage();
			
			assertTrue(actualMessage.contains(expectedMessage));
	    
	        //inicia sesion
			this.proxy.iniciarSesion("javier");
	    	
	        assertEquals(3, this.database.insertNewRow(Arrays.asList("Patoruzú", "La flor")));
	        assertEquals(Arrays.asList("Patoruzú", "La flor"), this.database.getSearchResults("select * from comics where id=3"));
	    }
}

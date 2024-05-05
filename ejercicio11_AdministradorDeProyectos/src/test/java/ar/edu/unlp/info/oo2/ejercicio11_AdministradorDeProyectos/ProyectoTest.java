package ar.edu.unlp.info.oo2.ejercicio11_AdministradorDeProyectos;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class ProyectoTest {
	private Proyecto proyecto,proyecto2;
		
		@BeforeEach
		void setUp() {
			proyecto = new Proyecto(
					"Vacaciones de invierno",
					LocalDate.of(2024, 4, 26),
					LocalDate.of(2024, 4, 29),
					"Salir con amigos",
					3,
					1000);
			proyecto2 = new Proyecto(
					"Vacaciones de invierno fake",
					LocalDate.of(2024, 4, 26),
					LocalDate.of(2024, 4, 29),
					"Salir con amigos",
					2,
					0
					);
		}
		//Debo pasar el metodo a privado para probarlo
		/*
		@Test
		void testDuracionTotal() {
			assertEquals(3,proyecto.duracionTotal());
		}*/
		
		@Test
		void testCalcularCostoDelProyecto() {
			assertEquals(9000, proyecto.calcularCostoDelProyecto());
			assertEquals(0, proyecto2.calcularCostoDelProyecto());
		}
		
		@Test
		void testCalcularPrecioDelProyecto() {
			assertEquals(9630, proyecto.calcularPrecioDelProyecto());
		}
		
		@Test
		void testAprobarEtapa() {
			assertTrue(proyecto.getEstado() instanceof Construccion);
			
			proyecto.aprobarEtapa();
			
			assertTrue(proyecto.getEstado() instanceof Evaluacion);
			
			proyecto.aprobarEtapa();
			assertTrue(proyecto.getEstado() instanceof Confirmacion);
			
			try {
				proyecto2.aprobarEtapa();
			} catch (Exception e){
				assertEquals(e.getMessage(), "El precio del proyecto no es mayor a cero.");
			}
			assertThrows(null, null) //--> Para manejar la excepciòn
		}
		
		@Test
		void testCancelarProyecto() {
			proyecto.cancelarProyecto();
			assertTrue(proyecto.getEstado() instanceof Cancelacion);
			assertEquals("Salir con amigos (Cancelado)", proyecto.getObjetivo());
			
			}
	
}

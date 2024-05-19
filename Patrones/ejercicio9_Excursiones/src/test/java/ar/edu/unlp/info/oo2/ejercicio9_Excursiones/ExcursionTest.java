package ar.edu.unlp.info.oo2.ejercicio9_Excursiones;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExcursionTest {
	private Excursion excursionProvisorio;
	private Excursion excursionDefinitivo;
	private Excursion excursionCompleta;
	private Usuario user1;
	private Usuario user2;
	private Usuario user3;
	private Usuario user4;
	private Usuario user5;

	@BeforeEach
	void setUp() throws Exception {
		excursionProvisorio = new Excursion("excursion 1",
				LocalDate.of(2024, 4, 1),
				LocalDate.of(2024, 4, 3),
				"Puerto Iguazu",
				100.0, 
				1, 
				2);
		excursionDefinitivo = new Excursion("excursion 2",
				LocalDate.of(2024, 4, 2),
				LocalDate.of(2024, 4, 16),
				"Glaciar Perito Moreno",
				200.0, 
				1, 
				5);
		excursionCompleta = new Excursion("excursion 3",
				LocalDate.of(2024, 4, 3),
				LocalDate.of(2024, 4, 17),
				"Isla Paulina",
				300.0, 
				1, 
				5);
		user1 = new Usuario("luis", "perez", "perez@gmail.com");
		user2 = new Usuario("jorge", "rosas", "rosas@gmail.com");
		user3 = new Usuario("juan", "rodriguez", "rodriguez@gmail.com");
		user4 = new Usuario("roberto", "martinez", "martinez@gmail.com");
		user5 = new Usuario("edgar", "ruiz", "ruiz@gmail.com");
		
		excursionDefinitivo.inscribirUsuario(user1);
		excursionDefinitivo.inscribirUsuario(user2);
		excursionDefinitivo.inscribirUsuario(user3);
		excursionDefinitivo.inscribirUsuario(user4);
		
		excursionCompleta.inscribirUsuario(user1);
		excursionCompleta.inscribirUsuario(user2);
		excursionCompleta.inscribirUsuario(user3);
		excursionCompleta.inscribirUsuario(user4);
		excursionCompleta.inscribirUsuario(user5);
	}

	@Test
	void testExcursionProvisorioObtenerInformacion() {
		String cadena = "Nombre: excursion 1\n" +
                "Costo: 100.0\n" +
                "Fecha de Inicio: 2024-04-01\n" +
                "Fecha de Fin: 2024-04-03\n" +
                "Punto de Encuentro: Puerto Iguazu\n" +
                "Cantidad de usuarios faltantes para alcanzar el cupo minimo: 1";
		System.out.println(excursionProvisorio.informacion());
		assertEquals(cadena, excursionProvisorio.informacion());
	}
	
	@Test
	void testExcursionProvisorioInscribir() {
		assertTrue(excursionProvisorio.getEstado() instanceof CupoIncompleto);
		excursionProvisorio.inscribirUsuario(user1);
		assertFalse(excursionProvisorio.getEstado() instanceof CupoIncompleto);
		assertTrue(excursionProvisorio.getEstado() instanceof CupoMinimo);
		
		excursionProvisorio.inscribirUsuario(user2);
		assertTrue(excursionProvisorio.getEstado() instanceof CupoMaximo);
	}
	
	@Test
	void testExcursionDefinitivoObtenerInformacion() {
		String cadena = "Nombre: excursion 2\n" +
                "Costo: 200.0\n" +
                "Fecha de Inicio: 2024-04-02\n" +
                "Fecha de Fin: 2024-04-16\n" +
                "Punto de Encuentro: Glaciar Perito Moreno\n" +
                "Cantidad de usuarios faltantes para alcanzar el cupo maximo: 1\n" +
                "Mails de los Usuarios Inscriptos: perez@gmail.com\n" +
                "rosas@gmail.com\n" +
                "rodriguez@gmail.com\n" +
                "martinez@gmail.com\n";

		assertEquals(cadena, excursionDefinitivo.informacion());
	}
	
	@Test
	void testExcursionCompletaObtenerInformacion() {
		String cadena = "Nombre: excursion 3\n" +
                "Costo: 300.0\n" +
                "Fecha de Inicio: 2024-04-03\n" +
                "Fecha de Fin: 2024-04-17\n" +
                "Punto de Encuentro: Isla Paulina\n";
		//System.out.println(excursionCompleta.informacion());
		assertEquals(cadena, excursionCompleta.informacion());
	}
	
	@Test
	void testExcursionCompletaInscribir() {
		assertTrue(excursionCompleta.getEstado() instanceof CupoMaximo);
		
		excursionCompleta.inscribirUsuario(user5);
		assertEquals(1, excursionCompleta.getListaDeEspera().size());
	}
}

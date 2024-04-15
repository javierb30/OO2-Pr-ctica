package ar.edu.unlp.info.oo2.ejercicio6_Topografias;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PantanoTest {
	Pantano pantano;
	
	@BeforeEach
	void setUp() throws Exception {
		pantano = new Pantano();
	}

	@Test
	void testProporcionAgua() {
		assertEquals(0.7, pantano.proporcionAgua());
	}
	
	@Test
	void testProporcionTierra() {
		assertEquals(0.3, pantano.proporcionTierra());
	}
	
	@Test
	void testIsEquals() {
		assertTrue(pantano.isEquals(new Pantano()));
		assertFalse(pantano.isEquals(new Tierra()));
		assertFalse(pantano.isEquals(new Agua()));
	}
}

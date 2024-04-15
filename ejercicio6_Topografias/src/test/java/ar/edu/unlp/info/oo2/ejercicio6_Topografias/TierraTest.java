package ar.edu.unlp.info.oo2.ejercicio6_Topografias;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TierraTest {
	Tierra tierra;
	
	@BeforeEach
	void setUp() throws Exception {
		tierra = new Tierra();
	}

	@Test
	void testProporcionAgua() {
		assertEquals(0, tierra.proporcionAgua());
	}
	
	@Test
	void testProporcionTierra() {
		assertEquals(1, tierra.proporcionTierra());
	}
	
	@Test
	void testIsEquals() {
		assertTrue(tierra.isEquals(new Tierra()));
		assertFalse(tierra.isEquals(new Agua()));
		assertFalse(tierra.isEquals(new Pantano()));
	}
}

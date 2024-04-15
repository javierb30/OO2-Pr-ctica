package ar.edu.unlp.info.oo2.ejercicio6_Topografias;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class AguaTest {
	Agua agua;
	
	@BeforeEach
	void setUp() throws Exception {
		agua = new Agua();
	}

	@Test
	void testProporcionAgua() {
		assertEquals(1, agua.proporcionAgua());
	}
	
	@Test
	void testProporcionTierra() {
		assertEquals(0, agua.proporcionTierra());
	}
	
	@Test
	void testIsEquals() {
		assertTrue(agua.isEquals(new Agua()));
		assertFalse(agua.isEquals(new Tierra()));
		assertFalse(agua.isEquals(new Pantano()));
	}

}

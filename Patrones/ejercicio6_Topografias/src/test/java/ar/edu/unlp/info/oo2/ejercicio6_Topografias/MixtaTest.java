package ar.edu.unlp.info.oo2.ejercicio6_Topografias;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MixtaTest {
	Agua agua1;
	Agua agua2;
	Tierra tierra1;
	Tierra tierra2;
	Pantano pantano1;
	Pantano pantano2;
	Mixta mixtaAguaYTierra;
	Mixta mixtaSoloAguaTierraYMixta;
	Mixta mixtaPantanos;
	Mixta mixtaPantanosYMixta;
	
	@BeforeEach
	void setUp() throws Exception {
		agua1 = new Agua();
		tierra1 = new Tierra();
		agua2 = new Agua();
		tierra2 = new Tierra();
		pantano1 = new Pantano();
		pantano2 = new Pantano();
		mixtaAguaYTierra = new Mixta(agua1, tierra1, agua2, tierra2);
		mixtaSoloAguaTierraYMixta = new Mixta(agua1, tierra1, tierra2, mixtaAguaYTierra);
		mixtaPantanos = new Mixta(agua1, pantano1, tierra1, pantano2);
		mixtaPantanosYMixta = new Mixta(agua1, tierra1, tierra2, mixtaPantanos);
	}

	@Test
	void testProporcionDeAguaMixtaDeAguaYTierra() {
		assertEquals(0.5, mixtaAguaYTierra.proporcionAgua());
	}
	
	@Test
	void testProporcionDeAguaMixtaDeAguaTierraYMixta() {
		assertEquals(0.375, mixtaSoloAguaTierraYMixta.proporcionAgua());
	}
	
	@Test
	void testProporcionDeAguaMixtaDePantanos() {
		assertEquals(0.6, mixtaPantanos.proporcionAgua());
	}
	
	@Test
	void testProporcionDeAguaMixtaDePantanosYMixta() {
		assertEquals(0.4, mixtaPantanosYMixta.proporcionAgua());
	}

	@Test
	void testProporcionDeTierraMixtaDeAguaYTierra() {
		assertEquals(0.5, mixtaAguaYTierra.proporcionTierra());
	}
	
	@Test
	void testProporcionDeTierraMixtaDeAguaTierraYMixta() {
		assertEquals(0.625, mixtaSoloAguaTierraYMixta.proporcionTierra());
	}
	
	@Test
	void testProporcionDeTierraMixtaDePantanos() {
		assertEquals(0.4, mixtaPantanos.proporcionTierra());
	}
	
	@Test
	void testProporcionDeTierraMixtaDePantanosYMixta() {
		assertEquals(0.6, mixtaPantanosYMixta.proporcionTierra());
	}
	
	@Test
	void testIsEquals() {
		assertTrue(mixtaAguaYTierra.isEquals(mixtaAguaYTierra));
		assertFalse(mixtaAguaYTierra.isEquals(mixtaSoloAguaTierraYMixta));
		assertFalse(mixtaAguaYTierra.isEquals(mixtaPantanos));
		assertFalse(mixtaAguaYTierra.isEquals(mixtaPantanosYMixta));
		assertFalse(mixtaAguaYTierra.isEquals(agua1));
		assertFalse(mixtaAguaYTierra.isEquals(tierra1));
		assertFalse(mixtaAguaYTierra.isEquals(pantano1));
	}
}

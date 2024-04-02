package ar.edu.unlp.info.oo2.ejercicio1_RedSocial;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RetweetTest {

	Tweet tw1,tw2;
	Retweet rt1,rt2,rt3; 
	
	@BeforeEach
	void setUp() {
		tw1 = new Tweet("¿Quienes son?");
		tw2 = new Tweet("¿Quienes son?");
		rt1 = new Retweet(tw1);
		rt2 = new Retweet(tw1);
		rt3 = new Retweet(tw2);
	}
	
	@Test
	public void testText() {
		assertEquals("¿Quienes son?",rt1.getText());
		assertEquals(rt3.getText(),tw2.getText());
		assertEquals(rt1.getText(),tw2.getText());
	}
	
	@Test
	public void testRetweet() {
		assertEquals(tw1,rt1.getTweet());
		assertEquals(rt2.getTweet(),rt1.getTweet());
		assertNotEquals(rt3.getTweet(),rt1.getTweet());
	}

}
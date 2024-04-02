package ar.edu.unlp.info.oo2.ejercicio1_RedSocial;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TweetTest {
	Tweet tw1,tw2;
	
	@BeforeEach
	void setUp() {
		tw1 = new Tweet("¿Quienes son?");
		tw2 = new Tweet("¿Quienes son?");
	}
	
	@Test
	public void testText() {
		assertEquals("¿Quienes son?",tw1.getText());
		assertEquals("¿Quienes son?",tw2.getText());
		assertEquals(tw1.getText(),tw2.getText());
	}
	
	@Test
	public void testRetweet() {
		assertEquals(tw1,tw1.getTweet());
		assertNotEquals(tw2,tw1.getTweet());
	}

}


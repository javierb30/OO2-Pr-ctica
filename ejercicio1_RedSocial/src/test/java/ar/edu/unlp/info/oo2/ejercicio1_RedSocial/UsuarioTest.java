package ar.edu.unlp.info.oo2.ejercicio1_RedSocial;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
	Tweet tw1,tw2;
	Retweet rt1,rt2,rt3; 
	Usuario u1,u2,u3;
	
	@BeforeEach
	void setUp() {
		tw1 = new Tweet("¿Quienes son?");
		tw2 = new Tweet("¿Quienes son?");
		rt1 = new Retweet(tw1);
		rt2 = new Retweet(tw1);
		rt3 = new Retweet(tw2);
		u1 = new Usuario("juan01");
		u1.reTwittear(tw1);
		u1.reTwittear(tw2);
	}
	
	@Test
	public void testTwittear() {
		assertNotNull(u1.twittear("..."));
		assertNull(u1.twittear("........................................................................................................................................................................................................................................................................................................................................................"));
	}
	
	@Test
	public void testReTwittear() {
		assertEquals(u1.leerTweet(tw1),u1.leerTweet(tw2));
	}
	
	@Test
	public void testEliminarTweets() {
		List<Posteo> posteos = new ArrayList<Posteo>();
		posteos.add(tw1);
		assertEquals(2,u1.getTweets().size());
		u1.eliminarTweets(posteos);
		assertEquals(1,u1.getTweets().size());
		;
	}
	
}

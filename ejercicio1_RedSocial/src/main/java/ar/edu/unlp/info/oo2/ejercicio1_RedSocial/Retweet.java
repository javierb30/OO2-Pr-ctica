package ar.edu.unlp.info.oo2.ejercicio1_RedSocial;

public class Retweet implements Posteo{
	private Tweet origen;
	
	public Retweet(Tweet t) {
		origen = t;
	}
	
	public String getText() {
		return this.origen.getText();
	}

	@Override
	public Tweet getTweet() {
		return this.origen;
	}
}

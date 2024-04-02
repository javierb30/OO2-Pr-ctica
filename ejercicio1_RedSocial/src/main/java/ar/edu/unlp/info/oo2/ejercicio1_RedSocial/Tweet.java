package ar.edu.unlp.info.oo2.ejercicio1_RedSocial;

public class Tweet implements Posteo{
	private String texto;
	
	public Tweet (String t) {
		texto = t;
	}
	
	public String getText() {
		return this.texto;
	}

	public Tweet getTweet() {
		return this;
	}
	
}

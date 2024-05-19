package ar.edu.unlp.info.oo2.ejercicio1_RedSocial;

import java.util.*;
import java.util.stream.Collectors;

public class Usuario {
	private String screenName;
	private List<Posteo> posteos;
	
	public Usuario(String cN) {
		screenName = cN;
		posteos = new ArrayList<Posteo>();
	}
	
	
	public String getscreenName() {
		return this.screenName;
	}
	
	private boolean chequearTamañoTweet(String t) {
		return t.length() >0 && t.length()<281;
	}
	
	public Posteo twittear(String text) {
		if(chequearTamañoTweet(text)) {
			Tweet t = new Tweet(text);
			posteos.add(t);
			return t;
		}
		return null;
	}
	
	public Posteo reTwittear(Tweet t) {
		Retweet rt = new Retweet(t);
		posteos.add(rt);
		return rt;
	}
	
	public String leerTweet(Posteo tw) {
		return tw.getText();
	}
	
	public List<Posteo> getTweets() {
		return posteos;
	}
	
	private void eliminarTweets(Posteo t) {
		this.posteos = this.posteos.stream()
							.filter(tw -> !(tw.getTweet() == t)) 
							.collect(Collectors.toList());  
	}
	
	public void eliminarTweets(List<Posteo> tweets) {
		tweets.stream()
			.forEach(t -> this.eliminarTweets(t));
	}
}

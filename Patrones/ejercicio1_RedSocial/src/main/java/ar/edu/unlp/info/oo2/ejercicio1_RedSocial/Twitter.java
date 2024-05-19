package ar.edu.unlp.info.oo2.ejercicio1_RedSocial;

import java.util.*;

public class Twitter {
	private List<Usuario> usuarios;
	
	public Twitter() {
		usuarios = new ArrayList<Usuario>();
	}
	
	public int cantidadUsuarios() {
		//Para el test
		return this.usuarios.size();
	}
	
	private boolean chequearName(String n) {
		return usuarios.stream()
				.anyMatch(u -> u.getscreenName().equals(n));
	}
	
	public Usuario crearUsuario(String name) {
		if (!chequearName(name)) {
			Usuario u = new Usuario(name);
			usuarios.add(u);
			return u;
		}
		return null;
	}
	
	public void eliminarUsuario(Usuario u) {
		//Asumo que el usuario existe
		this.usuarios.stream()
				.forEach(usuario -> usuario.eliminarTweets(u.getTweets()));
		this.usuarios.remove(u);
	}
	
	public void agregarUsuario(Usuario u) {
		//Para testear
		usuarios.add(u);
	}
}

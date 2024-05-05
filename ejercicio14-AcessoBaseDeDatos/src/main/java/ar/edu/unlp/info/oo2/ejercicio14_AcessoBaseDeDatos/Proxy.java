package ar.edu.unlp.info.oo2.ejercicio14_AcessoBaseDeDatos;

import java.util.Collection;
import java.util.List;

public class Proxy implements DatabaseAccess{
	private DatabaseRealAccess acceso;
	private String contraseña;
	private boolean sesionIniciada;
	
	public Proxy(DatabaseRealAccess bd, String c) {
		this.acceso = bd;
		this.contraseña = c;
		this.sesionIniciada = false;
	}
	
	public String getContraseña() {
		//Esto estaría bien?
		return this.contraseña;
	}
	
	public boolean getSesionIniciada() {
		//Para el test
		return this.sesionIniciada;
	}
	
	public void setSesionIniciada(Boolean b) {
		this.sesionIniciada = b;
	}
	
	public void setContraseña(String newC) {
		if(this.sesionIniciada)
			this.contraseña = newC;
	}
	
	@Override
	public Collection<String> getSearchResults(String queryString) {
		if (!this.sesionIniciada)
			throw new RuntimeException("Acceso denegado");
		return acceso.getSearchResults(queryString);
	}

	@Override
	public int insertNewRow(List<String> rowData) {
		if (!this.sesionIniciada)
			throw new RuntimeException("Acceso denegado");
		return acceso.insertNewRow(rowData);
	}
	
	public void iniciarSesion(String c) {
		//Con esta  implementación, solo un usuario a la vez puede iniciar sesión
		if(!this.sesionIniciada) 
			if(this.getContraseña().equals(c))  //Está bien usar getContraseña o deberia directamente hacer this.contraseña?
				this.setSesionIniciada(true);
			else
				throw new RuntimeException("Acceso denegado. Contraseña inválida.");
		else
			throw new RuntimeException("Ya se encuentra la sesión iniciada.");
	}
	
	public void cerrarSesion() {
		if(this.sesionIniciada)
			this.setSesionIniciada(false);
		else
			throw new RuntimeException("No se encuentra logueado. Debe iniciar sesión.");
	}
	
}

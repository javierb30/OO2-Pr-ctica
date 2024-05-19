package ar.edu.unlp.info.oo2.ejercicio6_Topografias;

import java.util.*;

public class Mixta extends Topografia{
	private List<Topografia> componentes;
	
	public Mixta(Topografia c1, Topografia c2, Topografia c3, Topografia c4) {
		this.componentes = new ArrayList<Topografia>();
		this.componentes.add(c1);
		this.componentes.add(c2);
		this.componentes.add(c3);
		this.componentes.add(c4);
	}

	@Override
	public double proporcionAgua() {
		return (this.getComponentes().stream()
				.mapToDouble(c -> c.proporcionAgua())
				.sum())/4;
	}
	
	private List<Topografia> getComponentes(){
		return this.componentes;
	}
	
	@Override
	public double proporcionTierra() {
		return (this.getComponentes().stream()
				.mapToDouble(c -> c.proporcionTierra())
				.sum())/4;
	}
	
	public boolean isEquals(Topografia t) {
		return t.isEquals(this);
	}
	
	public boolean isEquals(Mixta tMixta) {
		return this.componentes.equals(tMixta.getComponentes()); //Esto sería la corrección?
		/*Topografia componente1;
		Topografia componente2;
		for (int i = 0; i < this.getComponentes().size(); i++) {
			componente1 = this.getComponentes().get(i);
			componente2 = tMixta.getComponentes().get(i);
			if (!componente1.isEquals(componente2)) {
				return false;
			}
		}
		return true;*/
	}

	public boolean isEquals(Agua a) {
		return false;
	}

	public boolean isEquals(Tierra t) {
		return false;
	}

	@Override
	public boolean isEquals(Pantano p) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}

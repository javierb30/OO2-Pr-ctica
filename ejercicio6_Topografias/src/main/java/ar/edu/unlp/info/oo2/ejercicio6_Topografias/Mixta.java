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
	
	//Esta es por si en el Test, envias mensaje de t1 a t2 t2.isEquals(t1)
	// la que envíe el mensaje siempre  está declarada de tipo Tipografia para lograr
	// correctamente el polimorfismo
	
	public boolean isEquals(Topografia t) {
		return t.isEquals(this);
	}
	
	
	public boolean isEquals(Mixta tMixta) {
		Topografia componente1;
		Topografia componente2;
		for (int i = 0; i < this.getComponentes().size(); i++) {
			componente1 = this.getComponentes().get(i);
			componente2 = tMixta.getComponentes().get(i);
			if (!componente1.isEquals(componente2)) {
				return false;
			}
		}
		return true;
	}
	/* Mirando mi ejemplo en papel
	1 envía mensaje a 2, 2.isEquals(1), 2 encara por isEquals(Topografia) y esto lleva a que llame a 
	1 con isEquals -> entonces, 1 encara por isEquals(Mixta) porque ya sabe que el que lo llamó
	es de tipo Mixta por el "this"... y así con todo todo el tiempo como un ida y vuelta
	*/
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

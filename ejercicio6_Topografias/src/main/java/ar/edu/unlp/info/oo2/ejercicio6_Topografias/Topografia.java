package ar.edu.unlp.info.oo2.ejercicio6_Topografias;

public abstract class  Topografia {
	
	public abstract double proporcionAgua();
	
	public abstract double proporcionTierra();

	public abstract boolean isEquals(Topografia t);

	public abstract boolean isEquals(Agua a);
	
	public abstract boolean isEquals(Tierra t);
	
	public abstract boolean isEquals(Pantano p);
	
	public boolean isEquals(Mixta tMixta) {
		return false;
	}
}

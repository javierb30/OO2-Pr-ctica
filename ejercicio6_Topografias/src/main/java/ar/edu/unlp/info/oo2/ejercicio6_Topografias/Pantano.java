package ar.edu.unlp.info.oo2.ejercicio6_Topografias;

public class Pantano extends Topografia{
	
	public Pantano() {
		
	}
	@Override
	public double proporcionAgua() {
		return 0.7;
	}

	@Override
	public double proporcionTierra() {
		return 0.3;
	}

	@Override
	public boolean isEquals(Topografia t) { 
		return t.isEquals(this);
	}

	@Override
	public boolean isEquals(Agua a) {
		return false;
	}

	@Override
	public boolean isEquals(Tierra t) {
		return false;
	}
	@Override
	public boolean isEquals(Pantano p) {
		return true;
	}

}

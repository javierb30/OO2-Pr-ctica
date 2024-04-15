package ar.edu.unlp.info.oo2.ejercicio6_Topografias;

public class Agua extends Topografia{
	
	public Agua() {
		
	}

	@Override
	public double proporcionAgua() {
		return 1;
	}

	@Override
	public double proporcionTierra() {
		return 0;
	}

	@Override
	public boolean isEquals(Topografia t) {
		return t.isEquals(this);
	}

	@Override
	public boolean isEquals(Agua a) {
		return true;
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

package ar.edu.unlp.info.oo2.ejercicio6_Topografias;

public class Tierra extends Topografia{
	public Tierra() {
		
	}

	@Override
	public double proporcionAgua() {
		return 0;
	}

	@Override
	public double proporcionTierra() {
		return 1;
	}

	@Override
	public boolean isEquals(Topografia t) {
		return t.isEquals(this);
	}

	@Override
	public boolean isEquals(Agua a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEquals(Tierra t) {
		return true;
	}

	@Override
	public boolean isEquals(Pantano p) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}

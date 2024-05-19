package ar.edu.unlp.info.oo2.ejercicio15_FileManager;

public class AspectoPermisos extends Aspecto{

	public AspectoPermisos(FileOO2 file) {
		super(file);
	}

	@Override
	public String prettyPrint() {
		return super.prettyPrint() + "Permisos - " + this.getPermisos() + "\n";
	}
}

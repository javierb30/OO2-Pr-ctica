package ar.edu.unlp.info.oo2.ejercicio15_FileManager;

public class AspectoNombre extends Aspecto{
	
	public AspectoNombre(FileOO2 file) {
		super(file);
	}
	
	public String prettyPrint() {
		return super.prettyPrint() + "Nombre - " + this.getNombre() + "\n";
	}
}

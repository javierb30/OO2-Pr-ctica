package ar.edu.unlp.info.oo2.ejercicio15_FileManager;

public class AspectoFechaCreacion extends Aspecto{
	
	public AspectoFechaCreacion(FileOO2 file) {
		super(file);
	}

	public String prettyPrint() {
		return super.prettyPrint() + "Fecha de creación - " + this.getFechaCreacion() + "\n";
	}
}

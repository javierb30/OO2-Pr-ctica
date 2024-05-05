package ar.edu.unlp.info.oo2.ejercicio15_FileManager;

public class AspectoFechaModificacion extends Aspecto{

	public AspectoFechaModificacion(FileOO2 file) {
		super(file);
	}
	
	@Override
	public String prettyPrint() {
		return super.prettyPrint() + "Fecha de ultima modificación - " + this.getFechaModificacion() + "\n";
	}
}

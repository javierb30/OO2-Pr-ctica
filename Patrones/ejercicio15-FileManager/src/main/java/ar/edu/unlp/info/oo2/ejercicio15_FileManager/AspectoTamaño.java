package ar.edu.unlp.info.oo2.ejercicio15_FileManager;

public class AspectoTamaño extends Aspecto{

	public AspectoTamaño(FileOO2 file) {
		super(file);
	}

	@Override
	public String prettyPrint() {
		return super.prettyPrint() + "Tamaño - " + this.getTamaño() + "MB" + "\n";
	}
}

package ar.edu.unlp.info.oo2.ejercicio15_FileManager;

public class AspectoExtension extends Aspecto{
	
	public AspectoExtension(FileOO2 file) {
		super(file);
	}
	
	@Override
	public String prettyPrint() {
		return super.prettyPrint() + "Extension - " + this.getExtension() + "\n";
	}
}

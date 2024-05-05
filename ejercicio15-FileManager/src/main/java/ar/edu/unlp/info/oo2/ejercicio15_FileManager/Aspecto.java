package ar.edu.unlp.info.oo2.ejercicio15_FileManager;

public class Aspecto implements FileOO2{
	private FileOO2 file;
	
	public Aspecto(FileOO2 file) {
		this.file = file;
	}
	
	public FileOO2 getFile() {
		return this.file;
	}

	@Override
	public String prettyPrint() {
		return this.getFile().prettyPrint();
	}

	@Override
	public String getNombre() {
		return this.getFile().getNombre();
	}

	@Override
	public String getExtension() {
		return this.getFile().getExtension();
	}

	@Override
	public String getTamaño() {
		return this.getFile().getTamaño();
	}

	@Override
	public String getFechaCreacion() {
		return this.getFile().getFechaCreacion();
	}

	@Override
	public String getFechaModificacion() {
		return this.getFile().getFechaModificacion();
	}

	@Override
	public String getPermisos() {
		return this.getFile().getPermisos();
	}
	
	
}

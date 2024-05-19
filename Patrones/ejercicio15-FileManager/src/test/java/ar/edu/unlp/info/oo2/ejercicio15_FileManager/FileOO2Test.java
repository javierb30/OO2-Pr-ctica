package ar.edu.unlp.info.oo2.ejercicio15_FileManager;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileOO2Test {
	
	private FileOO2 file;
	private FileOO2 name;
	private FileOO2 extension;
	private FileOO2 size;
	private FileOO2 creationDate;
	private FileOO2 permissions;
	
	@BeforeEach
	void setUp() throws Exception {
		this.file = new Archivo("Vivo_Gustavo_Cerati", 
				".mp3", 
				3.5, 
				LocalDate.of(2024, 4, 29), 
				LocalDate.of(2024, 4, 29), 
				"rwx-r-xrw-");
	}

	@Test
	void testPrettyPrintOption1() {
		//nombre - extensión
		
		this.name = new AspectoNombre(this.file);
		this.extension = new AspectoExtension(this.name);
		
		String data = "Archivo data:\n" +
	              "Nombre - Vivo_Gustavo_Cerati\n" +
	              "Extension - .mp3\n";
		assertEquals(data, this.extension.prettyPrint());
	}
	
	@Test
	void testPrettyPrintOption2() {
		//nombre - extensión - fecha de creación
		
		this.name = new AspectoNombre(this.file);
		this.extension = new AspectoExtension(this.name);
		this.creationDate = new AspectoFechaCreacion(this.extension);
		
		String data = "Archivo data:\n" +
	              "Nombre - Vivo_Gustavo_Cerati\n" +
	              "Extension - .mp3\n" +
	              "Fecha de creación - 2024-04-29\n";
		
		assertEquals(data, this.creationDate.prettyPrint());
	}
	
	@Test
	void testPrettyPrintOption3() {
		//permisos - nombre - extensión - tamaño
		
		this.permissions = new AspectoPermisos(this.file);
		this.name = new AspectoNombre(this.permissions);
		this.extension = new AspectoExtension(this.name);
		this.size = new AspectoTamaño(this.extension);
		
		String data = "Archivo data:\n" +
	              "Permisos - rwx-r-xrw-\n" +
	              "Nombre - Vivo_Gustavo_Cerati\n" +
	              "Extension - .mp3\n" +
	              "Tamaño - 3.5MB\n";
		
		assertEquals(data, this.size.prettyPrint());
	}

}
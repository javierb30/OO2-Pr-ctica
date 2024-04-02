package ar.edu.unlp.info.oo2.biblioteca;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.*;

import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BibliotecaTest {
	
	Biblioteca biblioteca ;
	JSONParser parseo;
	Socio socio1;
	Socio socio2;
	
	@BeforeEach
	void setUp() {
		biblioteca = new Biblioteca();
		socio1 = new Socio("Arya Stark", "needle@stark.com", "5234-5");
		socio2 = new Socio("Tyron Lannister", "tyron@thelannisters.com", "2345-2");
		biblioteca.agregarSocio(socio1);
		biblioteca.agregarSocio(socio2);
		parseo = new JSONParser();
	}
	
	@Test
	public void testAgregarSocio() {
		assertEquals(2,biblioteca.getSocios().size());
		biblioteca.agregarSocio(new Socio("g Stark", "needle@stark.com", "5234-5"));
		assertEquals(3,biblioteca.getSocios().size());
	}
	
	/*
	@Test
	public void testExportarSocios() {
		biblioteca.agregarSocio(new Socio("Arya Stark", "needle@stark.com", "5234-5"));
		biblioteca.agregarSocio(new Socio("Tyron Lannister", "tyron@thelannisters.com","2345-2"));
		
		String res = "[\n"
				+ "	{\n"
				+ "		\"nombre\": \"Arya Stark\",\n"
				+ "		\"email\": \"needle@stark.com\",\n"
				+ "		\"legajo\": \"5234-5\"\n"
				+ "	},\n"
				+ "	{\n"
				+ "		\"nombre\": \"Tyron Lannister\",\n"
				+ "		\"email\": \"tyron@thelannisters.com\",\n"
				+ "		\"legajo\": \"2345-2\"\n"
				+ "	}\n"
				+ "]";
		System.out.println(biblioteca.exportarSocios());
		assertEquals(res,biblioteca.exportarSocios());
	}*/
	
	@Test
	void testJSONSimple() throws ParseException, org.json.simple.parser.ParseException {
		VoorheesExporter adapter = new JSONSimpleAdapter();
		String salida = "[\n"
				+ "	{\n"
				+ "		\"nombre\": \"Arya Stark\",\n"
				+ "		\"email\": \"needle@stark.com\",\n"
				+ "		\"legajo\": \"5234-5\"\n"
				+ "	},\n"
				+ "	{\n"
				+ "		\"nombre\": \"Tyron Lannister\",\n"
				+ "		\"email\": \"tyron@thelannisters.com\",\n"
				+ "		\"legajo\": \"2345-2\"\n"
				+ "	}\n"
				+ "]\n"
				+ "";
		biblioteca.setExporter(adapter);
		assertEquals(parseo.parse(salida), parseo.parse(this.biblioteca.exportarSocios()));
	}

	//biblioteca.agregarSocio(new Socio("Arya Stark", "needle@stark.com", "5234-5"));
	//biblioteca.agregarSocio(new Socio("Tyron Lannister", "tyron@thelannisters.com",
	//"2345-2"));
	
	
}

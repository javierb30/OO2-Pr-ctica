package ar.edu.unlp.info.oo2.ejercicio12_DispositivoMovilYConexiones;

public class Conn4G {
	private String symb;
	
	public Conn4G() {
		this.symb = "Conexión 4G";
	}
	
	public String transmit(String data, long crc) {
		//Trabaja el dato, procesa la información
		return "Dato formado con 4G";
	}
	
	public String symb() {
		return this.symb;
	}
}

package ar.edu.unlp.info.oo2.ejercicio12_DispositivoMovilYConexiones;

public class WifiConn implements Connection{
	
	private String pict;
	
	public WifiConn() {
		this.pict = "Conexión Wifi";
	}
	
	public String sendData(String data, long crc) {
		//Trabaja el dato, procesa la información
		return "Dato formado con Wifi";
	}
	
	public String pict() {
		return this.pict;
	}
}

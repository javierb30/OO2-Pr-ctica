package ar.edu.unlp.info.oo2.ejercicio12_DispositivoMovilYConexiones;

public interface Connection {
	
	public String sendData(String data,long crc);
	
	public String pict();
}

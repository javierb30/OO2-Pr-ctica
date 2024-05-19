package ar.edu.unlp.info.oo2.ejercicio12_DispositivoMovilYConexiones;
import java.util.zip.CRC32;

public class CRC32_Calculator implements CRC_Calculator{
	
	public CRC32_Calculator() {
		
	}

	public long crcFor(String data) {
		CRC32 crc = new CRC32();
		String datos = "un mensaje";
		crc.update(datos.getBytes());
		return  crc.getValue();
	}
	
	
}

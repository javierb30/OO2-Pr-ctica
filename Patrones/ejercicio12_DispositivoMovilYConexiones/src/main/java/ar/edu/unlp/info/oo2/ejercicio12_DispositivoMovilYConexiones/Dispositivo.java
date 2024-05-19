package ar.edu.unlp.info.oo2.ejercicio12_DispositivoMovilYConexiones;

public class Dispositivo {	
	private Ringer ringer;
	private Display display;
	private CRC_Calculator crcCalculator;
	private Connection connection;
	
	public Dispositivo(Ringer r, Display d, CRC_Calculator crc, Connection c) {
		this.ringer = r;
		this.display = d;
		this.crcCalculator = crc;
		this.connection = c;
	}
	
	public String send(String data) {
		long crc = this.crcCalculator.crcFor(data);
		return this.connection.sendData(data,crc);
	}
	
	public void cambioConexion(Connection otraCon) {
		this.connection = otraCon;
		this.display.showBanner(this.connection.pict());
		this.ringer.ring();
	}
	
	public void configurarCRC(CRC_Calculator otroCRC) {
		this.crcCalculator = otroCRC;
	}
}

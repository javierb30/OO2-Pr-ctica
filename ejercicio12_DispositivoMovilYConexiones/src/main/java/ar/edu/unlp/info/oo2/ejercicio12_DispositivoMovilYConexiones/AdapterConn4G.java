package ar.edu.unlp.info.oo2.ejercicio12_DispositivoMovilYConexiones;

public class AdapterConn4G implements Connection{
	private Conn4G adaptee;
	
	public AdapterConn4G() {
		this.adaptee = new Conn4G();
	}
	
	@Override
	public String sendData(String data, long crc) {
		return this.adaptee.transmit(data, crc);
	}

	@Override
	public String pict() {
		return this.adaptee.symb();
	}
	
}

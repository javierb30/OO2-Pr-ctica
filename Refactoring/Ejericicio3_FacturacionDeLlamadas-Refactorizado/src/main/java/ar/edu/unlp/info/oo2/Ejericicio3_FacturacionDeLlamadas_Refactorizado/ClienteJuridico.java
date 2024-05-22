package ar.edu.unlp.info.oo2.Ejericicio3_FacturacionDeLlamadas_Refactorizado;

public class ClienteJuridico extends Cliente {
    private String cuit;

    public ClienteJuridico(String nombre, String numeroTelefono,String cuit){
        super(nombre,numeroTelefono);
        this.cuit = cuit;
    }

    public String getCuit(){
        return cuit;
    }
    
    public double calcularMonto(double auxMonto) {
		return auxMonto -= auxMonto*descuentoJur;
	}
}

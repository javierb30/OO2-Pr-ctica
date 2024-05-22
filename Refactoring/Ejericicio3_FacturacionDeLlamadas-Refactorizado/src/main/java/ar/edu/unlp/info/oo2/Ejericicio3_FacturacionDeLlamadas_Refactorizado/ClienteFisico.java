package ar.edu.unlp.info.oo2.Ejericicio3_FacturacionDeLlamadas_Refactorizado;

public class ClienteFisico extends Cliente{
	private String dni;
	
    public ClienteFisico(String nombre, String numeroTelefono,String dni){
        super(nombre,numeroTelefono);
        this.dni = dni;
    }

    public String getDni(){
        return dni;
    }
    
    public double calcularMonto(double auxMonto) {
		return auxMonto -= auxMonto*descuentoFis;
	}
}

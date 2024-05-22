package ar.edu.unlp.info.oo2.Ejericicio3_FacturacionDeLlamadas_Refactorizado;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private List<Llamada> llamadas = new ArrayList<Llamada>();
	private GestorNumerosDisponibles guia = new GestorNumerosDisponibles();


	public boolean agregarNumeroTelefono(String numeroTelefono) {
		boolean encontre = guia.getLineas().contains(numeroTelefono);
		if (!encontre) {
			guia.getLineas().add(numeroTelefono);
			encontre= true;
			return encontre;
		}
		else {
			encontre= false;
			return encontre;
		}
	}

	public String obtenerNumeroLibre() {
		return guia.obtenerNumeroLibre();
	}

	public Cliente registrarClienteFisico(String dni, String nombre) {
        String tel = this.obtenerNumeroLibre();
        Cliente cliente = new ClienteFisico(nombre,tel,dni);
        clientes.add(cliente);
        return cliente;
	}
	public Cliente registrarClienteJuridico(String cuit, String nombre) {
        String tel = this.obtenerNumeroLibre();
        Cliente cliente = new ClienteJuridico(nombre,tel,cuit);
        clientes.add(cliente);
        return cliente;
    }


	public Llamada registrarLlamadaNacional(Cliente origen, Cliente destino, int duracion) {
        Llamada llamada = new LlamadaNacional(origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion);
        llamadas.add(llamada);
        origen.agregarLlamada(llamada);
        return llamada;
    }

	public Llamada registrarLlamadaInternacional(Cliente origen, Cliente destino,int duracion) {
        Llamada llamada = new LlamadaInternacional(origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion);
        llamadas.add(llamada);
        origen.agregarLlamada(llamada);
        return llamada;
    }

	public double calcularMontoTotalLlamadas(Cliente cliente) {
		return cliente.calcularMontoTotalLlamadas();
	}


	public int cantidadDeClientes() {
		return clientes.size();
	}

	public boolean existeCliente(Cliente cliente) {
		return clientes.contains(cliente);
	}

	public GestorNumerosDisponibles getGuia() {
		return this.guia;
	}
}

### 3 Facturación de Llamadas
Inicia con el código inicial que nos brinda la cátedra

1. **Mal Olor:** Nombre poco o mal descripto: 
                                - En el método getRemitente() de la clase Llamada tiene que ser correspondiente a su variable de instancias "destino".
                                - En el método agregarNumeroTelefono(String str) de la clase Empresa, el parámetro formal debe ser más descriptivo como numeroTelefono.
                                - En el método registrarUsuario(...) la variable de tipo Cliente debe llamarse cliente, y la llamo registrarCliente(...) -> Modificar tambien en el test
                                - En el método registrarLlamada(...) el parámetro formal t debe llamarse tipoLlamada
                                - En el método calcularMontoTotalLlamadas(...) la variable c -> montoTotal, l -> llamada, auxc -> auxMonto
                                - El método getGestorNumeros() debe llamarse getGuia()
                                - El método cantidadDeUsuarios() debe llamarse cantidadDeClientes()
                                - El método existeUsuario() debería llamarse existeCliente() y su parametro debe ser cliente no persona
                                - En el método cambiarTipoGenerador de la clase GestorNumerosDisponibles el parametro debe llamarse tipo, no valor.

2. **Código a modificar:**
```java
//Clase Llamada
public String getRemitente() {
		return destino;
	}
//Clase Empresa
public boolean agregarNumeroTelefono(String str) {
		boolean encontre = guia.getLineas().contains(str);
		if (!encontre) {
			guia.getLineas().add(str);
			encontre= true;
			return encontre;
		}
		else {
			encontre= false;
			return encontre;
		}
	}
public Cliente registrarUsuario(String data, String nombre, String tipo) {
        Cliente var = new Cliente();
        if (tipo.equals("fisica")) {
            var.setNombre(nombre);
            String tel = this.obtenerNumeroLibre();
            var.setTipo(tipo);
            var.setNumeroTelefono(tel);
            var.setDNI(data);
        }
        else if (tipo.equals("juridica")) {
            String tel = this.obtenerNumeroLibre();
            var.setNombre(nombre);
            var.setTipo(tipo);
            var.setNumeroTelefono(tel);
            var.setCuit(data);
        }
        clientes.add(var);
        return var;
    }
public Llamada registrarLlamada(Cliente origen, Cliente destino, String t, int duracion) {
        Llamada llamada = new Llamada(t, origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion);
        llamadas.add(llamada);
        origen.llamadas.add(llamada);
        return llamada;
    }
public double calcularMontoTotalLlamadas(Cliente cliente) {
        double c = 0;
        for (Llamada l : cliente.llamadas) {
            double auxc = 0;
            if (l.getTipoDeLlamada() == "nacional") {
                // el precio es de 3 pesos por segundo más IVA sin adicional por establecer la llamada
                auxc += l.getDuracion() * 3 + (l.getDuracion() * 3 * 0.21);
            } else if (l.getTipoDeLlamada() == "internacional") {
                // el precio es de 150 pesos por segundo más IVA más 50 pesos por establecer la llamada
                auxc += l.getDuracion() * 150 + (l.getDuracion() * 150 * 0.21) + 50;
            }

            if (cliente.getTipo() == "fisica") {
                auxc -= auxc*descuentoFis;
            } else if(cliente.getTipo() == "juridica") {
                auxc -= auxc*descuentoJur;
            }
            c += auxc;
        }
        return c;
    }
public GestorNumerosDisponibles getGestorNumeros() {
        return this.guia;
    }
public int cantidadDeUsuarios() {
        return clientes.size();
    }
public boolean existeUsuario(Cliente persona) {
    return clientes.contains(persona);
}
//Clase GestorNumerosDisponibles
public void cambiarTipoGenerador(String valor) {
        this.tipoGenerador = valor;
    }

//Clase Test
@Test
	void testcalcularMontoTotalLlamadas() {
		Cliente emisorPersonaFisca = sistema.registrarUsuario("11555666", "Brendan Eich" , "fisica");
		Cliente remitentePersonaFisica = sistema.registrarUsuario("00000001", "Doug Lea" , "fisica");
		Cliente emisorPersonaJuridica = sistema.registrarUsuario("17555222", "Nvidia Corp" , "juridica");
		Cliente remitentePersonaJuridica = sistema.registrarUsuario("25765432", "Sun Microsystems" , "juridica");
        //...
    }
@Test
	void testAgregarUsuario() {
		assertEquals(this.sistema.cantidadDeClientes(), 0);
		this.sistema.agregarNumeroTelefono("2214444558"); 
		Cliente nuevaPersona = this.sistema.registrarUsuario("2444555","Alan Turing", "fisica");
        //...
    }

```

3. **Refactoring:** Rename Method

4. **Resultado:** 
```java
//Clase Llamada
public String getDestino() {
		return destino;
	}
//Clase Empresa
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
public Cliente registrarCliente(String data, String nombre, String tipo) {
        Cliente cliente = new Cliente();
        if (tipo.equals("fisica")) {
            cliente.setNombre(nombre);
            String tel = this.obtenerNumeroLibre();
            cliente.setTipo(tipo);
            cliente.setNumeroTelefono(tel);
            cliente.setDNI(data);
        }
        else if (tipo.equals("juridica")) {
            String tel = this.obtenerNumeroLibre();
            cliente.setNombre(nombre);
            cliente.setTipo(tipo);
            cliente.setNumeroTelefono(tel);
            cliente.setCuit(data);
        }
        clientes.add(cliente);
        return cliente;
    }
public Llamada registrarLlamada(Cliente origen, Cliente destino, String tipoLlamada, int duracion) {
        Llamada llamada = new Llamada(tipoLlamada, origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion);
        llamadas.add(llamada);
        origen.llamadas.add(llamada);
        return llamada;
    }
public double calcularMontoTotalLlamadas(Cliente cliente) {
        double montoTotal = 0;
        for (Llamada llamada : cliente.llamadas) {
            double auxMonto = 0;
            if (llamada.getTipoDeLlamada() == "nacional") {
                // el precio es de 3 pesos por segundo más IVA sin adicional por establecer la llamada
                auxMonto += llamada.getDuracion() * 3 + (llamada.getDuracion() * 3 * 0.21);
            } else if (llamada.getTipoDeLlamada() == "internacional") {
                // el precio es de 150 pesos por segundo más IVA más 50 pesos por establecer la llamada
                auxMonto += llamada.getDuracion() * 150 + (llamada.getDuracion() * 150 * 0.21) + 50;
            }

            if (cliente.getTipo() == "fisica") {
                auxMonto -= auxMonto*descuentoFis;
            } else if(cliente.getTipo() == "juridica") {
                auxMonto -= auxMonto*descuentoJur;
            }
            montoTotal += auxMonto;
        }
        return montoTotal;
    }
public GestorNumerosDisponibles getGuia() {
        return this.guia;
    }
public int cantidadDeClientes() {
        return clientes.size();
    }
public boolean existeCliente(Cliente cliente) {
    return clientes.contains(cliente);
}
//Clase GestorNumerosDisponibles
public void cambiarTipoGenerador(String tipo) {
        this.tipoGenerador = tipo;
    }

//Clase Test
@Test
	void testcalcularMontoTotalLlamadas() {
		Cliente emisorPersonaFisca = sistema.registrarCliente("11555666", "Brendan Eich" , "fisica");
		Cliente remitentePersonaFisica = sistema.registrarCliente("00000001", "Doug Lea" , "fisica");
		Cliente emisorPersonaJuridica = sistema.registrarCliente("17555222", "Nvidia Corp" , "juridica");
		Cliente remitentePersonaJuridica = sistema.registrarCliente("25765432", "Sun Microsystems" , "juridica");
        //...
    }
@Test
	void testAgregarUsuario() {
		assertEquals(this.sistema.cantidadDeClientes(), 0);
		this.sistema.agregarNumeroTelefono("2214444558"); 
		Cliente nuevaPersona = this.sistema.registrarCliente("2444555","Alan Turing", "fisica");
        //...
    }
```

1. **Mal Olor:** llamadas es de tipo público, lo que rompe el encapsulamiento al igual que todos los setters públicos a todas las variables de instancia privadas

2. **Código a modificar:**
```java
public class Cliente {
	public List<Llamada> llamadas = new ArrayList<Llamada>();
	private String tipo;
	private String nombre;
	private String numeroTelefono;
	private String cuit;
	private String dni;

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public String getDNI() {
		return dni;
	}
	public void setDNI(String dni) {
		this.dni = dni;
	}
}
//Clase Empresa
public Cliente registrarCliente(String data, String nombre, String tipo) {
        Cliente cliente = new Cliente();
        if (tipo.equals("fisica")) {
        	
            cliente.setNombre(nombre);
            String tel = this.obtenerNumeroLibre();
            cliente.setTipo(tipo);
            cliente.setNumeroTelefono(tel);
            cliente.setDNI(data);
        }
        else if (tipo.equals("juridica")) {
            String tel = this.obtenerNumeroLibre();
            cliente.setNombre(nombre);
            cliente.setTipo(tipo);
            cliente.setNumeroTelefono(tel);
            cliente.setCuit(data);
        }
        clientes.add(cliente);
        return cliente;
    }
```

3. **Refactoring:** - Encapsulate Field -> Poner como atributo privado a llamadas y debo generar un 
                    get correspondiente para que siga funcionando cuando lo llaman.
                    - Remove Setting Method -> Eliminar los métodos con set
                    - Agregar constructor como buena práctica de programación para inicializar correspondientemente el objeto. Esto conlleva a que deba modificar el código donde se rregistra un cliente en la clase Empresa ya que trabajaba con los setters eliminados. También otro constructor vacío para poder utilizar la lógica actual.


4. **Resultado:** 
```java
//Clase Cliente
public class Cliente {
	private List<Llamada> llamadas;
	private String tipo;
	private String nombre;
	private String numeroTelefono;
	private String cuit;
	private String dni;

    public Cliente(String tipo, String nombre, String numeroTelefono, String cuit, String dni){
        this.llamadas = new ArrayList<Llamada>(); //Mejor inicializarlo acá que en la declaración de las VI (Buena práctica)
        this.tipo = tipo;
        this.nombre = nombre;
        this.numeroTelefono = numeroTelefono;
        this.cuit = cuit;
        this.dni = dni;
    }
    public List<Llamada> getLlamadas() {
		return llamadas;
	}
	public String getTipo() {
		return tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	public String getCuit() {
		return cuit;
	}
	public String getDNI() {
		return dni;
	}
}
//Clase Empresa
public Cliente registrarCliente(String data, String nombre, String tipo) {
    Cliente cliente = new Cliente();
    if (tipo.equals("fisica")) {
        String tel = this.obtenerNumeroLibre();
        cliente = new Cliente(tipo,nombre,tel,"",data);
    }
    else if (tipo.equals("juridica")) {
        String tel = this.obtenerNumeroLibre();
        cliente = new Cliente(tipo,nombre,tel,data,"");
    }
    clientes.add(cliente);
    return cliente;
}

```

1. **Mal Olor:** Switch/if statements parte 1 -> El método RegistrarCliente de la clase Empresa está utilizando los if para determinar el tipo de cliente. 

2. **Código a modificar:**
```java
public Cliente registrarCliente(String data, String nombre, String tipo) {
		Cliente cliente = new Cliente();
        if (tipo.equals("fisica")) {
            String tel = this.obtenerNumeroLibre();
        	cliente = new Cliente(tipo,nombre,tel,"",data);
        }
        else if (tipo.equals("juridica")) {
            String tel = this.obtenerNumeroLibre();
            cliente = new Cliente(tipo,nombre,tel,data,"");
        }
        clientes.add(cliente);
        return cliente;
    }
```
3. **Refactoring:** Necesito aplicar Extract Method para separar los registros del tipo de cliente y Rename field para cambiar data por dni o cuit donde corresponda

4. **Resultado:** 
```java
public Cliente registrarClienteFisico(String dni, String nombre) {
        String tel = this.obtenerNumeroLibre();
        cliente = new Cliente("fisica",nombre,tel,"",dni);
        clientes.add(cliente);
        return cliente;
}
public Cliente registrarClienteJuridico(String cuit, String nombre) {
        String tel = this.obtenerNumeroLibre();
        cliente = new Cliente("juridica",nombre,tel,cuit,"");
        clientes.add(cliente);
        return cliente;
    }
```


1. **Mal Olor:** Switch/if statements parte 2

2. **Código a modificar:**
```java
//Clase Empresa
public Cliente registrarClienteFisico(String dni, String nombre) {
        String tel = this.obtenerNumeroLibre();
        cliente = new Cliente("fisica",nombre,tel,"",dni);
        clientes.add(cliente);
        return cliente;
}
public Cliente registrarClienteJuridico(String cuit, String nombre) {
        String tel = this.obtenerNumeroLibre();
        cliente = new Cliente("juridica",nombre,tel,cuit,"");
        clientes.add(cliente);
        return cliente;
    }

//Clase test
@Test
	void testcalcularMontoTotalLlamadas() {
		Cliente emisorPersonaFisca = sistema.registrarCliente("11555666", "Brendan Eich" , "fisica");
		Cliente remitentePersonaFisica = sistema.registrarCliente("00000001", "Doug Lea" , "fisica");
		Cliente emisorPersonaJuridica = sistema.registrarCliente("17555222", "Nvidia Corp" , "juridica");
		Cliente remitentePersonaJuridica = sistema.registrarCliente("25765432", "Sun Microsystems" , "juridica");
        //...
    }
@Test
	void testAgregarUsuario() {
		assertEquals(this.sistema.cantidadDeClientes(), 0);
		this.sistema.agregarNumeroTelefono("2214444558"); 
		Cliente nuevaPersona = this.sistema.registrarCliente("2444555","Alan Turing", "fisica");
        //...
    }
```

3. **Refactoring:** Replace Conditional with Polymorphism -> Se soluciona utilizando clases polimorficas generando herencia en la clase Cliente con el tipo ClienteFisico y ClienteJuridico que estas extienden de la clase abstracta Cliente. Esto también provocará cambios en el test. Como consecuencia de esto ocurren problemas en el método calcularMontoTotalLlamadas de la clase Empresa por el chequeo de tipo del cliente, procedemos a analizar el método completo


4. **Resultado:** 
```java
public abstract class Cliente {
	private List<Llamada> llamadas;
	private String nombre;
	private String numeroTelefono;
    private String tipo;
	
	public Cliente(String tipo,String nombre, String numeroTelefono){
        this.llamadas = new ArrayList<Llamada>(); 
        this.nombre = nombre;
        this.numeroTelefono = numeroTelefono;
        this.tipo = tipo;
    }
	
	public List<Llamada> getLlamadas() {
		return llamadas;
	}
	public String getNombre() {
		return nombre;
	}
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
    public String getTipo(){
        return tipo;
    }
}

public class ClienteFisico extends Cliente {
    private String dni;

    public ClienteFisico(String nombre, String numeroTelefono,String dni){
        super("fisica",nombre,numeroTelefono);
        this.dni = dni;
    }

    public String getDni(){
        return dni;
    }
}

public class ClienteJuridico extends Cliente {
    private String cuit;

    public ClienteJuridico(String nombre, String numeroTelefono,String cuit){
        super("juridica",nombre,numeroTelefono);
        this.cuit = cuit;
    }

    public String getCuit(){
        return cuit;
    }
}
//Clase Empresa
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

//Clase test
@Test
	void testcalcularMontoTotalLlamadas() {
		Cliente emisorPersonaFisca = sistema.registrarClienteFisico("11555666", "Brendan Eich");
		Cliente remitentePersonaFisica = sistema.registrarClienteFisico("00000001", "Doug Lea");
		Cliente emisorPersonaJuridica = sistema.registrarClienteJuridico("17555222", "Nvidia Corp" );
		Cliente remitentePersonaJuridica = sistema.registrarClienteJuridico("25765432", "Sun Microsystems");
        //..
    }
@Test
	void testAgregarUsuario() {
		assertEquals(this.sistema.cantidadDeClientes(), 0);
		this.sistema.agregarNumeroTelefono("2214444558"); 
		Cliente nuevaPersona = this.sistema.registrarClienteFisico("2444555","Alan Turing");
        //..
    }
```




1. **Mal Olor:** Método calcularMontoTotalLlamadas(...) en clase Empresa:
                    - Long Method (hace muchas cosas en el mismo) que contiene envidia de atributos y mala asignación de responsabilidades

2. **Código a modificar:**
```java
public double calcularMontoTotalLlamadas(Cliente cliente) {
        double montoTotal = 0;
        for (Llamada llamada : cliente.getLlamadas()) {
            double auxMonto = 0;
            if (llamada.getTipoDeLlamada() == "nacional") {
                // el precio es de 3 pesos por segundo más IVA sin adicional por establecer la llamada
                auxMonto += llamada.getDuracion() * 3 + (llamada.getDuracion() * 3 * 0.21);
            } else if (llamada.getTipoDeLlamada() == "internacional") {
                // el precio es de 150 pesos por segundo más IVA más 50 pesos por establecer la llamada
                auxMonto += llamada.getDuracion() * 150 + (llamada.getDuracion() * 150 * 0.21) + 50;
            }

            if (cliente.getTipo() == "fisica") {
                auxMonto -= auxMonto*descuentoFis;
            } else if(cliente.getTipo() == "juridica") {
                auxMonto -= auxMonto*descuentoJur;
            }
            montoTotal += auxMonto;
        }
        return montoTotal;
    }
```

3. **Refactoring:** Extract Method para extraer los metodos calcularMontoLlamada(...) y calcularMontoCliente(...). Luego, Move Method para mover el método calcularMontoLlamada(...) a la clase Llamada y Rename Method calcularMonto(...) 


4. **Resultado:** 
```java
//Clase Empresa
public double calcularMontoTotalLlamadas(Cliente cliente) {
        double montoTotal = 0;
        for (Llamada llamada : cliente.getLlamadas()) {
            double auxMonto = 0;
            
            auxMonto = llamada.calcularMonto(auxMonto);

            auxMonto = calcularMontoCliente(cliente, auxMonto);
            
            montoTotal += auxMonto;
        }
        return montoTotal;
    }
	
	public double calcularMontoCliente(Cliente cliente, double auxMonto) {
		if (cliente.getTipo() == "fisica") {
		    auxMonto -= auxMonto*descuentoFis;
		} else if(cliente.getTipo() == "juridica") {
		    auxMonto -= auxMonto*descuentoJur;
		}
		return auxMonto;
	}
//Clase Llamada
public double calcularMonto(double auxMonto) {
		if (getTipoDeLlamada() == "nacional") {
		    // el precio es de 3 pesos por segundo más IVA sin adicional por establecer la llamada
		    auxMonto += getDuracion() * 3 + (getDuracion() * 3 * 0.21);
		} else if (getTipoDeLlamada() == "internacional") {
		    // el precio es de 150 pesos por segundo más IVA más 50 pesos por establecer la llamada
		    auxMonto += getDuracion() * 150 + (getDuracion() * 150 * 0.21) + 50;
		}
		return auxMonto;
	}

```


1. **Mal Olor:** Método calcularMontoCliente(...) sigue teniendo el mal olor Switch/if statements de antes y no funciona por las modificiaciones anteriores

2. **Código a modificar:**
```java
//Clase Empresa
public double calcularMontoCliente(Cliente cliente, double auxMonto) {
		if (cliente.getTipo() == "fisica") {
		    auxMonto -= auxMonto*descuentoFis;
		} else if(cliente.getTipo() == "juridica") {
		    auxMonto -= auxMonto*descuentoJur;
		}
		return auxMonto;
	}
```

3. **Refactoring:** Extract Method para separar los los compartamientos segun el tipo de Cliente y así moverlo con Move Method a su clase Cliente


4. **Resultado:** 
```java
//Clase Empresa
public double calcularMontoTotalLlamadas(Cliente cliente) {
        double montoTotal = 0;
        for (Llamada llamada : cliente.getLlamadas()) {
            double auxMonto = 0;
            
            auxMonto = llamada.calcularMonto(auxMonto);

            auxMonto = cliente.calcularMonto(auxMonto);
            
            montoTotal += auxMonto;
        }
        return montoTotal;
    }
//Clase Cliente
public double calcularMonto(double auxMonto) {
		if (getTipo() == "fisica") {
		    auxMonto -= auxMonto*Empresa.descuentoFis;
		} else if(getTipo() == "juridica") {
		    auxMonto -= auxMonto*Empresa.descuentoJur;
		}
		return auxMonto;
	}
```

1. **Mal Olor:** Por envidia de atributos de la clase Empresa con los descuentos, cuando hicimos el Move Method llama a la variables de la Empresa rompiendo su encapsulamiento

2. **Código a modificar:**
```java
//Clase Empresa
final static double descuentoJur = 0.15;
final static double descuentoFis = 0;
```
3. **Refactoring:** Remove field -> Muevo los atributos a la clase Cliente

4. **Resultado:** 
```java 
//Clase Cliente
final static double descuentoJur = 0.15;
final static double descuentoFis = 0;
public double calcularMonto(double auxMonto) {
		if (getTipo() == "fisica") {
		    auxMonto -= auxMonto*descuentoFis;
		} else if(getTipo() == "juridica") {
		    auxMonto -= auxMonto*descuentoJur;
		}
		return auxMonto;
	}
```

1. **Mal Olor:** Cada tipo de cliente tiene una manera distinta de resolver el método calcularMonto(...), mala asignación de responsabilidades

2. **Código a modificar:**
```java
//Clase Cliente
final static double descuentoJur = 0.15;
final static double descuentoFis = 0;
public double calcularMonto(double auxMonto) {
		if (getTipo() == "fisica") {
		    auxMonto -= auxMonto*descuentoFis;
		} else if(getTipo() == "juridica") {
		    auxMonto -= auxMonto*descuentoJur;
		}
		return auxMonto;
	}
```
3. **Refactoring:** Replace Conditional with Polymorphism.

4. **Resultado:** 
```java 
//Clase Cliente
public abstract double calcularMonto(double auxMonto);
//Clase Clientejuridico
public double calcularMonto(double auxMonto) {
		return auxMonto -= auxMonto*descuentoJur;
	}
//Clase ClienteFisico
public double calcularMonto(double auxMonto) {
		return auxMonto -= auxMonto*descuentoFis;
	}
```

1. **Mal Olor:** En el método calcularMontoLlamada(...) de la clase Llamada -> Está haciendo "switch statements" 

2. **Código a modificar:**
```java
//Clase Llamada
public double calcularMontoLlamada(double auxMonto) {
		if (getTipoDeLlamada() == "nacional") {
		    // el precio es de 3 pesos por segundo más IVA sin adicional por establecer la llamada
		    auxMonto += getDuracion() * 3 + (getDuracion() * 3 * 0.21);
		} else if (getTipoDeLlamada() == "internacional") {
		    // el precio es de 150 pesos por segundo más IVA más 50 pesos por establecer la llamada
		    auxMonto += getDuracion() * 150 + (getDuracion() * 150 * 0.21) + 50;
		}
		return auxMonto;
	}
```
3. **Refactoring:** Replace Conditional with Polymorphism

4. **Resultado:** 
```java 
//Clase Llamada 
public abstract double calcularMontoLlamada(double auxMonto);
//Clase LlamadaNacional
public class LlamadaNacional extends Llamada{

	public LlamadaNacional(String origen, String destino, int duracion) {
		super("nacional", origen, destino, duracion);
	}

	public double calcularMonto(double auxMonto) {
		// el precio es de 3 pesos por segundo más IVA sin adicional por establecer la llamada
		auxMonto += getDuracion() * 3 + (getDuracion() * 3 * 0.21);
		return auxMonto;
	}
	
}
//Clase llamadaInternacional
public class LlamadaInternacional extends Llamada{

	public LlamadaInternacional(String origen, String destino, int duracion) {
		super("internacional", origen, destino, duracion);
	}

	@Override
	public double calcularMonto(double auxMonto) {
		// el precio es de 150 pesos por segundo más IVA más 50 pesos por establecer la llamada
		auxMonto += getDuracion() * 150 + (getDuracion() * 150 * 0.21) + 50;
		return auxMonto;
	}
}
```

1. **Error:** Debido a lo realizado anteriormente, se genera el error de RegistrarLlamada y se debe realizar un registrarLlamada para cada tipo de llamada. También conlleva a modificar el test.

2. **Código a modificar:**
```java
//Clase Empresa
public Llamada registrarLlamada(Cliente origen, Cliente destino, String tipoLlamada, int duracion) {
        Llamada llamada = new Llamada(tipoLlamada, origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion);
        llamadas.add(llamada);
        origen.getLlamadas().add(llamada);
        return llamada;
    }
//Test
@Test
	void testcalcularMontoTotalLlamadas() {
		Cliente emisorPersonaFisca = sistema.registrarClienteFisico("11555666", "Brendan Eich");
		Cliente remitentePersonaFisica = sistema.registrarClienteFisico("00000001", "Doug Lea");
		Cliente emisorPersonaJuridica = sistema.registrarClienteJuridico("17555222", "Nvidia Corp" );
		Cliente remitentePersonaJuridica = sistema.registrarClienteJuridico("25765432", "Sun Microsystems");

		this.sistema.registrarLlamada(emisorPersonaJuridica, remitentePersonaFisica, "nacional", 10);
		this.sistema.registrarLlamada(emisorPersonaJuridica, remitentePersonaFisica, "internacional", 8);
		this.sistema.registrarLlamada(emisorPersonaJuridica, remitentePersonaJuridica, "nacional", 5);
		this.sistema.registrarLlamada(emisorPersonaJuridica, remitentePersonaJuridica, "internacional", 7);
		this.sistema.registrarLlamada(emisorPersonaFisca, remitentePersonaFisica, "nacional", 15);
		this.sistema.registrarLlamada(emisorPersonaFisca, remitentePersonaFisica, "internacional", 45);
		this.sistema.registrarLlamada(emisorPersonaFisca, remitentePersonaJuridica, "nacional", 13);
		this.sistema.registrarLlamada(emisorPersonaFisca, remitentePersonaJuridica, "internacional", 17);
        //..
    }
```

3. **Codigo modificado:**
```java
//Clase Empresa
public Llamada registrarLlamadaNacional(Cliente origen, Cliente destino, int duracion) {
        Llamada llamada = new LlamadaNacional(origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion);
        llamadas.add(llamada);
        origen.getLlamadas().add(llamada);
        return llamada;
    }
public Llamada registrarLlamadaInternacional(Cliente origen, Cliente destino,int duracion) {
        Llamada llamada = new LlamadaInternacional(origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion);
        llamadas.add(llamada);
        origen.getLlamadas().add(llamada);
        return llamada;
    }
    //Test
@Test
	void testcalcularMontoTotalLlamadas() {
		Cliente emisorPersonaFisca = sistema.registrarClienteFisico("11555666", "Brendan Eich");
		Cliente remitentePersonaFisica = sistema.registrarClienteFisico("00000001", "Doug Lea");
		Cliente emisorPersonaJuridica = sistema.registrarClienteJuridico("17555222", "Nvidia Corp" );
		Cliente remitentePersonaJuridica = sistema.registrarClienteJuridico("25765432", "Sun Microsystems");

		this.sistema.registrarLlamadaNacional(emisorPersonaJuridica, remitentePersonaFisica, 10);
		this.sistema.registrarLlamadaInternacional(emisorPersonaJuridica, remitentePersonaFisica, 8);
		this.sistema.registrarLlamadaNacional(emisorPersonaJuridica, remitentePersonaJuridica, 5);
		this.sistema.registrarLlamadaInternacional(emisorPersonaJuridica, remitentePersonaJuridica, 7);
		this.sistema.registrarLlamadaNacional(emisorPersonaFisca, remitentePersonaFisica, 15);
		this.sistema.registrarLlamadaInternacional(emisorPersonaFisca, remitentePersonaFisica, 45);
		this.sistema.registrarLlamadaNacional(emisorPersonaFisca, remitentePersonaJuridica, 13);
		this.sistema.registrarLlamadaInternacional(emisorPersonaFisca, remitentePersonaJuridica, 17);
        //..
    }
```

1. **Mal Olor:** En el método calcularMontoTotalLlamadas(..) de la clase Empresa, hay una mala asignación de responsabilidad y envidia de atributos, ya que la clase Cliente debe retornarme su monto total de las llamadas

2. **Codigo a modificar:**
```java
//Clase empresa
public double calcularMontoTotalLlamadas(Cliente cliente) {
        double montoTotal = 0;
        for (Llamada llamada : cliente.getLlamadas()) {
            double auxMonto = 0;
            
            auxMonto = llamada.calcularMonto(auxMonto);

            auxMonto = cliente.calcularMonto(auxMonto);
            
            montoTotal += auxMonto;
        }
        return montoTotal;
    }
```

3. **Refactoring:** Extract Method y Move Method

4. **Resultado:** 
```java
//Clase Empresa
public double calcularMontoTotalLlamadas(Cliente cliente) {
		return cliente.calcularMontoTotalLlamadas();
	}

//Clase cliente
public double calcularMontoTotalLlamadas() {
	    double montoTotal = 0;
	    for (Llamada llamada : getLlamadas()) {
	        double auxMonto = 0;
	        
	        auxMonto = llamada.calcularMonto(auxMonto);
	
	        auxMonto = calcularMonto(auxMonto);
	        
	        montoTotal += auxMonto;
	    }
	    return montoTotal;
	}
```


1. **Mal Olor:** Reinventando la rueda en el método calcularMontoTotalLlamadas() de la clase Cliente ya que podemos manejar esto con Streams de manera más eficiente y simple

2. **Código a modificar:**
```java
//Clase Cliente
public double calcularMontoTotalLlamadas() {
	    double montoTotal = 0;
	    for (Llamada llamada : getLlamadas()) {
	        double auxMonto = 0;
	        
	        auxMonto = llamada.calcularMonto(auxMonto);
	
	        auxMonto = calcularMonto(auxMonto);
	        
	        montoTotal += auxMonto;
	    }
	    return montoTotal;
	}
```
3. **Refactoring:** Replace Loop with Pipeline

4. **Resultado:** 
```java
//Clase Cliente
public double calcularMontoTotalLlamadas() {
    return getLlamadas().stream()
            .mapToDouble(llamada -> {
                double auxMonto = 0;
                auxMonto = llamada.calcularMonto(auxMonto);
                return calcularMonto(auxMonto);
            })
            .sum();
}
```

1. **Mal olor:** Para no romper funcionalidades a medida que se iban creando subclases para especificar el tipo de Cliente o Llamada, conservamos el atributo "tipo" en ambas clases.

2. **Código a modificar:**
```java
//Clase Cliente
public abstract class Cliente {
	private List<Llamada> llamadas;
	private String nombre;
	private String numeroTelefono;
    private String tipo;
	final static double descuentoJur = 0.15;
	final static double descuentoFis = 0;
	
	public Cliente(String tipo,String nombre, String numeroTelefono){
        this.llamadas = new ArrayList<Llamada>(); 
        this.nombre = nombre;
        this.numeroTelefono = numeroTelefono;
        this.tipo = tipo;
    }
	
	public List<Llamada> getLlamadas() {
		return llamadas;
	}
	public String getNombre() {
		return nombre;
	}
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
    public String getTipo(){
        return tipo;
    }
    //..
}
//Clase ClienteFisico
    public ClienteFisico(String nombre, String numeroTelefono,String dni){
        super("fisica",nombre,numeroTelefono);
        this.dni = dni;
    }
//Clase ClienteJurudico
    public ClienteJuridico(String nombre, String numeroTelefono,String cuit){
        super("juridica",nombre,numeroTelefono);
        this.cuit = cuit;
    }
//Clase Llamada
public abstract class Llamada {
	private String tipoDeLlamada;
	private String origen;
	private String destino;
	private int duracion;

	public Llamada(String tipoLlamada, String origen, String destino, int duracion) {
		this.tipoDeLlamada = tipoLlamada;
		this.origen= origen;
		this.destino= destino;
		this.duracion = duracion;
	}

	public String getTipoDeLlamada() {
		return tipoDeLlamada;
	}
    //..
}
//Clase LlamadaNacional
	public LlamadaNacional(String origen, String destino, int duracion) {
		super("nacional", origen, destino, duracion);
	}
//Clase LlamadaInternacional
public LlamadaInternacional(String origen, String destino, int duracion) {
		super("internacional", origen, destino, duracion);
	}

```

3. **Refactoring:** Ya no es necesario por lo que se aplica Remove Field y Remove Method de los getters

4. **Resultado:** 
```java
//Clase Cliente
public abstract class Cliente {
	private List<Llamada> llamadas;
	private String nombre;
	private String numeroTelefono;
	final static double descuentoJur = 0.15;
	final static double descuentoFis = 0;
	
	public Cliente(String nombre, String numeroTelefono){
        this.llamadas = new ArrayList<Llamada>(); 
        this.nombre = nombre;
        this.numeroTelefono = numeroTelefono;
    }
	
	public List<Llamada> getLlamadas() {
		return llamadas;
	}
	public String getNombre() {
		return nombre;
	}
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
    //..
}
//Clase ClienteFisico
    public ClienteFisico(String nombre, String numeroTelefono,String dni){
        super(nombre,numeroTelefono);
        this.dni = dni;
    }
//Clase ClienteJurudico
    public ClienteJuridico(String nombre, String numeroTelefono,String cuit){
        super(nombre,numeroTelefono);
        this.cuit = cuit;
    }
//Clase Llamada
public abstract class Llamada {
	private String origen;
	private String destino;
	private int duracion;

	public Llamada(String origen, String destino, int duracion) {
		this.origen= origen;
		this.destino= destino;
		this.duracion = duracion;
	}
    //..
}
//Clase LlamadaNacional
	public LlamadaNacional(String origen, String destino, int duracion) {
		super(origen, destino, duracion);
	}
//Clase LlamadaInternacional
public LlamadaInternacional(String origen, String destino, int duracion) {
		super(origen, destino, duracion);
	}
```


1. **Mal olor:** Mala asignación de responsabilidad y envidia de atributos en los métodos registrarLlamadaInternacional y registrarLlamadaNacional con respecto a agregar la llamada al cliente origen, esa acción es responsabilidad del cliente.

2. **Código a modificar:**
```java
//Clase Empresa
public Llamada registrarLlamadaNacional(Cliente origen, Cliente destino, int duracion) {
        Llamada llamada = new LlamadaNacional(origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion);
        llamadas.add(llamada);
        origen.getLlamadas().add(llamada); //Esta
        return llamada;
    }
	public Llamada registrarLlamadaInternacional(Cliente origen, Cliente destino,int duracion) {
        Llamada llamada = new LlamadaInternacional(origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion);
        llamadas.add(llamada);
        origen.getLlamadas().add(llamada); //Esta
        return llamada;
    }
```

3. **Refactoring:** Extract Method y Move Method


4. **Resultado:** 
```java
//Clase Empresa
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
//Clase Cliente
public void agregarLlamada(Llamada llamada) {
		getLlamadas().add(llamada);
	}
```
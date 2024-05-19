### 2.1 Empleados

1. indique el mal olor,
2. indique el refactoring que lo corrige, 
3. aplique el refactoring, mostrando el resultado final (código y/o diseño según corresponda). 
4. Si vuelve a encontrar un mal olor, retorne al paso (1). 

```java
public class EmpleadoTemporario {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    public double horasTrabajadas = 0;
    public int cantidadHijos = 0;

public double sueldo() {
return this.sueldoBasico + (this.horasTrabajadas * 500) + (this.cantidadHijos * 1000) - (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPlanta {
	public String nombre;
	public String apellido;
	public double sueldoBasico = 0;
	public int cantidadHijos = 0;

	public double sueldo() {
		return this.sueldoBasico + (this.cantidadHijos * 2000) - (this.sueldoBasico * 0.13);
	}
}

public class EmpleadoPasante {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    
    public double sueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }
}

```

1. **Mal olor**: Nombre del método sueldo() poco descriptivo.

2. **Refactoring**: Rename Method
    1. Cambiar el nombre del método sueldo() por calcularSueldo()

3. **Resultado**:

```java
public class EmpleadoTemporario {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    public double horasTrabajadas = 0;
    public int cantidadHijos = 0;

public double calcularSueldo() {
return this.sueldoBasico + (this.horasTrabajadas * 500) + (this.cantidadHijos * 1000) - (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPlanta {
	public String nombre;
	public String apellido;
	public double sueldoBasico = 0;
	public int cantidadHijos = 0;

	public double calcularSueldo() {
		return this.sueldoBasico + (this.cantidadHijos * 2000) - (this.sueldoBasico * 0.13);
	}
}

public class EmpleadoPasante {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    
    public double calcularSueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }
}

```
1. **Mal Olor**: Declaración de atributo público

2. **Refactoring**: Encapsulate Field
   1. Crea un getter y un setter para el campo.
   2. Encuentra todas las invocaciones del campo. Reemplace el recibo del valor del campo con el getter y reemplace la configuración de nuevos valores del campo con el setter.
   3. Después de que se hayan reemplazado todas las invocaciones de campo, haga que el campo sea privado.

3. **Resultado**:

```java
public class EmpleadoPasante {
    private String nombre;
    private String apellido;
    private double sueldoBasico = 0;
    
    public double calcularSueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public double getSueldoBasico() {
		return sueldoBasico;
	}

	public void setSueldoBasico(double sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}

}

public class EmpleadoPlanta {
	private String nombre;
	private String apellido;
	private double sueldoBasico = 0;
	private int cantidadHijos = 0;

	public double calcularSueldo() {
		return this.sueldoBasico + (this.cantidadHijos * 2000) - (this.sueldoBasico * 0.13);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public double getSueldoBasico() {
		return sueldoBasico;
	}

	public void setSueldoBasico(double sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}

	public int getCantidadHijos() {
		return cantidadHijos;
	}

	public void setCantidadHijos(int cantidadHijos) {
		this.cantidadHijos = cantidadHijos;
	}

}

public class EmpleadoTemporario {
	private String nombre;
	private String apellido;
	private double sueldoBasico = 0;
	private double horasTrabajadas = 0;
	private int cantidadHijos = 0;

	public double calcularSueldo() {
    	return this.sueldoBasico + (this.horasTrabajadas * 500)  + (this.cantidadHijos * 1000) - (this.sueldoBasico * 0.13);
    	  
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public double getSueldoBasico() {
		return sueldoBasico;
	}

	public void setSueldoBasico(double sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}

	public double getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(double horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	public int getCantidadHijos() {
		return cantidadHijos;
	}

	public void setCantidadHijos(int cantidadHijos) {
		this.cantidadHijos = cantidadHijos;
	}

}
```

1. **Mal Olor**: No se provee un constructor para inicializar los atributos de las clases en donde seria mejor que este inicializado el **"sueldoBasico**" en 0 (y **"cantidadHijos**" y **"horasTrabajadas**" en sus respectivas clases)

2. **Refactoring**: -

3. **Resultado**:  

```java
public class EmpleadoPasante {
    private String nombre;
    private String apellido;
    private double sueldoBasico;
    
    
    public EmpleadoPasante(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.sueldoBasico = 0
	}

	public double calcularSueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public double getSueldoBasico() {
		return sueldoBasico;
	}

	public void setSueldoBasico(double sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}
}

public class EmpleadoTemporario  {
    private String nombre;
    private String apellido;
    private double sueldoBasico;
	private double horasTrabajadas;
	private int cantidadHijos;


	public EmpleadoTemporario(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.sueldoBasico = 0;
		this.horasTrabajadas = 0;
		this.cantidadHijos = 0;
	}

	public double calcularSueldo() {
    	return this.sueldoBasico + (this.horasTrabajadas * 500)  + (this.cantidadHijos * 1000) - (this.sueldoBasico * 0.13);
    	  
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public double getSueldoBasico() {
		return sueldoBasico;
	}

	public void setSueldoBasico(double sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}

	public double getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(double horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	public int getCantidadHijos() {
		return cantidadHijos;
	}

	public void setCantidadHijos(int cantidadHijos) {
		this.cantidadHijos = cantidadHijos;
	}

}

public class EmpleadoPlanta  {
	private String nombre;
	private String apellido;
	private double sueldoBasico;
	private int cantidadHijos;
	
	public EmpleadoPlanta(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.sueldoBasico = 0;
		this.cantidadHijos = 0;
	}

	public double calcularSueldo() {
		return this.sueldoBasico + (this.cantidadHijos * 2000) - (this.sueldoBasico * 0.13);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public double getSueldoBasico() {
		return sueldoBasico;
	}

	public void setSueldoBasico(double sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}

	public int getCantidadHijos() {
		return cantidadHijos;
	}

	public void setCantidadHijos(int cantidadHijos) {
		this.cantidadHijos = cantidadHijos;
	}
	
	
}

```


1. **Mal Olor:** Clases "EmpleadoPasante", "EmpleadoPlanta" y "EmpleadoTemporario" con métodos y campos parecidos

2. **Refactoring:** Extract SuperClass
    1. Creo una superclase abstracta.
    2. Utilizo _"Pull Up Field"_, _"Pull Up Method"_, and _"Pull Up Constructor Body"_ para mover la funcionalidad común a una superclase. Comience con los campos, ya que además de los campos comunes necesitará mover los campos que se usan en los métodos comunes.
   3. Busque lugares en el código del cliente donde el uso de subclases se pueda reemplazar con su nueva clase (como en las declaraciones de tipo).


3. **Resultado**:

```java
public abstract class Empleado {

	protected String nombre;
	protected String apellido;
	protected double sueldoBasico;

    public Empleado(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.sueldoBasico = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public double getSueldoBasico() {
		return sueldoBasico;
	}

	public void setSueldoBasico(double sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}
	
	public abstract double calcularSueldo();


}

public class EmpleadoPasante extends Empleado{
	
    public EmpleadoPasante(String nombre, String apellido, double sueldoBasico) {
		super(nombre, apellido, sueldoBasico);
	}

	public double calcularSueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoTemporario extends Empleado{
	private double horasTrabajadas;
	private int cantidadHijos;

	public EmpleadoTemporario(String nombre, String apellido) {
		super(nombre,apellido);
		this.horasTrabajadas = 0;
		this.cantidadHijos = 0;
	}

	public double calcularSueldo() {
    	return this.sueldoBasico + (this.horasTrabajadas * 500)  + (this.cantidadHijos * 1000) - (this.sueldoBasico * 0.13);
    	  
	}

	public double getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(double horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	public int getCantidadHijos() {
		return cantidadHijos;
	}

	public void setCantidadHijos(int cantidadHijos) {
		this.cantidadHijos = cantidadHijos;
	}

}

public class EmpleadoPlanta extends Empleado{
	private int cantidadHijos;
	
    public EmpleadoPlanta(String nombre, String apellido) {
		super(nombre, apellido);
		this.cantidadHijos = 0;
	}

	public double calcularSueldo() {
		return this.sueldoBasico + (this.cantidadHijos * 2000) - (this.sueldoBasico * 0.13);
	}

	public int getCantidadHijos() {
		return cantidadHijos;
	}

	public void setCantidadHijos(int cantidadHijos) {
		this.cantidadHijos = cantidadHijos;
	}
	
	
}
```

1. **Mal Olor**: El valor de los campos nombre y apellido debe establecerse solo cuando se crea

2. **Refactoring**: Remove Setting Method
   1. El valor de un campo debe poder cambiarse solo en el constructor. Si el constructor no contiene un parámetro para establecer el valor, agregue uno. 
   2. Encuentra todas las llamadas de setter.
      1. Si una llamada de setter se encuentra justo después de una llamada para el constructor de la clase actual, mueva su argumento a la llamada del constructor y elimine el setter. 
      2. Reemplace las llamadas de setter en el constructor con acceso directo al campo.
   3. Eliminar el setter.

3. **Resultado**:

```java
public abstract class Empleado {

	protected String nombre;
	protected String apellido;
	protected double sueldoBasico;

    public Empleado(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.sueldoBasico = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public double getSueldoBasico() {
		return sueldoBasico;
	}

	public void setSueldoBasico(double sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}
	
	public abstract double calcularSueldo();


}

public class EmpleadoPasante extends Empleado{
	
    public EmpleadoPasante(String nombre, String apellido) {
		super(nombre, apellido);
	}

	public double calcularSueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoTemporario extends Empleado{
	private double horasTrabajadas;
	private int cantidadHijos;

	public EmpleadoTemporario(String nombre, String apellido) {
		super(nombre,apellido);
		this.horasTrabajadas = 0;
		this.cantidadHijos = 0;
	}

	public double calcularSueldo() {
    	return this.sueldoBasico + (this.horasTrabajadas * 500)  + (this.cantidadHijos * 1000) - (this.sueldoBasico * 0.13);
    	  
	}

	public double getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(double horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}

	public int getCantidadHijos() {
		return cantidadHijos;
	}

	public void setCantidadHijos(int cantidadHijos) {
		this.cantidadHijos = cantidadHijos;
	}

}

public class EmpleadoPlanta extends Empleado{
	private int cantidadHijos;
	
    public EmpleadoPlanta(String nombre, String apellido) {
		super(nombre, apellido);
		this.cantidadHijos = 0;
	}

	public double calcularSueldo() {
		return this.sueldoBasico + (this.cantidadHijos * 2000) - (this.sueldoBasico * 0.13);
	}

	public int getCantidadHijos() {
		return cantidadHijos;
	}

	public void setCantidadHijos(int cantidadHijos) {
		this.cantidadHijos = cantidadHijos;
	}
	
	
}
```

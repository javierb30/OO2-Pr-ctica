**Malos olores:**
    
    - Clase Cliente --> 
        *1. "llamadas" tipo público, rompe encapsulamiento debe ser de tipo privado 
        *2. Falta de un constructor, para inicializar correctamente la clase Cliente y para evitar romper el encapsulamiento con los gets y sets de las variables privadas (solo dejar los necesarios, ej: numeros de telefonos).
        *3. Tipo de cliente : va a tener que ser herencia

    - Clase Llamada -->
        *1. TipoDeLlamada: va a tener que ser herencia
        *2. Chequear lo de los getters por encapsulamiento

    - Clase GestorNumerosDisponibles -->
        *1. Falta de constructor que esta inicializando los valores de las V.I. al momento de su declaración.
        2. En el método "obtenerNumeroLibre()" es un  long method que va a provocar un strategy seguramente
        3. 

    - Clase Empresa -->
        1. Falta constructor
        2. Inicializa las VI en su declaración
        *3. Las variables estáticas generan la herencia en el tipo de cliente
        4. Metodo "agregarNumeroDeTelefono" es una clase envidiosa y tiene  mala asignación de responsabilidad, eso debe ejecutarse en la clase GestorNumerosDisponibles, además, el parámetro "str" es poco descriptivo
        *5. Método "registrarUsuario" tiene que ser polimorfico yq ue no dependa del tipo, se tiene que ejecutar de manera dinámica abstrayendose del tipo de cliente que corresponda.
        *6. Metodo "registrarLlamada" el Cliente debe tener un método que agregue la llamada
        *7. Método "calcualrMontoTotalLlamada" clase envidiosa y mala asignación de responsabildiades, debe delegar lo que hace a la clase CLiente dependiendo el tipo de llamada (hay delegaciones a ambas clases en distintas partes)
        *8. Método "getGestorNumeros" poco descriptivo


package guia09;

import java.time.LocalDateTime; //importo la clase que maneja fechas

//importo mis notaciones que generan automáticamente los getters y setters
import lombok.Getter;
import lombok.Setter;

//una "notación" en Java se implementa con el "@"
@Setter
@Getter

public class Persona {
	
	//el modificador "private" nos servirá para sólo acceder a estos atributos mediante los métodos
	
	private String nombre;
	private String apellido;
	private LocalDateTime fechaNacimiento;
	
	//solamente escribo los atributos, los getters y setters ya son implícitos gracias a Lombok

}

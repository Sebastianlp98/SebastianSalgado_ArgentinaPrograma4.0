package guia05.ej01; //paquete donde se encuentran mis clases (en mi caso)

import java.time.*; //importo las clases para manejar fechas

public class Persona {
	
	//el "private" es para que sólo la misma clase pueda acceder a sus atributos
	private String nombre;
	private String apellido;
	private LocalDateTime fechaDeNacimiento;

	public int edad() { //método público ya que podemos acceder a él desde cualquier parte
		LocalDateTime fechaActual=LocalDateTime.now(); //tomo la fecha actual
		int edad = fechaActual.compareTo(fechaDeNacimiento); //comparo la fecha actual con la de nacimiento
		int diaNacimiento=fechaDeNacimiento.getDayOfYear(); //tomo el número de día de nacimiento en el año
		int diaActual=fechaActual.getDayOfYear(); //el valor va desde 1 a 365 (366 en bisiesto)
		if(diaNacimiento>diaActual) { //en caso de que todavía no haya pasado ese día, quito un año
			edad-=1; //ya que si el día actual es menor o igual, no se resta un año
		} //porque todavía no fue el cumpleaños
		return edad; //devuelvo la edad
	}
	
	//en vez de utilizar el constructor por defecto "Persona()"
	public Persona(String nombre, String apellido) { //creo un constructor para crear un objeto "Persona"
		this.nombre=nombre;
		this.apellido=apellido;
	}
	
	public void setFechaDeNacimiento(LocalDateTime fecha) { //setter para poder calcular la edad del objeto
		this.fechaDeNacimiento=fecha; //ya que no podríamos calcular la edad si no tenemos una fecha de nacimiento
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
}

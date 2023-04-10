package guia05.ej01; //paquete donde se encuentran mis clases (en mi caso es éste)

import java.time.LocalDate; //importo la clase "LocalDate"
import java.time.*; //o podría importar todas las clases del paquete (gracias al "*")
//entonces el "import" anterior no haría falta

public class Producto {

	//el "private" es para que sólo la misma clase pueda acceder a sus atributos
	private String nombre;
	private String codigo;
	//private float precio;
	private String descripcion;
	private LocalDate fechaAlta;
	private Integer pesoKg;
	private Double precio; //sustituyo la variable "precio" anterior
	//sigo la API descripta en la presentación de la clase
	
	//constante que es común a la clase, por lo que para utilizarla no hace falta instanciar un objeto
	private static final Double minPrecio = 0.1;
	
	public Producto() {
		//constructor vacío, si no hubiera sobrecarga sería el por defecto (es decir, no ejecuta código alguno)
	}
	
	//sobrecarga de constructores (es decir, existen dos o más constructores)
	public Producto(String nombre) { //constructor que recibe el nombre por parámetro
		this.nombre=nombre; //"this" hace referencia al objeto mismo determinado
		this.fechaAlta=LocalDate.now(); //tomo la fecha actual al momento de crearse el objeto
		this.precio=minPrecio; //le doy un precio predeterminado mínimo
	}
	/*
	public float costoFinal (int cantCuotas) { //método público ya que podemos acceder a él desde cualquier parte
		float costo = cantCuotas*precio; //calculo el costo
		return costo; //devuelvo la información solicitada a través del método
	}
	*/
	public String getNombre() { //getter que devuelve el nombre del objeto pertinente que llama al método
		return this.nombre; //ya que la variable "nombre" es privada, devolvemos la misma para que pueda ser accedida
	}
	
	public String getDescripcion() {
		return this.descripcion; //hacemos lo mismo con la descripción
	} //recordemos que el "String" que devuelve será diferente según que valores almacenados tenga cada objeto único
	
	//"void" quiere decir que el método no devuelve ningún tipo de dato o clase, sino que realiza una acción
	public void setDescripcion(String descripcion) { //le pasamos un texto por parámetro
		this.descripcion=descripcion; //le damos un valor a la descripcion
	} //pasa lo mismo que los getters, seteamos sin acceder al atributo directamente
	
	public Double getPrecio() { //creo un getter del precio para poder utilizar ese dato
		return this.precio; //recuenden que "Double" es diferente a "double"
	} //el primero es una clase y el segundo un tipo de dato primitivo
	
	public void setPrecio(Double precio) {
		this.precio=precio;
	}
	
}

package guia07;

public class Producto {
	
	//los atributos quedan encapsulados ("private")
	private String nombre;
	private float precioUnitario;
	
	//creo un constructor que recibe los parámetros necesarios para determinar un objeto de clase "Producto"
	public Producto(String nombre, float precioUnitario) {
		this.nombre=nombre;
		this.precioUnitario=precioUnitario;
	}

	//creo los getters o setters que necesite
	public String getNombre() {
		return nombre;
	}

	public float getPrecioUnitario() {
		return precioUnitario;
	}

}

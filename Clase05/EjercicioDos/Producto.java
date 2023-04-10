package guia05.ej02;

public class Producto {
	
	private String nombre;
	private float precioUnitario;
	private float cantidad; //la cantidad podría ser decimal por si compramos algo por kilo, por ejemplo
	
	public Producto(String nombre, float precioUnitario, float cantidad) {
		//para crear un producto necesito estos datos sí o sí, por eso dejamos un sólo constructor
		this.nombre=nombre;
		this.precioUnitario=precioUnitario;
		this.cantidad=cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public float getPrecioUnitario() {
		return precioUnitario;
	}

	public float getCantidad() {
		return cantidad;
	}
	
}

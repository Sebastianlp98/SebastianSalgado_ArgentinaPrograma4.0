package guia05.ej01;

import java.time.*; //importo las clases para manejar fechas

public class Carrito {
	
	private Persona persona;
	private Producto producto1;
	private Producto producto2;
	private Producto producto3;
	private LocalDateTime fechaCompra; //"LocalDateTime" es la clase que representa fechas y horarios
	
	public float costoFinal() {
		
		Double producto1precio=producto1.getPrecio(); //utilizo el getter que me devuelve un "Double"
		float precio1=producto1precio.floatValue(); //convierto ese objeto de clase "Double" a "float"
		Double producto2precio=producto2.getPrecio();
		float precio2=producto2precio.floatValue();
		Double producto3precio=producto3.getPrecio();
		float precio3=producto3precio.floatValue();
		
		return precio1+precio2+precio3; //sumo los precios de cada producto y devuelvo el resultado
		
	}

	public void setProducto1(Producto producto1) {
		this.producto1 = producto1;
	}

	public void setProducto2(Producto producto2) {
		this.producto2 = producto2;
	}

	public void setProducto3(Producto producto3) {
		this.producto3 = producto3;
	}

}

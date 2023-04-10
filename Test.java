package guia05.ej01;

import java.time.*;

public class Test { //clase "Test" para probar el funcionamiento de las clases y sus relaciones

	public static void main(String[] args) { //método "main" estático ("static") que ejecuta Java
		// TODO Auto-generated method stub
		
		Persona persona1 = new Persona("Lionel","Messi");
		//el método "of" nos devuelve un "LocalDateTime" de la fecha que asignemos
		//los dos últimos parámetros son la hora y minutos
		LocalDateTime fechaDeNacimientoDeMessi = LocalDateTime.of(1987,6,24,0,0);
		persona1.setFechaDeNacimiento(fechaDeNacimientoDeMessi);
		int edadDeMessi = persona1.edad();
		System.out.println("Edad de "+persona1.getNombre()+" es:");
		System.out.println(edadDeMessi);
		
		Persona persona2 = new Persona("Ezequiel","Frossasco");
		LocalDateTime miCumple = LocalDateTime.of(2003, 1, 3, 0, 0);
		persona2.setFechaDeNacimiento(miCumple);
		System.out.println("Edad de "+persona2.getNombre()+" es:");
		System.out.println(persona2.edad());
		
		Producto prod = new Producto("Atún"); //instancio mi objeto de la clase "Producto"
		
		Producto producto1 = new Producto("Colágeno");
		producto1.setPrecio(24.0);
		
		Producto producto2 = new Producto("Chomba");
		producto2.setPrecio(60.05);
		
		Carrito nuestroCarrito = new Carrito();
		nuestroCarrito.setProducto1(producto1);
		nuestroCarrito.setProducto2(producto2);
		nuestroCarrito.setProducto3(prod);
		
		float precioFinal = nuestroCarrito.costoFinal();
		System.out.println("Precio final: "+precioFinal);
		
	}

}

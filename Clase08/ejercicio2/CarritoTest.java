package guia08.ej02;

import org.junit.jupiter.api.Test;

class CarritoTest {
	
	private Carrito compra = new Carrito();
	private Descuento descuentoNulo = new DescuentoFijo(0);
	
	@Test
	void testNulo1() {
		//creamos el bloque "try-catch" para atrapar posibles excepciones
		try {
			//intentaremos imprimir el valor de nuestro carrito, que se encuentra vacío
			//ya que no hemos insertado ningún item en él
			System.out.println(compra.precio(descuentoNulo)); //en esta línea de código ocurre la excepción
			//entonces no se ejecutaría (no se imprime el valor del carrito, que es 0)
		} catch (ExcepcionCarritoPrecioNulo excepcionAtrapada) { //con el "catch" atrapamos la excepción en caso de que ocurra
			//dentro de los paréntesis indicamos el tipo de excepción que se debe atrapar
			//con "excepcionAtrapada" estamos almacenado el objeto de clase "ExcepcionCarritoPrecioNulo"
			//el cual se instancia cuando el método "precio" lanza la excepción de ese tipo
			System.out.println("EL PRECIO DEL CARRITO "+compra.toString()+" ES NULO!"); //informamos por consola
		}
		//el programa seguiría su curso en caso de haber código luego del "try-catch"
	}
	
	@Test
	void testNulo2() {
		//probamos con un producto de precio 0
		Producto producto = new Producto("Producto sin precio", 0);
		ItemCarrito item = new ItemCarrito(producto);
		compra.addItemCarrito(item);
		try {
			System.out.println(compra.precio(descuentoNulo));
		} catch (ExcepcionCarritoPrecioNulo excepcionAtrapada) {
			System.out.println("EL PRECIO DEL CARRITO "+compra.toString()+" ES NULO!");
		}
	}
	
	@Test
	void testNegativo1() {
		//creamos el item y lo agregamos al Carrito "compra"
		Producto producto = new Producto("Coca-Cola", 400);
		ItemCarrito item = new ItemCarrito(producto);
		compra.addItemCarrito(item);
		//creamos un descuento de valor superior al total de nuestro carrito (500>400)
		Descuento descuento = new DescuentoFijo(500);
		try {
			//intentamos aplicar el descuento a nuestra compra
			System.out.println(compra.precio(descuento));
		} catch (ExcepcionCarritoPrecioNegativo excepcionAtrapada) {
			//ahora cambiamos el tipo de excepción que queremos controlar
			System.out.println("EL PRECIO DEL CARRITO "+compra.toString()+" ES NEGATIVO!");
			//informamos sobre el error ocurrido
		}
	}
	
	@Test
	void testNegativo2() {
		//probamos con un producto de precio negativo (esto se puede hacer ya que el precio es de tipo "int")
		Producto producto = new Producto("Producto con precio negativo", (-100));
		ItemCarrito item = new ItemCarrito(producto);
		compra.addItemCarrito(item);
		try {
			System.out.println(compra.precio(descuentoNulo));
		} catch (ExcepcionCarritoPrecioNegativo excepcionAtrapada) {
			System.out.println("EL PRECIO DEL CARRITO "+compra.toString()+" ES NEGATIVO!");
		}
	}

}

package guia07.ej03;

import guia07.ej02.*; //importamos las clases del ejercicio anterior
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarritoTest {
	
	//inicializamos las variables de instancia para poder acceder en los tests!
	
	private int cantidadItemsCarrito=3;
	private Carrito compra = new Carrito(cantidadItemsCarrito);
	
	private Producto producto1 = new Producto("Coca-Cola", 400);
	private Producto producto2 = new Producto("Nesquik", 250);
	private Producto producto3 = new Producto("Avena", 500);
	
	private ItemCarrito item1 = new ItemCarrito(producto1);
	private ItemCarrito item2 = new ItemCarrito(producto2);
	private ItemCarrito item3 = new ItemCarrito(producto3);
	
	private Descuento descuentoFijo = new DescuentoFijo(100);
	private Descuento descuentoPorcentaje = new DescuentoPorcentaje(25);
	private Descuento descuentoPorcentajeConTope;
	//a este último no lo instancio acá para probar el mensaje de tope de descuento luego
	
	private Descuento descuentoNulo = new DescuentoFijo(0); //utilizo algún descuento para que sea nulo
	//no puedo directamente inicializar un objeto de clase "Descuento" porque esta clase es abstracta
	//LAS CLASES ABSTRACTAS NO PUEDEN SER INSTANCIADAS
	//podría también utilizar "DescuentoPorcentaje" o "DescuentoPorcentajeConTope"
	
	//creo mis atributos para luego comprobar
	private float obtenido;
	private float esperado;
	
	@BeforeEach
	void antesDeCadaTest() {
		compra.addItemCarrito(item1);
		compra.addItemCarrito(item2);
		compra.addItemCarrito(item3);
		item1.setCantidadProducto(5);
		item2.setCantidadProducto(8);
		item3.setCantidadProducto(4);
		obtenido=compra.precio(descuentoNulo); //si hago los cálculos me da 6000
		esperado=6000;
	}
	
	@AfterEach
	void despuesDeCadaTest() {
		//para todos los tests tendré que tener una igualdad entre lo que espero y lo que me da el precio final
		assertEquals(esperado, obtenido);
	}
	
	@Test
	void test1() {
	} //aquí solamente compruebo si "Carrito" funciona correctamente: "antesDeCadaTest()"
	
	@Test
	void test2() {
		ItemCarrito itemNuevo; //variable que usaré para crear diferentes items
		for(int i=0;i<10;i++) { //voy a repetir el código siguiente unas 10 veces
			itemNuevo = new ItemCarrito(producto1);
			compra.addItemCarrito(itemNuevo);
			itemNuevo = new ItemCarrito(producto2);
			compra.addItemCarrito(itemNuevo);
			itemNuevo = new ItemCarrito(producto3);
			compra.addItemCarrito(itemNuevo);
		}
		//el carrito en un principio ya se encuetra lleno, por lo cual recibo los mensajes de alerta por consola!
	}
	
	@Test
	void test3() {
		//en este test intento agregar otros items con un carrito más extenso
		
		Carrito otraCompra = new Carrito(5);
		
		Producto producto4 = new Producto("Quilmes", 300);
		Producto producto5 = new Producto("Camisa", 3000);
		
		ItemCarrito item4 = new ItemCarrito(producto4);
		ItemCarrito item5 = new ItemCarrito(producto5);
		
		otraCompra.addItemCarrito(item1);
		otraCompra.addItemCarrito(item2);
		otraCompra.addItemCarrito(item3);
		otraCompra.addItemCarrito(item4);
		otraCompra.addItemCarrito(item5);
		
		item4.setCantidadProducto(10);
		
		obtenido=otraCompra.precio(descuentoNulo);
		esperado=12000;
	}
	
	@Test
	void testDescuentoFijo() {
		obtenido=compra.precio(descuentoFijo);
		//6000-100=5900
		esperado=5900;
	}
	
	@Test
	void testDescuentoPorcentaje() {
		obtenido=compra.precio(descuentoPorcentaje);
		//25% de 6000 es 1500
		//6000-1500=4500
		esperado=4500;
	}
	
	@Test
	void testDescuentoPorcentajeConTope() {
		//creo un descuento con tope pasandóle un valor mayor al que acepta
		//debería salir un mensaje de alerta por consola y tendría que aplicar el tope
		descuentoPorcentajeConTope = new DescuentoPorcentajeConTope(100, 50);
		obtenido=compra.precio(descuentoPorcentajeConTope);
		//50% de 6000 es 3000
		//6000-3000=3000
		esperado=3000;
	}

}

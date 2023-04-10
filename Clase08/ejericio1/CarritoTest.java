package guia08.ej01;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//importamos las librerías para leer archivos

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarritoTest {
	
	private Carrito compra = new Carrito(); //ya NO iniciamos el carrito con una longitud determinada!
	
	//estos precios serían los correctos! (para "testArchivo")
	private Producto producto1 = new Producto("Coca-Cola", 400);
	private Producto producto2 = new Producto("Nesquik", 250);
	private Producto producto3 = new Producto("Avena", 500);
	
	private ItemCarrito item1 = new ItemCarrito(producto1);
	private ItemCarrito item2 = new ItemCarrito(producto2);
	private ItemCarrito item3 = new ItemCarrito(producto3);
	
	private Descuento descuentoFijo = new DescuentoFijo(100);
	private Descuento descuentoPorcentaje = new DescuentoPorcentaje(25);
	private Descuento descuentoPorcentajeConTope;
	
	private Descuento descuentoNulo = new DescuentoFijo(0);
	
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
		obtenido=compra.precio(descuentoNulo);
		esperado=6000;
	}
	
	@AfterEach
	void despuesDeCadaTest() {
		assertEquals(esperado, obtenido);
	}
	
	@Test
	void test1() {
	}
	
	@Test
	void test2() {
		ItemCarrito itemNuevo;
		for(int i=0;i<1000;i++) { //ahora podemos agregar la cantidad de items que se nos ocurra!
			itemNuevo = new ItemCarrito(producto1);
			compra.addItemCarrito(itemNuevo);
			itemNuevo = new ItemCarrito(producto2);
			compra.addItemCarrito(itemNuevo);
			itemNuevo = new ItemCarrito(producto3);
			compra.addItemCarrito(itemNuevo);
		}
		obtenido=compra.precio(descuentoNulo); //cambiamos el valor de lo obtenido en el carrito
		//esto debería generar un fallo, ya que los items se agregaron correctamente!
		//para que no ocurra un fallo, debería calcularse el total esperado nuevamente, teniendo en cuenta los items nuevos
		System.out.println("El valor total del carrito "+compra.toString()+" es "+obtenido+" y se espera que sea "+esperado);
	}
	
	@Test
	void test3() {
		Carrito otraCompra = new Carrito();
		
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
		esperado=5900;
	}
	
	@Test
	void testDescuentoPorcentaje() {
		obtenido=compra.precio(descuentoPorcentaje);
		esperado=4500;
	}
	
	@Test
	void testDescuentoPorcentajeConTope() {
		descuentoPorcentajeConTope = new DescuentoPorcentajeConTope(100, 50);
		obtenido=compra.precio(descuentoPorcentajeConTope);
		esperado=3000;
	}
	
	@Test
	void testArchivo() {
		Path rutaArchivo = Paths.get("src\\guia08\\ej01\\archivoItems.txt"); //tomamos la ruta del archivo
		compra = new Carrito(); //resteamos nuestro carrito (ahora se encuentra vacío)
		try {
			for(String lineaArchivo:Files.readAllLines(rutaArchivo)) {
				String campos[] = lineaArchivo.split(";"); //ahora los items están separados por ";"
				
				//guardo la información de cada línea del archivo
				String nombre=campos[0]; 
				float precioUnitario=Float.parseFloat(campos[1]); 
				int cantidad=Integer.parseInt(campos[2]); //la cantidad se expresa en enteros
				
				//con esa información creo el producto y su correspondiente item
				Producto productoNuevo = new Producto(nombre, precioUnitario);
				ItemCarrito itemNuevo = new ItemCarrito(productoNuevo);
				itemNuevo.setCantidadProducto(cantidad);
				
				//finalmente agrego ese item (y producto) a nuestro carrito
				compra.addItemCarrito(itemNuevo);
			}
			obtenido=compra.precio(descuentoNulo); //obtenemos el total del archivo leído para luego compararlo con lo esperado
			//informamos al usuario lo que se obtuvo y lo que se esperaba
			System.out.println("El valor total del carrito "+compra.toString()+" es "+obtenido+" y se espera que sea "+esperado);
			//para el ejemplo, da un valor diferente! por lo que ocurre un fallo en el test
			//pueden probar con cambiar los datos del archivo de texto, indicando los precios correctos
		} catch (IOException e) {
			//en caso de que no se encuentra el archivo
			//ocurre una excepción "IOException"
			//que es una excepción chequeada (ajena al programador)
			//por lo cual Java nos obliga a implementar un "try-catch"
			e.printStackTrace(); //en caso de error, se imprime en consola una descripción del error (excepción) ocurrido
		}
	}
	
	@Test
	void testArchivo2() { //vamos a probar que puede leer cualquier cantidad de items
		//el test dará un fallo ya que no calcularemos el esperado correctamente
		//pero funcionará ya que se leerán todos los items del archivo
		Path rutaArchivo = Paths.get("src\\guia08\\ej01\\archivoItems2.txt");
		compra = new Carrito();
		try {
			for(String lineaArchivo:Files.readAllLines(rutaArchivo)) {
				String campos[] = lineaArchivo.split(";");
				
				String nombre=campos[0]; 
				float precioUnitario=Float.parseFloat(campos[1]); 
				int cantidad=Integer.parseInt(campos[2]);
				
				Producto productoNuevo = new Producto(nombre, precioUnitario);
				ItemCarrito itemNuevo = new ItemCarrito(productoNuevo);
				itemNuevo.setCantidadProducto(cantidad);
				
				compra.addItemCarrito(itemNuevo);
			}
			obtenido=compra.precio(descuentoNulo);
			System.out.println("El valor total del carrito "+compra.toString()+" es "+obtenido+" y se espera que sea "+esperado);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

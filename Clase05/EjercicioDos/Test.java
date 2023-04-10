package guia05.ej02;

import java.io.IOException;
import java.nio.file.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//tomo la ruta relativa del archivo
		//esta ruta empieza por "ArgProg2023", es decir el proyecto en el que estamos trabajando
		//en mi caso la ruta completa sería:
		//C:\eclipse\workspace\ArgProg2023\src\guia05\ej02\archivoProductos.txt
		Path rutaArchivo = Paths.get("src\\guia05\\ej02\\archivoProductos.txt");
		
		//creamos nuestro carrito que utilizaremos
		int capacidadCarrito = 10; //le damos una capacidad máxima
		Carrito carrito = new Carrito(capacidadCarrito); //instanciamos un objeto de clase "Carrito"
		
		try {
			for(String lineaArchivo:Files.readAllLines(rutaArchivo)) { //leemos el archivo de los productos
				//creamos una variable dónde se guadarán los campos del archivo
				//con "campo" nos referimos a cada dato de un producto
				//en este caso los campos son: nombre, precio unitario, cantidad
				//y estos campos están separados por una coma
				//por lo cual en el vector "campos" obtendremos el nombre, precio y cantidad de un producto
				String campos[] = lineaArchivo.split(","); //observando el archivo nos podremos dar cuenta
				String nombre=campos[0]; //el primer campo que aparece es el nombre
				float precioUnitario=Float.parseFloat(campos[1]); //convertimos el texto en un número decimal
				float cantidad=Float.parseFloat(campos[2]); //hacemos lo mismo con la cantidad
				//una vez tengamos los datos, generamos nuestro objeto de clase "Producto"
				Producto producto = new Producto(nombre,precioUnitario,cantidad);
				//cuando ya tengamos el producto dado, lo guardamos en el carrito
				carrito.agregarProducto(producto);
				//esto se repite por cada producto (línea de texto) del archivo
			}
			//una vez guardamos todos los "Producto" en nuestro "Carrito"
			System.out.println(carrito); //imprimimos el contenido del mismo!
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

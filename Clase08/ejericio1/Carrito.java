package guia08.ej01;

//importo las clases de las colecciones a utilizar
import java.util.ArrayList;
import java.util.List;

public class Carrito {

	private List<ItemCarrito> items; //intercambio el array estático anterior por un objeto de clase "List"
	
	public Carrito() { //ya no necesito pasar un parámetro para indicar la capacidad máxima
		items=new ArrayList<ItemCarrito>(); //simplemente instancio un "ArrayList" que no tendrá límite alguno
		//nótese que "ArrayList" es del tipo "List" que declaramos anteriormente, por eso podemos instanciar el "ArrayList"
	}
	
	public void addItemCarrito(ItemCarrito item) {
		items.add(item); //simplemente añadimos el item
	}
	
	public float precio(Descuento descuento) {
		float total=0;
		for(ItemCarrito item:items) { //utilizaremos un bulce "for-each" que funciona mejor con colecciones
			//por cada "item" del List "items", obtenemos su precio
			total+=item.precio(); //sumamos el precio al total sin descuento
		}
		return descuento.precioConDescuento(total);
	}
	
}

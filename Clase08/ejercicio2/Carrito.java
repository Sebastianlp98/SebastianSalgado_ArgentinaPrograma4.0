package guia08.ej02;

import java.util.ArrayList;
import java.util.List;

public class Carrito {

	private List<ItemCarrito> items;
	
	public Carrito() {
		items=new ArrayList<ItemCarrito>();
	}
	
	public void addItemCarrito(ItemCarrito item) {
		items.add(item);
	}
	
	public float precio(Descuento descuento) throws ExcepcionCarritoPrecioNulo, ExcepcionCarritoPrecioNegativo {
		//indicamos con "throws" que el método puede lanzar alguna de estas excepciones
		//para indicar varias excepciones simplemente las separamos con "," luego del "throws"
		float total=0;
		for(ItemCarrito item:items) {
			total+=item.precio();
		}
		if(total==0) {
			//si el total no fue modificado, es decir, permaneció en 0
			throw new ExcepcionCarritoPrecioNulo(); //lanzamos la excepción correspondiente
		}else if(total<0 || descuento.precioConDescuento(total)<0) {
			//en caso de que el total haya sido negativo
			//o el total con descuento aplicado quede en negativo
			throw new ExcepcionCarritoPrecioNegativo(); //lanzamos la excepción correspondiente
		}
		//si no se lanza ninguna excepción, el código ejecuta nuestro "return"
		//en caso de que ocurra alguna excepción, este "return" quedaría sin ejecutar
		return descuento.precioConDescuento(total);
	}
	
}

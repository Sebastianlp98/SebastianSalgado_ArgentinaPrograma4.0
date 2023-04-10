package guia07.ej02;

public class Carrito {

	private ItemCarrito[] items;
	private int itemsAgregados;
	
	public Carrito(int cantidadDeItemsMaximos) {
		this.items=new ItemCarrito[cantidadDeItemsMaximos];
		this.itemsAgregados=0;
	}
	
	public void addItemCarrito(ItemCarrito item) {
		if(itemsAgregados==items.length) { 
			System.out.println("NO HAY MÁS ESPACIO DISPONIBLE EN EL CARRITO " + this.toString());
		}else {
			items[itemsAgregados]=item;
			itemsAgregados++;
		}
	}
	
	//ahora recibiremos un objeto de clase "Descuento" para calcular el precio final
	//recordemos que un "DescuentoFijo" o un "DescuentoPorcentaje" son un "Descuento"
	//nos podemos dar cuenta de ello si nos fijamos en la relación de herencia
	//la clase padre (o "la que está por arriba") tiene dos clases hijos (que son más específicas)
	//por esta razón el método podrá recibir un objeto "DescuentoFijo" o uno "DescuentoPorcentaje"
	public float precio(Descuento descuento) {
		float total=0;
		for(int i=0;i<itemsAgregados;i++) {
			total+=items[i].precio();
		}
		//ahora no le restamos el descuento al total en este método
		//sino que le delegamos la tarea al objeto de clase "Descuento"
		//utilizamos el método que devuelve el precio con el descuento aplicado
		return descuento.precioConDescuento(total);
		//aquí entra en acción el polimorfismo
		//ya que el método "precioConDescuento" tiene diferente comportamiento
		//dependiendo de si tratamos con "DescuentoFijo", con "DescuentoPorcentaje" o con "DescuentoPorcentajeConTope"
		//(no olvidemos que estos tres siguen siendo de tipo "Descuento" por su herencia!)
	}
	
}

package guia07;

public class Carrito {

	private ItemCarrito[] items; //array dónde guardaremos los items
	private int itemsAgregados; //variable que nos indica cuántos items tenemos almacenados
	
	public Carrito(int cantidadDeItemsMaximos) {
		this.items=new ItemCarrito[cantidadDeItemsMaximos];
		this.itemsAgregados=0; //en un inicio, el carrito se encuentra vacío
	}
	
	//método para agregar un item al carrito, por parámetro recibe ese item
	public void addItemCarrito(ItemCarrito item) {
		if(itemsAgregados==items.length) { //en caso de que los items agregados sean igual a la cantidad máxima permitida
			System.out.println("NO HAY MÁS ESPACIO DISPONIBLE EN EL CARRITO " + this.toString());
		}else {
			items[itemsAgregados]=item; //agregamos el item, recordemos que en un principio itemsAgregados==0
			itemsAgregados++; //contamos ese item agregado
			//así, la siguiente vez que se llame al método
			//guardaremos el item en la posición siguiente
		}
	}
	
	public float precio() {
		float total=0;
		for(int i=0;i<itemsAgregados;i++) {
			total+=items[i].precio(); //tomamos el precio de cada item, y lo sumamos en un acumulador
		}
		return total;
	}
	
}

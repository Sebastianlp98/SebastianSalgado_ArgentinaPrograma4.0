package guia07;

public class ItemCarrito {
	
	private Producto producto;
	private int cantidadProducto;
	
	//por paramétro pasamos un objeto de tipo "Producto" gracias a una variable "producto"
	public ItemCarrito(Producto producto) {
		this.producto=producto; //la variable de instancia del objeto "ItemCarrito" toma al objeto "Producto" que le pasamos
		this.cantidadProducto=1; //al agregar un producto, por defecto deberemos tener al menos uno de él
	}
	
	//método que nos permite cambiar la cantidad de un producto dado
	public void setCantidadProducto(int cantidadProducto) {
		if(cantidadProducto<=0) { //no tendría sentido una cantidad negativa o nula
			System.out.println("LA CANTIDAD DEL PRODUCTO: "+ this.producto.getNombre() + ", NO PUEDE SER NEGATIVA O NULA!");
		}else {
			this.cantidadProducto=cantidadProducto; //cambiamos la cantidad
		}
	}
	
	//método que nos devuelve el precio de un item determinado
	public float precio() {
		//podemos retornar directamente sin utilizar una variable
		return (this.producto.getPrecioUnitario()*this.cantidadProducto);
	}

}

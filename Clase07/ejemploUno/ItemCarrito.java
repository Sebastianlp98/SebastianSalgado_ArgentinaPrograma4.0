package guia07.ej01;

public class ItemCarrito {
	
	private Producto producto;
	private int cantidadProducto;
	
	public ItemCarrito(Producto producto) {
		this.producto=producto; 
		this.cantidadProducto=1;
	}
	
	public void setCantidadProducto(int cantidadProducto) {
		if(cantidadProducto<=0) { 
			System.out.println("LA CANTIDAD DEL PRODUCTO: "+ this.producto.getNombre() + ", NO PUEDE SER NEGATIVA O NULA!");
		}else {
			this.cantidadProducto=cantidadProducto; 
		}
	}
	
	public float precio() {
		return (this.producto.getPrecioUnitario()*this.cantidadProducto);
	}

}

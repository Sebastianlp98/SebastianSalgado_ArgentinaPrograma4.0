package guia07.ej01;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int cantidadItemsCarrito=3;
		Carrito compra = new Carrito(cantidadItemsCarrito);
		
		Producto producto1 = new Producto("Coca-Cola", 400);
		Producto producto2 = new Producto("Nesquik", 250);
		Producto producto3 = new Producto("Avena", 500);
		
		ItemCarrito item1 = new ItemCarrito(producto1);
		ItemCarrito item2 = new ItemCarrito(producto2);
		ItemCarrito item3 = new ItemCarrito(producto3);
		
		compra.addItemCarrito(item1);
		System.out.println(compra.precio('%', 25));
		compra.addItemCarrito(item2);
		item2.setCantidadProducto(3);
		System.out.println(compra.precio('$', 100));
		compra.addItemCarrito(item3);
		item3.setCantidadProducto(5);
		System.out.println(compra.precio('f', 500));
		
	}

}

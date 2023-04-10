package guia05.ej02;

public class Carrito {
	
	private Producto productos[]; //vector donde almacenaré los productos
	
	private int productosGuardados; //variable que me sirve para saber cuántos productos hay
	
	public Carrito(int cantidadProductos) { //creo un único constructor que me pide la cantidad de productos a guardar
		productos=new Producto[cantidadProductos]; //le doy dimensión a mi array
		productosGuardados=0; //en un principio, tendremos el carrito vacío
	}
	
	public String toString() { //sobreescribimos el método toString que es común a TODAS las clases
		String texto=""; //creamos la salida que se irá formando
		//daremos un formato para ver la salida solicitada en la consigna
		texto+="cant	precioUnitario	producto"; //indicamos cada campo con su nombre
		for(int i=0;i<productosGuardados;i++) { //recorremos todos los Productos del carrito
			texto+="\n"; //salto de línea para dar formato
			float cant = productos[i].getCantidad(); //tomamos la cantidad
			float precioUnitario = productos[i].getPrecioUnitario(); //tomamos el precio unitario
			String producto=productos[i].getNombre(); //tomamos el nombre del producto
			texto+=cant+"	"+precioUnitario+"		"+producto; //agregamos los valores dinámicamente
			//así no tendremos que agregar los productos uno a uno
			//este código funciona para cualquier cantidad de productos!
		}
		texto+="\n"; //salto de línea para dar formato
		texto+="	carrito.precio() == "+this.precio(); //ponemos el precio final
		//recordemos que "this" hace referencia al mismo objeto que llama al método
		//por ende "carrito" estaría llamando su propio método
		
		return texto;
	}
	
	public float precio() {
		float precioTotal=0;
		
		for(int i=0;i<productosGuardados;i++) { //recorremos los productos guardados
			//no necesariamente tendremos todo el array lleno, sólo nos interesa los que tenemos guardados
			Producto producto = productos[i]; //tomamos el producto pertinente
			float precioUnitario=producto.getPrecioUnitario(); //guardamos su precio unitario correspondiente
			float cantidad=producto.getCantidad(); //y la cantidad que tenemos de ese producto determinado
			precioTotal+=(precioUnitario*cantidad); //al total vamos sumando el precio unitario por la cantidad
		}
		
		return precioTotal;
	}
	
	public void agregarProducto(Producto producto) {
		if(productosGuardados==productos.length) { //en caso de tener el carrito lleno
			System.out.println("Carrito lleno! no puede agregar más productos, lo siento...");
		}else { //pero si tenemos espacio, metemos el producto pasado por parámetro
			for(int i=0;i<productos.length;i++) { //recorremos el array para verificar dónde hay espacio
				if(productos[i]==null) { //en caso de encontrar lugar
					//"null" nos indica que no hay un objeto de clase "Producto" en esa posición
					//ya que al crear el vector vacío, todos los elementos son "null" por defecto
					productos[i]=producto; //guardamos el producto en el array
					productosGuardados++; //registramos el producto ingresado
					break; //dejamos de buscar espacio, saliendo del recorrido del "for"
				}
			}
		}
	}	
	
}

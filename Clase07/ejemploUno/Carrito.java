package guia07.ej01;

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
	
	//para realizar un descuento sobre el carrito
	//debemos especificar el tipo y el valor del descuento
	public float precio(char tipoDescuento, float valorDescuento) {
		float total=0;
		for(int i=0;i<itemsAgregados;i++) {
			total+=items[i].precio();
		} //realizamos la suma del total comúnmente
		if(tipoDescuento=='%') { //si el descuento es porcentual
			valorDescuento/=100; //dividimos entre 100 para luego aplicar la fórmula más sencillamente
			total-=total*valorDescuento; //aplicamos la fórmula del porcentaje y se lo restamos al total
		}else if(tipoDescuento=='$') { //si el descuento es fijo
			total-=valorDescuento; //simplemente los restamos
		}else { //en caso de ingresar mal el tipo de descuento, lo informamos por consola
			System.out.println("EN "+this.toString()+" NO SE APLICÓ DESCUENTO ALGUNO");
		}
		return total;
	}
	
	//en caso de no querer descuento, dejamos el método anterior (habiendo sobrecarga de método "precio")
	public float precio() {
		float total=0;
		for(int i=0;i<itemsAgregados;i++) {
			total+=items[i].precio();
		}
		return total;
	}
	
}

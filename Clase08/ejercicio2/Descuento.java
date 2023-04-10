package guia08.ej02;

public abstract class Descuento {
	
	protected float valorDescuento;
	
	public Descuento(float valorDescuento) {
		this.valorDescuento=valorDescuento;
	}
	
	public float getValorDescuento() {
		return this.valorDescuento;
	}
	
	public abstract float precioConDescuento(float precioSinDescuento);

}

package guia08.ej01;

public class DescuentoFijo extends Descuento {

	public DescuentoFijo(float valorDescuento) {
		super(valorDescuento);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float precioConDescuento(float precioSinDescuento) {
		// TODO Auto-generated method stub
		return (precioSinDescuento-this.getValorDescuento());
	}

}

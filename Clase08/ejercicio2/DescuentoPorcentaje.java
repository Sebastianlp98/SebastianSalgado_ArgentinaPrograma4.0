package guia08.ej02;

public class DescuentoPorcentaje extends Descuento {

	public DescuentoPorcentaje(float valorDescuento) {
		super(valorDescuento);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float precioConDescuento(float precioSinDescuento) {
		// TODO Auto-generated method stub
		float porcentajeDelPrecio=(precioSinDescuento)*(this.getValorDescuento()/100);
		return (precioSinDescuento-porcentajeDelPrecio);
	}

}

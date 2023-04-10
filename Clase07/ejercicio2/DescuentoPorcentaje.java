package guia07.ej02;

public class DescuentoPorcentaje extends Descuento {

	public DescuentoPorcentaje(float valorDescuento) {
		super(valorDescuento); //seteamos el descuento, que debería estar entre el 0% hasta un 100%
		// TODO Auto-generated constructor stub
	}

	@Override
	public float precioConDescuento(float precioSinDescuento) {
		// TODO Auto-generated method stub
		float porcentajeDelPrecio=(precioSinDescuento)*(this.getValorDescuento()/100);
		//calculamos el porcentaje del precio que se debe restar
		return (precioSinDescuento-porcentajeDelPrecio);
		//y devolvemos el precio final
	}

}

package guia07.ej02;

public class DescuentoFijo extends Descuento {
	//como vemos el "extends" indica que esta clase "DescuentoFijo" hereda de la clase "Descuento"

	public DescuentoFijo(float valorDescuento) {
		//se deberá crear un constructor para esta clase
		//este constructor tiene que recibir los parámetros del constructor de su clase padre!
		//por lo que luego llamaremos a su constructor padre mediante la instrucción "super(...)"
		//sería lo mismo que hacer "Descuento(valorDescuento)"
		super(valorDescuento); //Descuento(valorDescuento)==super(valorDescuento)
		// TODO Auto-generated constructor stub
	}

	//"Override" significa que sobreescribimos (sustituimos) al método de la clase padre
	//esto lo hacemos para establecer un comportamiento propio de la clase "DescuentoFijo"
	@Override
	public float precioConDescuento(float precioSinDescuento) {
		// TODO Auto-generated method stub
		return (precioSinDescuento-this.getValorDescuento());
		//cómo vemos, el método es el mismo, sólo que aquí se implementa código
		//simplemente restamos el precio inicial menos el descuento fijo!
	}

}

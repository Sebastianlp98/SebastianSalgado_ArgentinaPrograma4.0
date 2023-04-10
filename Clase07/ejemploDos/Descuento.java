package guia07.ej02;

public abstract class Descuento {
	//una clase es abstracta si tiene al menos un método abstracto
	//un método abstracto es aquél el cual no tiene ni debe tener código implementado
	//entonces en una interfaz, todos sus métodos son abstractos
	
	//el modificador "protected" le permite acceso a las subclases de esta clase!
	//es decir, podremos modificar este valor desde las subclases sin aplicar un setter
	protected float valorDescuento; //guardaremos el valor de nuestro descuento
	//este valor se debe guardar por el simple hecho de ser un descuento
	//sin tener en cuenta si es fijo o por porcentaje
	
	public Descuento(float valorDescuento) {
		//constructor que debe recibir el valor del descuento
		//esto lo hacemos para que luego no se pueda cambiar el valor de un descuento creado
		this.valorDescuento=valorDescuento;
	}
	
	public float getValorDescuento() {
		return this.valorDescuento;
	}
	
	//este método nos devolverá un precio con descuento aplicado
	//por ello deberemos pasar el precio original para luego retornar el resultado
	//nótese que al ser un método abstracto no lleva las llaves: "{" "}"
	//esto se debe a que no implementaremos el código (o comportamiento) en esta clase
	//sino que lo haremos en sus clases hijo!
	public abstract float precioConDescuento(float precioSinDescuento);

}

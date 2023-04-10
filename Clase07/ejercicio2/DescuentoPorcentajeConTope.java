package guia07.ej02;

public class DescuentoPorcentajeConTope extends DescuentoPorcentaje {
	
	//para este caso, agregaremos un parámetro al constructor
	//en él recibiremos el tope requerido
	public DescuentoPorcentajeConTope(float valorDescuento, float topeDescuento) {
		//necesariamente deberemos pasar el valor del descuento, ya que el constructor padre así lo solicita
		super(valorDescuento); //invocamos al constructor padre
		//este tiene que ejecutarse antes de cualquier otra acción dentro del constructor
		//por eso luego verificamos que el valor no supere al tope especificado
		// TODO Auto-generated constructor stub
		if(valorDescuento>topeDescuento) { //en caso de que el valor supere al tope
			System.out.println("EL VALOR EN EL DESCUENTO " + this.toString() + " SUPERA EL TOPE");
			this.valorDescuento=topeDescuento; //cambiamos ese valor por el tope que se tuvo en cuenta
			//recordemos que podemos acceder a esta variable de instancia ya que cuenta con el modificador "protected"
		}
	}

}

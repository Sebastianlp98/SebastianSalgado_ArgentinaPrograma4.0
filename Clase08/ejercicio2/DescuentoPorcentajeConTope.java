package guia08.ej02;

public class DescuentoPorcentajeConTope extends DescuentoPorcentaje {
	
	public DescuentoPorcentajeConTope(float valorDescuento, float topeDescuento) {
		super(valorDescuento);
		// TODO Auto-generated constructor stub
		if(valorDescuento>topeDescuento) {
			System.out.println("EL VALOR EN EL DESCUENTO " + this.toString() + " SUPERA EL TOPE");
			this.valorDescuento=topeDescuento;
		}
	}

}

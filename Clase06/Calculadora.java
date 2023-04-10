package guia06;

public class Calculadora {

	public double sumar(double unNumero, double otroNumero) {
		//podemos retornar simplemente la operación, sin crear una variable nueva
		return unNumero+otroNumero;
	}
	
	public double restar(double unNumero, double otroNumero) {
		return unNumero-otroNumero;
	}
	
	public double multiplicar(double unNumero, double otroNumero) {
		return unNumero*otroNumero;
	}
	
	public double dividir(double unNumero, double otroNumero) {
		//aunque también podemos devolver una variable, que utilizaremos para operar
		double resultado=0;
		if(otroNumero==0) { //evitaremos que ocurra un error al dividir entre cero
			System.out.println("NO PODEMOS DIVIDIR ENTRE 0");
		}else { //en caso de ingresarse correctamente los números, operamos
			resultado=unNumero/otroNumero;
		}
		return resultado;
	}
	
}

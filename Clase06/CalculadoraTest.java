package guia06;

//automaticamente (usando Eclipse) se importan los paquetes necesarios para el test
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach; //paquete necesario para ejecutar algo antes de cada test
import org.junit.jupiter.api.Test; //paquete necesario para ejecutar un test

class CalculadoraTest {
	//creamos una clase con el mismo nombre que la clase a testear junto con la palabra "Test"
	
	//declaramos atributos que utilizaremos
	Calculadora miCalculadora;
	double miResultado;
	double numeroEsperado;
	
	//"@BeforeEach" nos sirve para ejecutar un código antes de cada test único
	@BeforeEach
	void paraCadaTestHacer() {
		miCalculadora=new Calculadora(); //instanciamos un objeto de clase "Calculadora" para probar sus métodos
	}
	
	//iniciamos un test, para ello debemos escribir "@Test" antes de una prueba
	@Test
	void primerTest() { //el test deberá ser de tipo "void" y su nombre puede ser el que deseemos
		miResultado=miCalculadora.multiplicar(80, 3); //realizamos la multiplicación
		numeroEsperado=240; //tengo en cuenta que número espero
		assertEquals(numeroEsperado, miResultado);
		//"assertEquals" es un método que indica si dos valores comparables son iguales
		//en caso de que lo sean, el test es correcto
		//en caso de que sean diferentes, el test fallará ya que no se obtuvo lo esperado
	}
	
	@Test
	void segundoTest() {
		double miSuma=miCalculadora.sumar(150, 180); //creo una variable auxiliar para guardar la suma
		miResultado=miCalculadora.dividir(miSuma, 3); //divido entre 3
		numeroEsperado=110; //espero un número
		assertEquals(numeroEsperado, miResultado); //verifico si son iguales
	}
	
	@Test
	void tercerTest() {
		miResultado=miCalculadora.restar(90, 50);
		//puedo ahorrarme el crear otra variable utilizando solamente "miResultado"
		//así el resultado de la resta se guarda en esta variable
		//que luego cambiará su valor al realizar la multiplicación
		//utilizando su valor actual (el de la resta) y 15
		miResultado=miCalculadora.multiplicar(miResultado, 15);
		numeroEsperado=605; //número que esperemos que no dé
		assertNotEquals(numeroEsperado, miResultado);
		//"assertNotEquals" será correcto en caso de que los dos valores sean diferentes
		//por lo tanto fallará si son valores iguales
		//en este caso falla si "numeroEsperado" tiene un valor de 600
	}
	
	@Test
	void cuartoTest() {
		miResultado=miCalculadora.sumar(70, 40);
		miResultado=miCalculadora.multiplicar(miResultado, 25);
		numeroEsperado=2700;
		//numeroEsperado=2750;
		assertNotEquals(numeroEsperado, miResultado);
	}
	
}

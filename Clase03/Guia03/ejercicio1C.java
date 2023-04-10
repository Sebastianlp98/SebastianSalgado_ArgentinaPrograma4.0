public class ej01c {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double[] array1= {12.56,43,90.76};
		System.out.println(sumarMayoresA(13,array1));
		System.out.println(sumarMayoresA(90,array1));
		
		double[] array2= {5,10,25,30,70,45};
		System.out.println(sumarMayoresA(25, array2));
		
	}

	//dado un vector de números, y un número X, que sume todos los números > X y
	//retorne el resultado
	static double sumarMayoresA(double numeroX, double[] array) {
		double resultado=0; //iniciamos acumulador
		for(int i=0;i<array.length;i++) { //recorremos todos los números
			if(array[i]>numeroX) { //si un número de nuestro array es mayor al número parámetro
				//resultado=resultado+array[i];
				//la expresion de arriba es la misma que la de abajo
				resultado+=array[i]; //lo sumamos al acumulador
			}
		}
		return resultado; //devolvemos el resultado
	}
	
}

public class ej01b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int longitud = 42;
		int rango = 100;
		int[] arrayAleatorio = new int[longitud];
		for(int i=0;i<arrayAleatorio.length;i++) {
			int numeroAleatorio = (int) (Math.random()*rango);
			//System.out.println(numeroAleatorio);
			arrayAleatorio[i]=numeroAleatorio;
		}
		System.out.println(imprimirArray(arrayAleatorio));
		arrayAleatorio=ordenarNumerosBurbuja(true,arrayAleatorio);
		System.out.println(imprimirArray(arrayAleatorio));
		arrayAleatorio=ordenarNumerosBurbuja(false,arrayAleatorio);
		System.out.println(imprimirArray(arrayAleatorio));
		
		int[] arrayNumeros1 = new int[] {12,18,9};
		int[] arrayOrdenado1 = ordenarNumerosBurbuja(true,arrayNumeros1);
		System.out.println(imprimirArray(arrayOrdenado1));
		//System.out.println(arrayOrdenado1);
		
		int[] arrayNumeros2 = {78,22,86};
		int[] arrayOrdenado2 = ordenarNumerosBurbuja(false,arrayNumeros2);
		System.out.println(imprimirArray(arrayOrdenado2));
		//System.out.println(arrayOrdenado2);
		
	}
	
	// Dados 3 números y un orden (ascendente o decreciente) que ordene los
	// mismos y los retorne en un vector de 3
	static int[] ordenarNumerosBurbuja(boolean ascendente, int[] numeros) {
		//el boolean nos sirve para determinar el orden deseado
		//y además le pasamos el vector a ordenar
		int cantidadDeNumeros=numeros.length; //obtenemos la longitud del vector de los números
		for(int i=0;i<cantidadDeNumeros;i++) { //iteramos según los números ordenados que haya, por lo que empezamos en 0
			for(int j=0;j<(cantidadDeNumeros-1-i);j++) { //recorremos los números del vector, sin incluir los ordenados
				//en este caso es (cantidadDeNumeros-1-i) ya que iremos accediendo al número siguiente,
				//por lo cual, restamos 1 para no superar la dimension del vector
				//y restamos "i", ya que indica los números que han sido ordenados
				//entonces, para no recorrer de más, acortamos el rango del recorrido
				if(ascendente) { //orden ascendente
					if(numeros[j]>numeros[j+1]) { //evaluamos si el número siguiente es mayor
						int numeroMayor = numeros[j]; //usamos una variable auxiliar para guardar el número mayor
						numeros[j]=numeros[j+1]; //sustituimos el mayor por el menor
						numeros[j+1]=numeroMayor; //ponemos el mayor delante
					}
				}else { //orden descendente
					if(numeros[j]<numeros[j+1]) { //evaluamos si el número siguiente es menor
						int numeroMenor = numeros[j]; //usamos una variable auxiliar para guardar el número menor
						numeros[j]=numeros[j+1]; //sustituimos el menor por el mayor
						numeros[j+1]=numeroMenor; //ponemos el menor delante
					}
				}
			}
		}
		return numeros; //devolvemos el vector ya ordenado
	}
	
	//método para ver el contenido del array
	static String imprimirArray(int[] array) { //formato: {int, int, int}
		String texto="{"; //agregamos la llave inicial
		for(int i=0;i<array.length;i++) { //recorremos nuestros números
			texto=texto+array[i]; //agregamos esos números al String
			if(i!=(array.length-1)) { //en caso de que no sea el último número
				texto=texto+", "; //debemos agregar una coma seguida de un espacio
			}
		}
		texto+="}"; //agregamos la llave final
		return texto; //devolvemos el String
	}
	
}

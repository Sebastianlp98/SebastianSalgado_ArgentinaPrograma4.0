import java.util.*; //con el "*" importo todas las clases de este paquete "util", donde se encuentra "Scanner"

public class ej01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		//a.
		System.out.println("\n-------------PUNTO A-------------\n");
		int[] numerosA= {56,2,25};
		String letra="a"; //en este caso decidí usar "String" y no "char"
		System.out.println(imprimirArray(ordenarNumerosBurbuja(letra, numerosA)));
		
		//b.
		System.out.println("\n-------------PUNTO B-------------\n");
		int longitudVector;
		Scanner lecturaPorConsola = new Scanner(System.in); //creo la entrada de datos por consola
		while(true) { //bucle para pedir la longitud del vector
			try { //intentamos pedirla
				System.out.println("Ingrese longitud del vector: ");
				longitudVector = lecturaPorConsola.nextInt(); //pedimos un número entero
				if(longitudVector<0) { //si nos ingresan un entero negativo
					System.out.println("No se puede tener una longitud negativa!!!");
					lecturaPorConsola=new Scanner(System.in); //creamos otra entrada para pedir un entero válido
				}else {
					break; //en caso de obtener un entero válido, rompemos el bucle infinito
				}
			}catch(Exception error) { //pero si ocurre un error, o sea no se ingresa un número entero ("int")
				//si ingresamos un "long" también daría error!
				System.out.println("Valor inválido, pruebe de nuevo...");
				lecturaPorConsola=new Scanner(System.in); //creamos una nueva entrada para que se asigne el valor nuevamente
			}
		}
		int[] numerosB= new int[longitudVector];
		int numeroIngresado;
		for(int i=0;i<numerosB.length;i++) {
			while(true) { //entramos en un bucle infinito, por si no se ingresa un número entero
				try { //el "try" ejecuta el código
					System.out.println("Ingrese el número Nº "+(i+1)+": "); //solicitamos el número al usuario
					numeroIngresado = lecturaPorConsola.nextInt(); //guardamos el número entero en una variable
					break; //si se ingresa un número entero, salimos del bucle infinito
				}catch(Exception error) { //si ocurre un error, el "catch" evita que el programa caiga
					System.out.println("Debes ingresar un número entero!!!"); //informamos al usuario de la situación
					lecturaPorConsola=new Scanner(System.in); //creamos otra entrada de datos
					//si no hicieramos esto, el programa estaría leyendo una y otra vez la entrada errónea anterior
					//por lo cual el bucle quedaría iterando infinitamente
				}
			}
			numerosB[i]=numeroIngresado; //y guardamos el número en el vector
		}
		while(true) { //entramos en un bucle infinito hasta que se lea una letra aceptada
			System.out.println("Ingrese el orden (A/D): "); //pedimos una "A" o una "D"
			letra=lecturaPorConsola.next(); //tomamos la letra como "String"
			if(letra.equalsIgnoreCase("a")||letra.equalsIgnoreCase("d")) { //si es una "A" o una "D"
				break; //salimos del bucle infinito
			}else { //sino le informamos al usuario que el texto ingresado no es válido
				System.out.println("Error! el texto ingresado no es aceptado...");
			}
		}
		System.out.println(imprimirArray(ordenarNumerosBurbuja(letra, numerosB)));
		
		//c.
		System.out.println("\n-------------PUNTO C-------------\n");
		System.out.println("--------------");
		System.out.println("PRIMER CASO");
		realizarTarea(new int[] {12,45,9,32},"a"); //primero, probamos pasando todos los datos
		System.out.println("--------------");
		System.out.println("SEGUNDO CASO");
		realizarTarea(new int[] {},"d"); //segundo, solo pasamos el orden
		System.out.println("--------------");
		System.out.println("TERCER CASO");
		realizarTarea(new int[] {12,45,9,32},""); //tercero, solo pasamos el vector
		System.out.println("--------------");
		System.out.println("CUARTO CASO");
		realizarTarea(new int[] {},""); //cuarto, pedimos todo al usuario
		//gracias a esta función nos ahorramos un montón de líneas de código!!!
	}
	
	static void realizarTarea(int[] numeros, String orden) {
		//todo el código anterior, lo ponemos en un método
		//así podremos reutilizar este código más cómodamente
		//pediremos un vector de enteros, si se ingresa con longitud 0,
		//deberemos ingresar la longitud y los números correspondientes
		//el orden también será requerido
		//si no se pasa el orden, lo pediremos por consola
		if(numeros.length==0) { //en caso de tener un vector totalmente vacío
			//pediremos la longitud como hicimos en el punto anterior (reutilizando el código)
			int longitudVector;
			Scanner lecturaPorConsola = new Scanner(System.in);
			while(true) {
				try {
					System.out.println("Ingrese longitud del vector: ");
					longitudVector = lecturaPorConsola.nextInt();
					if(longitudVector<0) {
						System.out.println("No se puede tener una longitud negativa!!!");
						lecturaPorConsola=new Scanner(System.in);
					}else {
						break;
					}
				}catch(Exception error) {
					System.out.println("Valor inválido, pruebe de nuevo...");
					lecturaPorConsola=new Scanner(System.in);
				}
			}
			numeros= new int[longitudVector];
			//después de tener la longitud, pediremos los números
			int numeroIngresado;
			for(int i=0;i<numeros.length;i++) {
				while(true) {
					try {
						System.out.println("Ingrese el número Nº "+(i+1)+": ");
						numeroIngresado = lecturaPorConsola.nextInt();
						break;
					}catch(Exception error) {
						System.out.println("Debes ingresar un número entero!!!");
						lecturaPorConsola=new Scanner(System.in);
					}
				}
				numeros[i]=numeroIngresado;
			}
		}
		if(!(orden.equalsIgnoreCase("a")||orden.equalsIgnoreCase("d"))) {
			//si el "String" "orden" no es una "a" o una "d", lo solicitaremos por consola (reutilizando código)
			//!(orden.equalsIgnoreCase("a")||orden.equalsIgnoreCase("d"))
			//en esa condición estamos negando si alguno de los dos es cierto
			//por lo cual si "orden" es alguna de las dos letras, se torna "false" y el "if" no se ejecuta
			Scanner lecturaPorConsola = new Scanner(System.in);
			while(true) {
				System.out.println("Ingrese el orden (A/D): ");
				orden=lecturaPorConsola.next(); //nótese que deberemos cambiar la orden que se pasó como parámetro
				if(orden.equalsIgnoreCase("a")||orden.equalsIgnoreCase("d")) {
					break;
				}else {
					System.out.println("Error! el texto ingresado no es aceptado...");
				}
			}
		}
		//luego de todo, imprimimos el array ordenado
		//nótese que esta acción se ejecuta hubieramos o no tenido los datos desde un principio sin pedirlos
		System.out.println(imprimirArray(ordenarNumerosBurbuja(orden, numeros)));
	}
	
	static int[] ordenarNumerosBurbuja(String ascendente, int[] numeros) {
		int cantidadDeNumeros=numeros.length;
		for(int i=0;i<cantidadDeNumeros;i++) {
			for(int j=0;j<(cantidadDeNumeros-1-i);j++) {
				if(ascendente.equalsIgnoreCase("a")) { //"IgnoreCase" significa que ignora si es mayúscula o minúscula
					if(numeros[j]>numeros[j+1]) {
						int numeroMayor = numeros[j];
						numeros[j]=numeros[j+1];
						numeros[j+1]=numeroMayor;
					}
				}else if(ascendente.equalsIgnoreCase("d")) {
					if(numeros[j]<numeros[j+1]) {
						int numeroMenor = numeros[j];
						numeros[j]=numeros[j+1];
						numeros[j+1]=numeroMenor;
					}
				}
			}
		}
		return numeros;
	}
	
	static String imprimirArray(int[] array) {
		String texto="{";
		for(int i=0;i<array.length;i++) {
			texto=texto+array[i];
			if(i!=(array.length-1)) {
				texto=texto+", ";
			}
		}
		texto+="}";
		return texto;
	}

}

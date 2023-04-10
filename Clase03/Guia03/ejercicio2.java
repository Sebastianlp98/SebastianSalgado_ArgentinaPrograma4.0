public class ej02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String abc ="abcdefghijklmnñopqrstuvwxyz";
		String ejemplo="hola que tal";
		
		String codificado1=codificar(1,ejemplo,abc);
		System.out.println(codificado1);
		String codificado2=codificar(2,ejemplo,abc);
		System.out.println(codificado2);
		System.out.println("-------------------------------------");
		String decodificado1=decodificar(1,codificado1,abc);
		System.out.println(decodificado1);
		String decodificado2=decodificar(2,codificado2,abc);
		System.out.println(decodificado2);
		System.out.println("-------------------------------------");
		ejemplo="zzz";
		System.out.println(codificar(1,ejemplo,abc));
		ejemplo="yyy";
		System.out.println(codificar(2,ejemplo,abc));
		ejemplo="xxx";
		System.out.println(codificar(3,ejemplo,abc));
		System.out.println("-------------------------------------");
		ejemplo="zzz";
		System.out.println(codificar(1432,ejemplo,abc));
		ejemplo="yyy";
		System.out.println(codificar(1433,ejemplo,abc));
		ejemplo="xxx";
		System.out.println(codificar(1434,ejemplo,abc));
		System.out.println("-------------------------------------");
		ejemplo="aaa";
		System.out.println(decodificar(1,ejemplo,abc));
		ejemplo="aaa";
		System.out.println(decodificar(2,ejemplo,abc));
		ejemplo="aaa";
		System.out.println(decodificar(3,ejemplo,abc));
		System.out.println("-------------------------------------");
		ejemplo="aaa";
		System.out.println(decodificar(8587,ejemplo,abc));
		ejemplo="aaa";
		System.out.println(decodificar(8588,ejemplo,abc));
		ejemplo="aaa";
		System.out.println(decodificar(8589,ejemplo,abc));
		System.out.println("-------------------------------------");
		
		abc=" ,.áéíóú"+abc+abc.toUpperCase();
		ejemplo="HOLA, ahora también tendremos en cuenta puntos y demás...";
		
		codificado1=codificar(1,ejemplo,abc);
		System.out.println(codificado1);
		codificado2=codificar(2,ejemplo,abc);
		System.out.println(codificado2);
		System.out.println("-------------------------------------");
		decodificado1=decodificar(1,codificado1,abc);
		System.out.println(decodificado1);
		decodificado2=decodificar(2,codificado2,abc);
		System.out.println(decodificado2);
	}

	static String codificar(int desplazamiento, String texto, String abecedario) {
		String resultado=""; //variable donde se almacenerá el mensaje codificado
		int cantidadLetras=abecedario.length(); //almacenamos la cantidad de letras de nuestro abecedario
		//esto nos sirve para que luego no superemos la dimensión del String y dé error
		//ahora obtendremos el desplazamiento real
		while(desplazamiento>=cantidadLetras) { //el desplazamiento se comprende entre 0 y la dimensión del String "abecedario"
			desplazamiento-=cantidadLetras; //vamos obteniendo ese rango
			//por ejemplo, si tenemos un desplazamiento original de 56
			//y el abecedario tiene 27 letras
			//será de la siguiente forma:
			//56-27=29, 29-27=2
			//entonces realmente nos desplazaremos 2 lugares
			//si tuvieramos un desplazamiento original de 27 lugares
			//sería 27-27=0
			//por lo cual volveríamos a la misma letra por la que empezamos
		}
		//System.out.println(desplazamiento);
		for(int i=0;i<texto.length();i++) { //recorremos cada letra de nuestro mensaje sin codificar
			int posicionLetra=-1; //variable donde se almacenará la posición de la letra respecto al abecedario
			//en caso de no existir esta letra en el abecedario
			//nos servirá como bandera para saber si codificamos e insertamos una letra que sí existe en el abecedario
			for(int j=0;j<abecedario.length();j++) { //recorremos cada letra del abecedario dado
				if(texto.charAt(i)==abecedario.charAt(j)) { //encontramos nuestra letra en el abecedario
					posicionLetra=j; //guardamos la posición que ocupa esa letra en el abecedario
					break; //dejamos de buscar en el abecedario
				}
				else if(j==(cantidadLetras-1)){ //en caso de no haber encontrado la letra en el abecedario
					//ya habremos recorrido todas las posiciones del String "abecedario"
					if(desplazamiento==0) { //si no existe desplazamiento
						//dejamos el caracter del mensaje que no hemos encontrado en el abecedario
						resultado+=texto.charAt(i);
					}else { //pero si hay un desplazamiento
						//ponemos el caracter del abecedario correspondiente a la posición del desplazamiento
						//por ejemplo, si el desplazamiento es 1
						//ponemos una letra "a"
						//que se encuentra en la posición 0 del String "abecedario"
						resultado+=abecedario.charAt(desplazamiento-1);
						}
					break; //dejamos de buscar en el abecedario
				}
			}
			if(posicionLetra!=-1) { //en caso de que la letra analizada exista en el abecedario
				//es decir, tiene el valor que nos dió "j", o sea la posición de la letra en el abecedario
				if((posicionLetra+desplazamiento)<cantidadLetras) { //en caso de que no haya un desbordamiento
					//es decir, que la posicion de la letra a cambiar más el desplazamiento
					//es menor que la cantidad de letras del abecedario
					//lo que indica que no sobrepasaremos la dimensión del String "abecedario"
					resultado+=abecedario.charAt(posicionLetra+desplazamiento); //codificamos la letra
					//seleccionando su equivalencia codificada
				}else { //pero si desborda, es decir, se va de la dimensión del String "abecedario"
					//consideramos el desplazamiento como si se repitiera delante el abecedario
					//por ejemplo, "...xyzabc..."
					//así, si tenemos la letra "y"
					//su posición es la "25" dentro del String "abecedario"
					//si hay un desplazamiento de 2, tendremos
					//25+2=27
					//27-27=0
					//abecedario.charAt(0)='a'
					resultado+=abecedario.charAt(posicionLetra+desplazamiento-cantidadLetras);
					}
				}
			}
		return resultado; //devolvemos el mensaje codificado
		}
	
	static String decodificar(int desplazamiento, String texto, String abecedario) {
		//la lógica del desborde es la misma que en el método anterior "codificar"
		//solo que no podremos distinguir qué letras eran espacio u otro símbolo no contemplado en el abecedario
		//que ingresamos al codificar los mensajes
		String resultado="";
		int cantidadLetras=abecedario.length();
		while(desplazamiento>=cantidadLetras) {
			desplazamiento-=cantidadLetras;
		}
		for(int i=0;i<texto.length();i++) {
			int posicionLetra=-1;
			for(int j=0;j<abecedario.length();j++) { 
				if(texto.charAt(i)==abecedario.charAt(j)) { 
					posicionLetra=j; 
				}
				/*else if(j==(cantidadLetras-1)){ 
					if(desplazamiento==0) { 
						resultado+=texto.charAt(i);
					}else { 
						resultado+=abecedario.charAt(desplazamiento-1);
						}
					break; 
				}*/
			}
			//if(posicionLetra!=-1) { 
				if((posicionLetra-desplazamiento+1)>0) { //ahora el desborde se hace hacia la izquierda
					//por lo cual hacemos un desplazamiento negativo
					//el "+1" lo utilizamos ya que si estamos en la posicion 0
					//nos quedaría un índice negativo
					//si tenemos desplazamiento 1:
					//nos daría
					//0-1+1=0
					//por lo cual entra en el "else"
					resultado+=abecedario.charAt(posicionLetra-desplazamiento);
				}else { //en caso que dé negativo (la operación "posicionLetra-desplazamiento")
					//situamos otro abecedario a la izquierda del original, es decir: "...xyzabc..."
					//para que no nos vayamos hacia un índice negativo
					resultado+=abecedario.charAt(posicionLetra-desplazamiento+cantidadLetras);
					}
				//}
			}
		return resultado;
	}
	
}

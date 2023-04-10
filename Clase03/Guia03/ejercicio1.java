public class ej01a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(contarLetra('a',"holaaa"));
		
	}

	//Dado un String y una letra, que cuente la cantidad de apariciones de la letra en
	//el String
	
	static int contarLetra(char letraContada, String texto) {
		int contador=0;
		char letraTexto; //variable que nos sirve para ir almacenando cada char del String, uno por uno
		for(int i=0;i<texto.length();i++) { //recorremos el texto, letra a letra
			letraTexto=texto.charAt(i); //guardamos el char de una posición especifica
			if(letraTexto==letraContada) { //evaluamos ese char con la letra buscada
				contador++; //si son la misma letra, aumentamos el contador en uno
			}
		}
		return contador;
	}
	
}

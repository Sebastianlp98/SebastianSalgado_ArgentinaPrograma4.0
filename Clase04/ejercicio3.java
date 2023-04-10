import java.io.*;
import java.nio.file.*;

public class ej03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//codificacion o decodificacion
		//valor del desplazo
		//archivo entrada
		//archivo salida
		
		args=new String[4]; //tenemos 4 parámetros
		args[0]="C"; //"c" para codificar, "d" para decodificar
		args[1]="1"; //valor del desplazamiento
		args[2]="C:\\eclipse\\workspace\\ARGPROG04\\src\\entrada.txt"; //ruta de entrada
		args[3]="C:\\eclipse\\workspace\\ARGPROG04\\src\\salida.txt"; //ruta de salida
		
		if(verificarParametros(args)) { //proseguimos con el programa si todo está en orden
			
			Path entrada = Paths.get(args[2]); //tomamos la entrada como ruta para iterarlo con el "for"
			Path salida = Paths.get(args[3]); //tomamos la salida como ruta para escribir sobre él luego
			//crearemos una CONSTANTE que determina el abecedario a utilizar
			//"final" indica que es una constante
			//la constantes, por convención, se indican con letras mayúsculas
			final String ABECEDARIO = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ ,.:;-_\\'";
			final int DESPLAZAMIENTO = Integer.parseInt(args[1]); //convertimos el "String" en un "int"
			
			try { //"try-catch" obligatorio al tratar con archivos
				for(String linea:Files.readAllLines(entrada)) { //leemos cada línea de la entrada
					
					String resultado=""; //por cada línea tendremos un resultado nuevo
					
					if(args[0].equalsIgnoreCase("c")) { //codificamos
						resultado=codificar(DESPLAZAMIENTO,linea,ABECEDARIO);
					}else { //decodificamos
						resultado=decodificar(DESPLAZAMIENTO,linea,ABECEDARIO);
					}
					resultado+="\n"; //agregamos un salto de línea para que el resultado se guarde bien
					
					//después debemos guardar el resultado en el archivo de salida
					
					//tomamos la información del texto en bytes
					//ya que para escribir en el archivo deberemos hacerlo
					//es decir, no podemos incrustar el texto como "String" directamente
					byte[] bytesResultado = resultado.getBytes(); //es un vector de tipo "byte"
					
					try { //"try-catch" obligatorio
						//salida: ruta o "Path" del archivo de salida
						//bytesResultado: información a guardar
						//StandardOpenOption.APPEND: constante que indica que el texto debe agregarse al final
						//esta constante nos permite no sobreescribir lo que ya estaba en el archivo
						Files.write(salida, bytesResultado, StandardOpenOption.APPEND);
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	static boolean verificarParametros(String[] args) { //creamos este método para ver si los parámetros son válidos
		//nótese que podemos llamar al parámetro que recibe esta función
		//con un nombre diferente al del "main"
		//este "args" corresponderá al ámbito de esta función
		//y no al original del "main"
		//así podríamos llamarlo con cualquier otro nombre
		
		if(!(args[0].equalsIgnoreCase("c")||args[0].equalsIgnoreCase("d"))) {
			//en caso de que no se especifique bien si queremos codificar o decodificar
			//devolvemos "false"
			System.out.println("NO SE ESPECIFICÓ BIEN SI CODIFICAMOS O DECODIFICAMOS"); //informamos al usuario
			return false;
		}
		
		try {
			int desplazamiento = Integer.parseInt(args[1]); //convertimos el "String" en un "int"
			if(desplazamiento<0) { //consideramos que el desplazamiento no puede ser negativo
				System.out.println("EL DESPLAZAMIENTO NO PUEDE SER NEGATIVO");
				return false;
			}
		}catch(Exception error) { //si no se pudo convertir, devolvemos "false"
			System.out.println("NO SE ESPECIFICÓ BIEN EL DESPLAZAMIENTO DE LAS LETRAS");
			return false;
		}
		
		String entrada=args[2]; //guardamos la ruta de la entrada
		File pruebaEntrada= new File(entrada); //creamos un supuesto archivo de la ruta
		if(!pruebaEntrada.exists()) { //en caso de que no exista el archivo
			System.out.println("NO EXISTE EL ARCHIVO DE ENTRADA ESPECIFICADO");
			return false; //devolvemos "false"
		}
		
		String salida=args[3]; //guardamos la ruta de la salida
		File pruebaSalida= new File(salida); //creamos un supuesto archivo de la ruta
		if(!pruebaSalida.exists()) { //en caso de que no exista el archivo
			System.out.println("NO EXISTE EL ARCHIVO DE SALIDA ESPECIFICADO");
			return false; //devolvemos "false"
		}
		
		return true; //en caso de que todo este correcto, devolvemos "true"
	}
	
	static String codificar(int desplazamiento, String texto, String abecedario) {
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
					break;
				}
				else if(j==(cantidadLetras-1)){
					if(desplazamiento==0) {
						resultado+=texto.charAt(i);
					}else {
						resultado+=abecedario.charAt(desplazamiento-1);
						}
					break;
				}
			}
			if(posicionLetra!=-1) {
				if((posicionLetra+desplazamiento)<cantidadLetras) {
					resultado+=abecedario.charAt(posicionLetra+desplazamiento);
				}else {
					resultado+=abecedario.charAt(posicionLetra+desplazamiento-cantidadLetras);
					}
				}
			}
		return resultado;
		}
	
	static String decodificar(int desplazamiento, String texto, String abecedario) {
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
			}
				if((posicionLetra-desplazamiento+1)>0) {
					resultado+=abecedario.charAt(posicionLetra-desplazamiento);
				}else {
					resultado+=abecedario.charAt(posicionLetra-desplazamiento+cantidadLetras);
					}
			}
		return resultado;
	}
	
}

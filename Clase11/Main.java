package guia11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * ATENCIÓN!
		 * 
		 * PARA TENER DIFERENTES PROCESOS DE ESTE PROGRAMA
		 * SE TIENE QUE EJECUTAR LAS VECES QUE DESEEMOS MEDIANTE
		 * LA EJECUCIÓN DE ECLIPSE EN CONSOLA
		 * 
		 * PODREMOS VER LOS DIFERENTES PROCESOS EN LA OPCIÓN "Display Selected Console"
		 * 
		 * PARA VISUALIZAR ESTO DE MEJOR FORMA, IR A LA PRESENTACIÓN DE LA CLASE 11
		 * Y EN LA DIAPOSITIVA Nº 7 SE PUEDE VER LA FORMA EN QUE INTERACTUAMOS CON LOS DIFERENTES PROCESOS
		 */
		
		//-----RUTA DEL ARCHIVO, DEBE CAMBIARSE PARA FUNCIONAR!!!-----
		Path rutaArchivo = Paths.get("src/guia11/chat.txt");
		
		String nombre = ingresarNombre(); //tomo el nombre del usuario del proceso actual
		
		while(true) { //dejo un bucle infinito hasta que seleccione la opción de salir
			String opcion = mostrarOpciones(); //muestro las opciones disponibles
			
			if(opcion.equals("1")) {
				enviarMensaje(rutaArchivo, nombre);
			}else if(opcion.equals("2")) {
				mostrarChat(rutaArchivo);
			}else if(opcion.equals("3")) {
				System.out.println("\nGRACIAS POR USAR NUESTRO SERVICIO!");
				break; //salimos del bucle infinito, finalizando el programa
			}
		}
	}

	private static void mostrarChat(Path rutaArchivo) {
		System.out.println("");
		System.out.println("[CHAT]");
		try {
			for(String linea:Files.readAllLines(rutaArchivo)) {
				//mostramos todos los mensajes del archivo del chat
				System.out.println(linea);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void enviarMensaje(Path rutaArchivo, String nombre) {
		System.out.println("\nESCRIBA SU MENSAJE:");
		System.out.print("> ");
		String mensaje = nombre+": "; //guardaremos el nombre de quién escribió el mensaje
		mensaje += new Scanner(System.in).nextLine(); //tomamos toda la línea escrita por consola
		mensaje += "\n"; //agregamos un salto de línea para que cada mensaje se vea por separado
		byte bytesMensaje[] = mensaje.getBytes(); //convertimos el String en algo que pueda ser escrito
		try {
			//agregamos el mensaje al final del archivo
			Files.write(rutaArchivo, bytesMensaje, StandardOpenOption.APPEND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static String mostrarOpciones() {
		String opcion=""; //iniciamos la variable que almacenará la opción elegida
		do {
			System.out.println("\n--------------------------------------");
			System.out.println("ELIJA UNA OPCIÓN:");
			System.out.println("1- Enviar mensaje");
			System.out.println("2- Mostrar chat");
			System.out.println("3- Salir");
			System.out.println("--------------------------------------");
			System.out.print("> ");
			opcion = new Scanner(System.in).next(); //tomamos el primer String sin contar los espacios
			if(!(opcion.equals("1")) && !(opcion.equals("2")) && !(opcion.equals("3"))) {
				//en caso de que no sea alguna de las tres opciones, informamos del error del usuario
				System.err.println("ERROR! DEBE INGRESAR UNA DE LAS OPCIONES (UNO DE LOS NÚMEROS DISPONIBLES)");
			}
			//mientras el usuario no seleccione una opción disponible, seguiremos pidiendo una opción
		} while(!(opcion.equals("1")) && !(opcion.equals("2")) && !(opcion.equals("3")));
		return opcion; //devolvemos lo que seleccionó el usuario para realizar la acción pertinente
	}
	
	private static String ingresarNombre() {
		System.out.println("BIENVENIDO!\nINGRESE SU NOMBRE DE USUARIO (NO SE TENDRÁN EN CUENTA LOS ESPACIOS):");
		System.out.print("> ");
		//ingresamos el nombre
		//se toma en cuentra el String que va después de un espacio y antes de otro
		//es decir, si ingresamos "     Lionel Messi    "
		//solo se tomará el String "Lionel"
		//por este motivo no se aceptan espacios en el nombre de usuario
		String nombre = new Scanner(System.in).next();
		return nombre; //devolvemos el nombre
	}
	
}

package guia09;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner consola = new Scanner(System.in);
		System.out.println("INGRESE CANTIDAD DE PERSONAS A CARGAR:");
		Persona listaPersonas[] = new Persona[consola.nextInt()];
		//ingreso la dimesion mediante un entero por consola
		
		System.out.println("---------------------------------------");
		
		for(int i=0;i<listaPersonas.length;i++) {
			
			Persona nuevaPersona = new Persona(); //objeto para cargar un nueva persona
			
			System.out.println("PERSONA Nº "+(i+1));
			
			System.out.println("NOMBRE:");
			nuevaPersona.setNombre(consola.next());
			
			System.out.println("APELLIDO:");
			nuevaPersona.setApellido(consola.next());
			
			//creo unas variables para luego generar una fecha
			//no tengo en cuenta la hora ni los minutos
			int anio;
			int mes;
			int dia;
			
			System.out.println("AÑO:");
			anio=consola.nextInt();
			
			System.out.println("MES:");
			mes=consola.nextInt();
			
			System.out.println("DÍA:");
			dia=consola.nextInt();
			
			//NO estoy teniendo en cuenta posibles errores al ingresar los datos!!!
			
			nuevaPersona.setFechaNacimiento(LocalDateTime.of(anio, mes, dia, 0, 0));
			//tomo la fecha de los valores ingresados
			
			listaPersonas[i]=nuevaPersona; //finalmente agrego la persona a nuestro arreglo
			System.out.println("---------------------------------------");
			
		}
		
		for(int i=0;i<listaPersonas.length;i++) {
			
			//imprimo cada persona registrada, separando con "|" a cada campo
			System.out.println(
			listaPersonas[i].getNombre()+"|"
			+listaPersonas[i].getApellido()+"|"
			+listaPersonas[i].getFechaNacimiento()
			);
			
		}
		
	}

}

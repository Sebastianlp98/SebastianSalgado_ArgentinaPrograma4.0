import java.io.IOException; //Eclipse importa automáticamente al utilizar una clase
import java.nio.file.*; //importo el paquete para trabajar con archivos

public class ej02a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		args=new String[2]; //determinamos la cantidad de parámetros a aceptar
		//en este caso es la ruta y si queremos sumar o multiplicar
		//envio la ruta por parámetro del "main"
		//recordemos que el parámetro de "main" es "args"
		args[0]="C:\\eclipse\\workspace\\ARGPROG04\\src\\archivo.txt"; //la ruta depende de dónde tengan el archivo
		args[1]="m"; //"s" para sumar, "m" para multiplicar
		Path ruta=Paths.get(args[0]); //guardo la ruta en un objeto "Path"
		try {
			if(args[1].equalsIgnoreCase("s")) { //si queremos sumar
				int acumulador=0; //si sumamos tendremos 0 al inicio
				for(String linea:Files.readAllLines(ruta)) { //recorro cada línea del archivo especificado en la ruta
					int numero=Integer.parseInt(linea); //convertimos la línea en número
					acumulador+=numero; //sumamos el número al total
					//tengamos en cuenta que si escribimos mal el archivo nos dará error
					//es decir, los números deben estar uno por cada línea
					//además de obviamente no poner caracteres que no correspondan a los enteros
				}
				System.out.println("La suma total es: "+acumulador);
			}else if(args[1].equalsIgnoreCase("m")) { //si queremos ir multiplicando
				int acumulador=1; //si multiplicamos, debemos empezar con 1
				for(String linea:Files.readAllLines(ruta)) { //recorro cada línea del archivo especificado en la ruta
					int numero=Integer.parseInt(linea); //convertimos la línea en número
					acumulador*=numero; //multiplico el número al total
					//tengamos en cuenta que si escribimos mal el archivo nos dará error
					//es decir, los números deben estar uno por cada línea
					//además de obviamente no poner caracteres que no correspondan a los enteros
				}
				System.out.println("La multiplicación total es: "+acumulador);
			}else { //en caso de no ingresar el parámetro correctamente
				System.out.println("No se especificó si sumamos o multiplicamos!");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//este "try-catch" es obligatorio ya que estamos tratando con archivos
			//y estos pueden cambiar su ruta o dejar de existir, por lo que Java nos obliga a tener en cuenta errores
		}
		
	}

}

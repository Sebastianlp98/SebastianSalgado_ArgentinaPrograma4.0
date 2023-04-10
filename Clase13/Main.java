package guia13;

//importamos las clases utilizadas del paquete para SQL
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//este "try-catch" nos sirve tanto por si no encontramos el driver o por si no podemos conectar con la BBDD
			Class.forName("org.postgresql.Driver"); //obtenemos el driver
			//para poder realizar esta línea debemos importar a nuestro proyecto la librería de postgres!
			//en las imágenes de la carpeta se puede visualizar el paso a paso!
			
			String miBbdd = "jdbc:postgresql://localhost:5432/guia12";
			//tomo la dirección de mi base de datos
			//"jdbc:postgresql": utilizo JDBC para postgres
			//"://localhost:5432": "localhost" significa que trabajamos sobre nuestro computadora
			//"5432" es el puerto sobre el que trabaja postgres, por defecto es este valor!
			//"/guia12": es el nombre de la BBDD a la que accederemos
			Connection conexionBbdd = DriverManager.getConnection(miBbdd, "postgres", "pepino560");
			//creamos la conexióm
			//debo ingresar un usuario y contraseña
			//"postgres" es el usuario administrador, y que viene cuando ya instalamos el gestor
			//"pepino560" es mi contraseña
			Statement usarBbdd = conexionBbdd.createStatement();
			//el "Statement" será nuestra vía de comunicación con la BBDD
			
			//ATENCIÓN!!!!!!
			//el controlador de JDBC tiene problemas con los caracteres latinos
			//por ello se recomienda no usar tildes o la ñ, por ejemplo
			//el driver no puede procesarlos bien y los comunica erróneamente
			//por este motivo, tuve que cambiar el nombre al departamento de logística
			//con la siguiente instrucción pueden hacerlo ustedes también!
			//UPDATE departamentos SET nombre='Logistica' WHERE nombre='Logística';
			
			//creo mi instrucción para ingresar un empleado nuevo
			String instruccionSql = "INSERT INTO empleados (dni, nombre, apellido, nacionalidad, departamento)"
					+ " VALUES (30693112, 'Horacio', 'Torres', 'Paraguay', 'Logistica');";
			usarBbdd.executeUpdate(instruccionSql);
			//ejecuto la instrucción SQL, como si lo hiciera por "psql" (la consola de SQL)
			
			//actualizo la nacionalidad de un empleado deseado
			instruccionSql="UPDATE empleados SET Nacionalidad='Uruguay' WHERE dni=30693112;";
			usarBbdd.executeUpdate(instruccionSql); //seguimos usando la misma variable por comodidad y eficiencia
			
			//borramos un departamento de nuestros registros
			instruccionSql="DELETE FROM departamentos WHERE nombre='Higiene';";
			usarBbdd.executeUpdate(instruccionSql);
			
			//tomamos todos los empleados del departamento "Logística"
			instruccionSql="SELECT * FROM empleados WHERE departamento='Logistica';";
			//con "ResultSet" guardaremos el resultado de nuestra consulta ("query") SQL
			ResultSet resultadoConsulta = usarBbdd.executeQuery(instruccionSql); //ejecutamos la consulta (el comando)
			System.out.println("EMPLEADOS DE LOGÍSTICA:"); //informamos lo que imprimimos
			while(resultadoConsulta.next()) { //mientras hayan registros ("next()"), ejecutamos el siguiente código
				//guardamos los datos que nos interesan mostrar
				String nombre = resultadoConsulta.getString(2);
				String apellido = resultadoConsulta.getString(3);
				int dni = resultadoConsulta.getInt(1);
				//hay que recordar de qué tipo era cada columna!
				System.out.println("NOMBRE: "+nombre+ " | APELLIDO: "+ apellido + " | DNI: "+dni);
			}
			
			//ahora mostramos todos los departamentos existentes ordenados según el orden alfabético
			instruccionSql="SELECT * FROM departamentos ORDER BY nombre;";
			resultadoConsulta = usarBbdd.executeQuery(instruccionSql);
			System.out.println("\nDEPARTAMENTOS EXISTENTES:");
			while(resultadoConsulta.next()) {
				//por cada registro, imprimo su nombre (que sería la primera columna)
				System.out.println(resultadoConsulta.getString(1));
				//por cada vuelta de bucle, "resultadoConsulta" va avanzando en los registros que obtiene
			}
			
			//es MUY IMPORTANTE cerrar la conexión cuando ya hayamos terminado!!!
			conexionBbdd.close();
		} catch (ClassNotFoundException e) { //si no encontramos el driver
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) { //si no podemos conectar con la BBDD
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

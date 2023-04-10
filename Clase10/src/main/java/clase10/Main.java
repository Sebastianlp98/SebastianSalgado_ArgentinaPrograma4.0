package guia10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * -Debo tomar unas inscripciones
		 * -Luego tengo que validar esas inscripciones y el resultado guardarlo en un archivo
		 * -Tiene que haber materias con correlatividades y sin, se guardarán en una colección
		 * -Habrán alumnos con y sin materias aprobadas, se almacenan en una colección
		 * -Existe un archivo inscripción que contiene el nombre del alumno y la materia a inscribir
		 * -Se tienen que usar los objetos previamente instanciados
		 * -Se imprime el resultado de la inscripción
		 * -Los objetos se identifican por su nombre
		 * -Si en el archivo hay un objeto que no está creado en mi programa, informar del error
		 */
		
		//------------MATERIAS------------
		List<Materia> listaMaterias = new ArrayList<Materia>(); //guardo mis materias registradas
		List<Materia> correlativas; //variable que nos servirá para añadir correlativas
		
		Materia programacion1=new Materia();
		programacion1.setNombre("Programación I");
		correlativas=new ArrayList<Materia>(); //materia sin correlativas
		programacion1.setCorrelativas(correlativas);
		listaMaterias.add(programacion1); //añado la materia a mis registros
		
		Materia programacion2=new Materia();
		programacion2.setNombre("Programación II");
		correlativas=new ArrayList<Materia>(); //creo un nuevo ArrayList diferente para esta materia
		correlativas.add(programacion1); //agrego sus correlativas
		programacion2.setCorrelativas(correlativas);
		listaMaterias.add(programacion2);
		
		Materia basesDeDatos1=new Materia();
		basesDeDatos1.setNombre("Bases de datos I");
		correlativas=new ArrayList<Materia>(); //voy creando una nueva lista por cada materia
		basesDeDatos1.setCorrelativas(correlativas);
		listaMaterias.add(basesDeDatos1);
		
		Materia basesDeDatos2=new Materia();
		basesDeDatos2.setNombre("Bases de datos II");
		correlativas=new ArrayList<Materia>();
		correlativas.add(basesDeDatos1);
		basesDeDatos2.setCorrelativas(correlativas);
		listaMaterias.add(basesDeDatos2);
		
		Materia quimica=new Materia();
		quimica.setNombre("Química");
		correlativas=new ArrayList<Materia>();
		quimica.setCorrelativas(correlativas);
		listaMaterias.add(quimica);
		
		//------------ALUMNOS------------
		List<Alumno> listaAlumnos = new ArrayList<Alumno>(); //registro de alumnos
		Alumno alumno; //variable para cada alumno génerico
		
		alumno = new Alumno();
		alumno.setNombre("José Rodríguez");
		alumno.setLegajo("12908");
		correlativas=new ArrayList<Materia>(); //utilizo de nuevo la lista de correlativas
		alumno.setMateriasAprobadas(correlativas); //en este caso, es una lista vacía
		listaAlumnos.add(alumno); //añado el alumno a la lista
		
		alumno = new Alumno();
		alumno.setNombre("Vanesa Sosa");
		alumno.setLegajo("11911");
		correlativas=new ArrayList<Materia>();
		alumno.setMateriasAprobadas(correlativas);
		listaAlumnos.add(alumno);
		
		alumno = new Alumno();
		alumno.setNombre("Lucia Pérez");
		alumno.setLegajo("15602");
		correlativas=new ArrayList<Materia>(); //creo una lista para guardar las materias aprobadas
		correlativas.add(programacion1); //le agrego sus materias aprobadas
		correlativas.add(quimica); //nótese que reutilizamos la variable "correlativas"
		alumno.setMateriasAprobadas(correlativas);
		listaAlumnos.add(alumno);
		
		alumno = new Alumno();
		alumno.setNombre("Ezequiel Frossasco");
		alumno.setLegajo("14697");
		correlativas=new ArrayList<Materia>();
		correlativas.add(programacion1);
		correlativas.add(basesDeDatos1);
		alumno.setMateriasAprobadas(correlativas);
		listaAlumnos.add(alumno);
		
		//------------INSCRIPCIONES------------
		Path rutaArchivo = Paths.get("src/main/resources/inscripciones.txt"); //registro de inscripciones
		Path rutaSalida = Paths.get("src/main/resources/resultados.txt"); //ruta para escribir los resultados
		//variables booleanas para informar sobre los mensajes de errores
		boolean existeAlumno;
		boolean existeMateria;
		
		try {
			for(String lineaArchivo:Files.readAllLines(rutaArchivo)) {
				//leo cada registro de inscripción
				
				String resultado=""; //variable para ir guardando el resultado de la inscripción
				
				String nombreAlumno = lineaArchivo.split(";")[0]; //tomo el nombre en la inscripción
				String nombreMateria= lineaArchivo.split(";")[1]; //y también la materia
				
				//busco al alumno y la materia en mis registros
				Alumno alumnoInscripcion = encontrarAlumno(nombreAlumno, listaAlumnos);
				Materia materiaInscripcion = encontrarMateria(nombreMateria, listaMaterias);
				
				//me certifico que esos datos existan en mis registros
				if(alumnoInscripcion==null) {
					//si no encontré al alumno, obtuve "null"
					existeAlumno=false; //no existe el alumno
				}else {
					//pero si no obtuve nulo, es que existe el alumno
					existeAlumno=true;
				}
				
				//hacemos lo mismo pero para la materia de la inscripción registrada
				if(materiaInscripcion==null) {
					existeMateria=false;
				}else {
					existeMateria=true;
				}
				
				//damos formato a la salida
				resultado+=nombreAlumno+";"+nombreMateria+";";
				
				//guardamos el momento en que se obtiene el resultado
				LocalDateTime fechaResultado = LocalDateTime.now();
				
				//vamos determinando el resultado de la salida
				if(!existeAlumno && !existeMateria) {
					resultado+="NO EXISTE EL ALUMNO NI LA MATERIA!!!;";
				}else if(!existeAlumno) {
					resultado+="NO EXISTE EL ALUMNO!!!;";
				}else if(!existeMateria) {
					resultado+="NO EXISTE LA MATERIA!!!;";
				}else {
					
					//ahora en el caso de que existan ambos, creamos el resultado de la inscripción
					Inscripcion inscripcion = new Inscripcion();
					
					//seteo sus variables de instancia
					inscripcion.setAlumno(alumnoInscripcion);
					inscripcion.setMateria(materiaInscripcion);
					inscripcion.setFecha(fechaResultado); //fecha de la inscripción
					
					//finalmente determino el resultado de la inscripción
					if(inscripcion.aprobada()) {
						resultado+="APROBADA;";
					}else {
						resultado+="RECHAZADA;";
					}
				}
				
				//guardo la fecha del resultado en su registro
				resultado+=fechaResultado;
				resultado+="\n"; //agrego un salto de línea para que cada registro quede en un renglón
				
				//convierto a "byte" para poder escribirlo en el archivo de texto
				byte bytesResultados[] = resultado.getBytes();
				
				//finalemente escribo al final del archivo de texto (no se está sobreescribiendo)
				Files.write(rutaSalida, bytesResultados, StandardOpenOption.APPEND);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//"private" ya que sólo será utilizado en el main (dentro de la misma clase "Main")
	//esto es para que no pueda ser accedido desde fuera!
	private static Alumno encontrarAlumno(String alumnoBuscado, List<Alumno> listaAlumnos) {
		for(Alumno alumnoRegistrado:listaAlumnos) {
			//voy tomando cada alumno registrado en mi lista
			if(alumnoRegistrado.getNombre().equals(alumnoBuscado)) {
				//si coinciden los nombres, devuelvo ese objeto
				return alumnoRegistrado;
			}
		}
		//en caso de que no se haya encontrado el alumno buscado devolvemos un objeto nulo
		return null;
	}
	
	//utilizamos la misma metodología que recién
	private static Materia encontrarMateria(String materiaBuscada, List<Materia> listaMaterias) {
		for(Materia materiaRegistrada:listaMaterias) {
			if(materiaRegistrada.getNombre().equals(materiaBuscada)) {
				return materiaRegistrada;
			}
		}
		return null;
	}

}

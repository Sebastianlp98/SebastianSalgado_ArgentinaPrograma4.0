package guia10;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

//utilizamos la notaciones de Lombok que generan los setters y getters automáticamente
@Setter
@Getter

public class Alumno {
	
	private String nombre;
	private String legajo;
	private List<Materia> materiasAprobadas;
	
}

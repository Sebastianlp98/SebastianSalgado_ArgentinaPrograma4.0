package guia10;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Inscripcion {
	
	private Alumno alumno;
	private Materia materia;
	private LocalDateTime fecha;
	
	public boolean aprobada() {
		//simplemente indicamos si la materia seleccionada puede ser cursada por el alumno que se inscribió
		if(materia.puedeCursar(alumno)) {
			return true;
		}else {
			return false;
		}
	}

}

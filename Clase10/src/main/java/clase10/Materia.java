package guia10;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Materia {

	private String nombre;
	private List<Materia> correlativas;
	
	public boolean puedeCursar(Alumno alumno) {
		
		//primero verifico si el alumno no tiene ninguna materia aprobada
		//y tengo en cuenta que esta materia necesita correlativa
		if(alumno.getMateriasAprobadas().size()==0 && correlativas.size()>0) {
			//el alumno no podrá cursarla ya que esta materia necesita de correlativa
			return false;
		}
		
		//luego me aseguro que el alumno no tenga ya esta materia aprobada
		for(Materia materiaAprobada:alumno.getMateriasAprobadas()) {
			//recorro cada materia aprobada del alumno
			if(materiaAprobada.getNombre().equals(this.getNombre())) {
				//en caso de encontrar que ya aprobó esta materia, rechazo la solicitud
				return false;
			}
		}
		
		//si no ocurre nada de lo anterior y esta materia no tiene correlativas
		if(correlativas.size()==0) {
			//el alumno podrá cursarla perfectamente
			return true;
		}
		
		//en caso de no pasar ninguna de las situaciones anteriores
		//tendré que encontrar cada correlativa de esta materia en las materias aprobadas del alumno
		//para ello utilizo dos bucles "for" anidados
		for(Materia materiaCorrelativa:correlativas) { //recorro las correlativas necesarias
			int materiaEvaluadas=0; //se inicia en 0 por cada correlativa existente
			//contador que me sirve para saber si evalué todas las materias aprobadas del alumno
			
			for(Materia materiaAprobada:alumno.getMateriasAprobadas()) { //recorro las materias del alumno
				materiaEvaluadas++; //cuento cada materia aprobada que tiene el alumno
				
				if(materiaAprobada.getNombre().equals(materiaCorrelativa.getNombre())){
					//si encuentro la materia correlativa dentro de las materias aprobadas del alumno
					//dejo de buscar en la lista de las materias del alumno
					//para entonces romper el bucle "for" por cada "materiaAprobada" utilizo un "break"
					break;
				}else if(materiaEvaluadas==alumno.getMateriasAprobadas().size()) {
					//ahora si no encuentro coincidencia en las materias del alumno
					//y ya recorrí todas sus materias aprobadas
					//significa que el alumno no tiene la materia correlativa necesaria
					return false;
				}
			}
		}
		
		//si no ocurre nada de lo anterior descripto, significa que podré cursar la materia
		return true;
	}
	
}

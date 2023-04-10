package guia10;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class Test {
	
	Materia materia1 = new Materia();
	Materia materia2 = new Materia();
	Materia materia3 = new Materia();
	Alumno alumno = new Alumno();
	List<Materia> correlativasAlumno = new ArrayList<Materia>();
	
	@org.junit.Before
	public void antesDeCadaTest() {
		materia1.setNombre("Programación I");
		List<Materia> correlativas1 = new ArrayList<Materia>();
		materia1.setCorrelativas(correlativas1);
		//pasamos una lista vacía
		
		materia2.setNombre("Programación II");
		List<Materia> correlativas2 = new ArrayList<Materia>();
		correlativas2.add(materia1); //agregamos la materia anterior
		materia2.setCorrelativas(correlativas2);
		
		materia3.setNombre("Programación III");
		List<Materia> correlativas3 = new ArrayList<Materia>();
		correlativas3.add(materia1);
		correlativas3.add(materia2);
		materia3.setCorrelativas(correlativas3);
		
		alumno.setNombre("Tomás Ocampo");
		alumno.setLegajo("15692");
		//por ahora no le asignamos sus materias aprobadas (la variable de instancia sería "null")
	}

	@org.junit.Test
	public void test1() {
		//la longitud de la lista debería ser cero, ya que no tiene ninguna materia dentro
		assertEquals(0, materia1.getCorrelativas().size());
	}
	
	@org.junit.Test
	public void test2() {
		correlativasAlumno.add(materia1);
		correlativasAlumno.add(materia2);
		//asignamos materias aprobadas al alumno
		alumno.setMateriasAprobadas(correlativasAlumno);
		//en este caso, son las mismas que las que necesita la materia a cursar
		assertEquals(true, materia3.puedeCursar(alumno));
	}

	@org.junit.Test
	public void test3() {
		//insertamos una lista vacía
		alumno.setMateriasAprobadas(correlativasAlumno);
		//el alumno no puede cursar porque no tiene ninguna materia aprobada
		assertEquals(false, materia2.puedeCursar(alumno));
	}
	
	@org.junit.Test
	public void testExtra() {
		correlativasAlumno.add(materia1);
		alumno.setMateriasAprobadas(correlativasAlumno);
		//el alumno no podría cursar una materia que ya aprobó!
		assertEquals(false, materia1.puedeCursar(alumno));
	}

}

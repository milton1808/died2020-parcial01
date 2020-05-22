package isi.died2020.parcial01.ejercicio02.app;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import isi.died2020.parcial01.ejercicio02.db.BaseDeDatos;
import isi.died2020.parcial01.ejercicio02.db.BaseDeDatosExcepcion;
import isi.died2020.parcial01.ejercicio02.dominio.*;
import isi.died2020.parcial01.ejercicio02.dominio.Inscripcion.Estado;


public class MySysAcadImpl implements MySysAcad {
	private static final BaseDeDatos DB = new BaseDeDatos();


	private List<Materia> materia = new ArrayList<Materia>();
	
	@Override
	public void registrarMateria(Materia d) {
		this.materia.add(d);
	}
	
	private List<Docente> docentes = new ArrayList<Docente>();
	
	@Override
	public void registrarDocente(Docente d) {
		this.docentes.add(d);
	}
	
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	
	@Override
	public void registrarAlumnos(Alumno d) {
		this.alumnos.add(d);
	}
	

	@Override
	public void inscribirAlumnoCursada(Docente d, Alumno a, Materia m, Integer cicloLectivo) throws noSeGuardoLaInscripcionException, noAproboLasCorrelativasException {
		List<Materia> correlativasRendir = m.getCorrelativasRendir();
		
		List<Materia> materiasAprobadas = new ArrayList<Materia>();
		
		//obtengo la materias aprobadas del alumno
		materiasAprobadas = a.getExamenes().stream().filter(ex -> ex.getNota() >= 6).map(ex -> ex.getMateria()).collect(Collectors.toList());
		
		//pregunto compruebo que todas las correlativasRendir se encuentren en materiasAprobadas
		for(Materia cor : correlativasRendir) {
			if(!materiasAprobadas.contains(cor))	throw new noAproboLasCorrelativasException();		
		}
		
		
		Inscripcion insc = new Inscripcion(cicloLectivo,Inscripcion.Estado.CURSANDO);
		d.agregarInscripcion(insc);
		a.addCursada(insc);
		m.addInscripcion(insc);
		try {
			DB.guardar(insc);
		} catch (BaseDeDatosExcepcion e) {
			throw new noSeGuardoLaInscripcionException();
		}
	}

	@Override
	public void inscribirAlumnoExamen(Docente d, Alumno a, Materia m) throws noSeGuardoElExamenException {
		Examen e = new Examen();
		a.addExamen(e);
		d.agregarExamen(e);
		m.addExamen(e);
		try {
			DB.guardar(e);
		} catch (BaseDeDatosExcepcion e1) {
			throw new noSeGuardoElExamenException();
			
		}
	}
	
	public void registrarNota(Examen e, int nota) {
		e.setNota(nota);
		ArrayList<Inscripcion> in = new ArrayList<Inscripcion>();
		
		if(nota >=6){
			//buscamos las inscripciones del alumno a la materia del examen
			for(Inscripcion ins : e.getAlumno().getMateriasCursadas()) {
				if(ins.getMateria().equals(e.getMateria())) in.add(ins);
			}
			
			//actualizamos la ultima incripcion a PROMOCIONADO
			in.sort((in1,in2)-> in1.getCicloLectivo().compareTo(in2.getCicloLectivo()));
			in.get(in.size()-1).setEstado(Estado.PROMOCIONADO);
			
		}
	}


	@Override
	public Double promedioAprobados(Materia m) {
		 OptionalDouble prom = m.getExamenes().stream().filter(ex -> ex.getNota()>=6).mapToInt(ex -> ex.getNota()).average();
		 
		 return prom.getAsDouble();
		
	}
	
	public List<Alumno> inscriptos(Materia m, Integer ciclo){
		List<Alumno> alumnos = new ArrayList<Alumno>();
		alumnos = m.getInscripciones().stream().filter(in -> in.getCicloLectivo().equals(ciclo)).map(in-> in.getInscripto()).distinct().sorted((a1,a2) -> a1.getNombre().compareTo(a2.getNombre())).collect(Collectors.toList());
		
		return alumnos;
			
	}
	

}

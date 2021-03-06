package isi.died2020.parcial01.ejercicio02.app;



import isi.died2020.parcial01.ejercicio02.dominio.*;



public interface MySysAcad {
	
	public void registrarMateria(Materia d);
	
	
	public void registrarDocente(Docente d) ;
	
	
	public void registrarAlumnos(Alumno d);
	/**
	 * crea una nueva instancia de Inscripcion y 
	 * asigna la inscripcion a la lista de inscripciones del alumno, 
	 * de la materia y del docente
	 * @throws noSeGuardoLaInscripcionException 
	 * @throws noAproboLasCorrelativasException 
	 */
	public void inscribirAlumnoCursada(Docente d,Alumno a, Materia m,Integer cicloLectivo) throws noSeGuardoLaInscripcionException, noAproboLasCorrelativasException;

	/**
	 * crea una nueva instancia de Inscripcion y 
	 * asigna la inscripcion a la lista de inscripciones del alumno, 
	 * de la materia y del docente
	 * @throws noSeGuardoElExamenException 
	 */
	public void inscribirAlumnoExamen(Docente d,Alumno a, Materia m) throws noSeGuardoElExamenException;
	
	public Double promedioAprobados(Materia m);
	
	
	

}

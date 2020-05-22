package isi.died2020.parcial01.ejercicio01;

public class ReciboDeSueldo {
	private long idRecibo;
	private int mes;
	private double total;
	private Empleado empleado;
	
	public ReciboDeSueldo(long id, int m, double tot, Empleado e) {
		idRecibo = id;
		mes = m;
		total = tot;
		empleado = e;
	}
	@Override
	public String toString() {
		return "["+idRecibo+","+mes+","+total+","+empleado.toString();
	}
}

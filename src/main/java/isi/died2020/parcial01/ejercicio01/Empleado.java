package isi.died2020.parcial01.ejercicio01;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Empleado {
	protected long cuil;
	protected String nombre;
	protected LocalDate fechaNacimiento;
	protected String correo;
	protected ArrayList<Venta> ventas;
	
	public abstract ReciboDeSueldo calcularRecibo();
	
	public int bono() {
		int res = 0;
		LocalDate hoy = LocalDate.now();
		if(hoy.getMonthValue() == fechaNacimiento.getMonthValue()) res = 20000;
		return res;
	}
	
	@Override
	public String toString() {
		return nombre;
	}
}

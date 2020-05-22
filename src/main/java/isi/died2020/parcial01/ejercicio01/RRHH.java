package isi.died2020.parcial01.ejercicio01;

import java.util.ArrayList;

public class RRHH {

	public RRHH() {
	}
	
	public ArrayList<ReciboDeSueldo> recibos(ArrayList<Empleado> listaEmp){
		ArrayList<ReciboDeSueldo> listaRecibos = new ArrayList<ReciboDeSueldo>();
		
		for(Empleado e : listaEmp) {
			listaRecibos.add(e.calcularRecibo());
		}
		return listaRecibos;
	}
	
}

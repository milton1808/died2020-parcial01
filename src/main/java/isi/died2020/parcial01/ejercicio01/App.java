package isi.died2020.parcial01.ejercicio01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class App {

	public static void main(String[] args) {
		

		ArrayList<Venta> ventas = new ArrayList<Venta>();
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();


			ventas.add(new Venta(1,LocalDate.of(2019, 02, 15),100.2));
			ventas.add(new Venta(2,LocalDate.of(2019, 03, 15),120000));
			ventas.add(new Venta(3,LocalDate.of(2019, 04, 15),100.2));
			ventas.add(new Venta(4,LocalDate.of(2019, 05, 15),120000));
			ventas.add(new Venta(5,LocalDate.of(2019, 06, 15),100.2));
			ventas.add(new Venta(6,LocalDate.of(2019, 04, 15),120000));
			ventas.add(new Venta(7,LocalDate.of(2019,10, 15),100.2));
			ventas.add(new Venta(8,LocalDate.of(2019,11, 15),120000));
			
			empleados.add(new EnConvenio(11111111111L,"juan",LocalDate.of(1994,10, 12), "a@b", ventas, (short)4 , 10000));
			empleados.add(new EnConvenio(22222222222L,"pedro",LocalDate.of(1994,01, 12), "a@b", ventas, (short)4 , 10000));
			empleados.add(new EnConvenio(33333333333L,"pablo",LocalDate.of(1994,04, 12), "a@b", ventas, (short)4 , 10000));
			
			empleados.add(new Contratado(44444444444L,"marta",LocalDate.of(1994,10, 12), "a@b", ventas, 30 , 500));
			empleados.add(new Contratado(55555555555L,"juliana",LocalDate.of(1994,10, 12), "a@b", ventas, 10 , 500));
			empleados.add(new Contratado(66666666666L,"maria",LocalDate.of(1994,10, 12), "a@b", ventas, 30 , 1000));
				
		
		
			RRHH r = new RRHH();
			
			ArrayList<ReciboDeSueldo> rec = r.recibos(empleados);
			System.out.println(rec.size());
			

	}
}

package isi.died2020.parcial01.ejercicio01;

import java.time.LocalDate;
import java.util.ArrayList;

public class Contratado extends Empleado {
		private int horasMes;
		private int costoHora;
		
		
		public Contratado(long c, String n, LocalDate fn, String mail,ArrayList<Venta> ven,int horasMes, int costoHora) {
			super();
			cuil= c;
			nombre= n;
			fechaNacimiento= fn;
			correo= mail;
			ventas = ven;
			this.horasMes = horasMes;
			this.costoHora = costoHora;
		}


		@Override
		public ReciboDeSueldo calcularRecibo() {
			LocalDate hoy = LocalDate.now();
			long id = (cuil*1000 + hoy.getYear())*100 + hoy.getMonthValue();
			double tot=horasMes * costoHora + this.bono();
			
			for(Venta v : ventas) {
				if(v.getMonto() > 10000) tot = tot + 10*costoHora;
			}
			
			return new ReciboDeSueldo(id,hoy.getMonthValue(),tot,this);
		}

}

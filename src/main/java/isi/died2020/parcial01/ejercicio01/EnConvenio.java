package isi.died2020.parcial01.ejercicio01;

import java.time.LocalDate;
import java.util.ArrayList;

public class EnConvenio extends Empleado {
		private short antiguedad;
		private int sueldoBasico;
		
		
		
		public EnConvenio(long c, String n, LocalDate fn, String mail,ArrayList<Venta> ven, short antiguedad, int sueldoBasico) {
			super();
			cuil= c;
			nombre= n;
			fechaNacimiento= fn;
			correo= mail;
			ventas = ven;
			this.antiguedad = antiguedad;
			this.sueldoBasico = sueldoBasico;
		}



		@Override
		public ReciboDeSueldo calcularRecibo() {
			LocalDate hoy = LocalDate.now();
			long id = (cuil*1000 + hoy.getYear())*100 + hoy.getMonthValue();
			double tot=sueldoBasico + this.bono();
			
			for(Venta v : ventas) {
				tot= tot + v.getMonto()*0.15;
			}
			
			return new ReciboDeSueldo(id,hoy.getMonthValue(),tot,this);
		}

}

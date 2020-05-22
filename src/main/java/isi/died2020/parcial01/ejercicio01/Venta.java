package isi.died2020.parcial01.ejercicio01;

import java.time.LocalDate;

public class Venta {
	private int numVenta;
	private LocalDate fecha;
	private double monto;
	
	
	public Venta(int numVenta, LocalDate fecha, double monto) {
		super();
		this.numVenta = numVenta;
		this.fecha = fecha;
		this.monto = monto;
	}


	public double getMonto() {
		return monto;
	}
}

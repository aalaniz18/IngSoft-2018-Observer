package main.java.resources;


public class Debito implements FormaPago{
	public double pagar(double precio){
		System.out.println("Estoy pagando con tarjeta de credito");
		return precio;
	}
}
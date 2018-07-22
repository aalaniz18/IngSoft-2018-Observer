package main.java.resources;


public class Credito implements FormaPago{
	public double pagar(double precio){
		precio=precio*1.40*0.33;
		System.out.println("Estoy pagando con tarjeta de credito");
		return precio;
	}
}

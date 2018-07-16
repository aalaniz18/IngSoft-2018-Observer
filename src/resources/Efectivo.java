package resources;


public class Efectivo implements FormaPago{
	public double pagar(double precio){
		precio=precio*0.9;
		System.out.println("Estoy pagando en efectivo");
		return precio;
	}

}

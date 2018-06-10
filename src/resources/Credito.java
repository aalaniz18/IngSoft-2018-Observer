
public class Credito implements FormaPago{
	public double pagar(double precio){
		precio=precio*0.33;
		System.out.println("Estoy pagando con tarjeta de credito");
		return precio;
	}
}

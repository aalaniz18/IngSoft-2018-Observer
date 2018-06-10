
public class Merchandising extends Producto {
	String nombre;
	
	public Merchandising(int IDprod,double precioU,int cantidad, String nombre){
		super(IDprod,precioU);
		this.nombre= nombre;
		this.setCant(cantidad);
	}

}

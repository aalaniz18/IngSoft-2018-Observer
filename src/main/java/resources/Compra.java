package main.java.resources;

public class Compra {
	
	private double total;
	private FormaPago f;
	private Codigo c;
	private boolean necEmpleado;
	
	public Compra(){
		total= 0.0;
		necEmpleado=false;
		genCodigo();
	}
	
	public void empleadoTrue(){
		necEmpleado=true;
	}
	
	public void genCodigo(){
		c=new Codigo(new Generador().creaCode());
	}

	/* El parametro i es el orden de casillero elegido por el usuario. Supongo primero a Efectivo
	  segundo a Credito y tercero a Debito. */
	public void	definirFormaPago(int i){
		if(i==1){
			f= new Efectivo();}
		if(i==2){
			f= new Credito();}
		if(i==3){
			f= new Debito();}
	}
	
	public double getTotal(){
		return total;
	}
	
	public String getCodigo(){
		return c.getCode();
	}
	
}

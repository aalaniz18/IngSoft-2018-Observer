package main.java.resources;

public class Compra {
	
	private double total;
	private FormaPago f;
	private Codigo c;
	public boolean necEmpleado;
	private String fp;
	
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
			fp= "Efectivo";
			f= new Efectivo();}
		if(i==3){
			fp= "Credito";
			f= new Credito();}
		if(i==2){
			fp= "Debito";
			f= new Debito();}
	}
	
	public double getTotal(){
		return total;
	}
	
	public void setTotal(double t){
		total=t;
	}
	
	public String getCodigo(){
		return c.getCode();
	}
	
	public void resetCompra(){
		total= 0.0;
		necEmpleado=false;
		genCodigo();
		f=null;
		fp=null;
	}
	
	public String getformaPago(){
		return fp;
	}
	
	public int getEmpl(){
		int ent= necEmpleado ? 1:0;
		return ent;
	}
	
	public FormaPago obtenerObjFormaPago(){
		return f;
	}
	
}

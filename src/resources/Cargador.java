import java.util.HashMap;

public class Cargador {
	//Compra c;
	private BaseDeDatos bd;
	
	public Cargador(){
		bd= new BaseDeDatos();
	}
	
	public boolean validarAdmin(String usua, String pass){ // hacer test, muy facil
		HashMap<String,String> m=bd.getMapAdmin();
		if(m.containsKey(usua)){
			if(pass==m.get(usua)){
				return true;}
			else
				return false;
			}
		else
			return false;
	}
	
	public BaseDeDatos getBase(){
		return bd;
	}
	
	public int[] listarLibres(int id) // no esta terminada, cuando vuelva la sigo
	
	
	
	/*
	public void iniciaCompra(){
		Compra c1= new Compra();
	}
	
	public void incrCompra(){
		//agrega productos
	}
	
	public void crearCode(Compra c){
		Generador g= new Generador();
		c.setCodigo(g.creaPass());
	}
	
	public void finCompra(Compra c){
		c.startValido();
		//falta resumen
	}
*/
	
}

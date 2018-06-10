public class Cargador {
	Compra c;
	
	public Cargador(){
	}
	
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

	
}

package resources;

public class FuncionesCine {
	private String pelicula;
	private int IDfunc;
	private int nAsientos;
	private boolean[] desocupados;
	
	public FuncionesCine(int n){
		nAsientos=n;
		desocupados=new boolean[nAsientos];
		cargarDisponibles();
	}
	
	public void setNombre(String nom){
		pelicula=nom;}
	
	public String getNombre(){
		return pelicula;
	}
	
	public void setID(int i){
		IDfunc=i;}
	
	public int getID(){
		return IDfunc;}
	
	public int getNAsientos(){
		return nAsientos;}

	public void cargarDisponibles(){
		for(int i=0; i<nAsientos; i++){
			desocupados[i]=true;}
	}

	public void setOcupado(int i){
		desocupados[i]=false;
	}

	public boolean[] getDesocupados(){
		return desocupados;
	}

}

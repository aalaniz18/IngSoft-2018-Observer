package resources;


public class Entrada extends Producto{
	String nomPelicula;
	String ubicacion;
	
	public Entrada(int IDprod,double precioU, String nomPelicula){
		super(IDprod, precioU);
		this.nomPelicula=nomPelicula;
	}
	
	public void setNombreP(String n){
		nomPelicula=n;}
	
	public String getNombreP(){
		return nomPelicula;}
	
	public void setUbicacion(String u){
		ubicacion=u;}
	
	public String getUbicacion(){
		return ubicacion;}

}

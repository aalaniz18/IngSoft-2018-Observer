package resources;


public class Producto {
	int IDprod;
	double precio;
	int cantidad;
	double precioU;
	
	public Producto(int IDprod,double precioU){
		this.IDprod=IDprod;
		this.precioU=precioU;
	}
	
	public void setIDprod(int i){
		IDprod=i;}
	
	public int getIDprod(){
		return IDprod;}

	public void setPrecioU(double p){
		precioU= p;}
	
	public double getPrecioU(){
		return precioU;}

	public double getPrecio(){
		return precio;}
	
	public void setCant(int c){
		cantidad=c;
		precio=cantidad*precioU;
	}
}

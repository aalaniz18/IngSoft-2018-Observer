package resources;


public class Producto {
	int IDprod;
	double precio;
	int cantidad;
	String precioU;
        String nombre;
	
	public Producto(String nombre,String precioU){
		this.precioU=precioU;
                this.nombre=nombre;
                
	}
	
	//public void setIDprod(int i){
	//	IDprod=i;}
	
	//public int getIDprod(){
	//	return IDprod;}

	public void setPrecioU(String p){
		precioU= p;}
	
	public String getPrecioU(){
		return precioU;}

	public double getPrecio(){
		return precio;}
	
	public void setCant(int c){
		cantidad=c;
	}
        public String getNombre(){
return nombre;
}
        public void setNombre (String nombre){
        this.nombre = nombre;
        }
}

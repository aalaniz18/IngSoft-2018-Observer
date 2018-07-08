package model;


public class Producto {
    
	String prodnom;
        float prodprecio;
        String prodtipo;
        String prodcoment;
        
	public Producto(String prodnom,float prodprecio,String prodtipo, String prodcoment){
            
	this.prodnom = prodnom;
        this.prodprecio = prodprecio;
        this.prodtipo = prodtipo;
        this.prodcoment = prodcoment;
        
        }
	
        public String getProdNom (){
        return prodnom;
        }
        
	public float getProdPrecio(){
        return prodprecio;
        }
	
	public String getProdTipo(){
        return prodtipo;
        }
        
        public String getProdComent(){
        return prodcoment;
}

    public String getNombre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
}

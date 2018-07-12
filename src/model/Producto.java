package model;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Producto {
	String prodnom;
        double prodprecio;
        String prodtipo;
        String prodcoment;
        
	public Producto(String prodnom,double prodprecio,String prodtipo, String prodcoment){
	this.prodnom = prodnom;
        this.prodprecio = prodprecio;
        this.prodtipo = prodtipo;
        this.prodcoment = prodcoment;
        
        }
	
        public String getProdNom (){
        return prodnom;
        }
        
	public double getProdPrecio(){
        return prodprecio;
        }
	
	public String getProdTipo(){
        return prodtipo;
        }
        
        public String getProdComent(){
        return prodcoment;
}

    
      
}

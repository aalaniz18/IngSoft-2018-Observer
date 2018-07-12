/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import model.Cargador;
import model.Producto;

/**
 *
 * @author perez
 */
public class ControladorProducto {
    Cargador c;
    
    public ControladorProducto() throws SQLException{
    c = new Cargador();
    }
   public Producto cCreaObjetoProducto(String prodnom,float prodprecio,String prodtipo, String prodcoment){
   Producto p = new Producto(prodnom,prodprecio,prodtipo,prodcoment);
   return p;
   }
   public void cCreaProducto(Producto p) throws SQLException{
   c.creaProducto(c.getIdProd(),p.getProdNom() , p.getProdPrecio() , p.getProdTipo(), p.getProdComent());
   }
   public void cBorraProducto(String prodNom) throws SQLException{
   c.borraProducto(prodNom);
   }
   public void cRestaStock(String prodNom,int cant) throws SQLException{
   c.quitarStock(prodNom ,cant);
   }
   public void cAgregarStock(String prodNom,int cant) throws SQLException{
   c.agregarStock(prodNom,cant);
   }  
}
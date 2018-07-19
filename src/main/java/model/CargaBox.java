package main.java.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CargaBox {
	
    Connect c;
    PreparedStatement ps;
    Statement s;
    ResultSet rs;
    
    public CargaBox() throws SQLException{
    	c = new Connect();
    }
    
    public ResultSet CargarStock() throws SQLException{
    	s = c.getConnection().createStatement();
    	rs = s.executeQuery("select * from productos");
    	return rs;
    	}
    
    public ResultSet CargarCompra(String codigoCompra) throws SQLException {
    	ps = c.getConnection().prepareStatement("select * from compraactual where codigoCompra=?") ;
    	ps.setString(1, codigoCompra);
    	rs = ps.executeQuery();
    	return rs;
    }
}
    


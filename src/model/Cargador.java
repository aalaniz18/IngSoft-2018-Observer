package model;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import resources.*;

import java.util.ArrayList;
import java.util.Collection;
//import java.util.Collection;
import java.util.HashMap;

public class Cargador {
	//Compra c1;
        CallableStatement cs;
	private BaseDeDatos bd;
	 Connect cn;
          ResultSet rs ;
    Statement s ;
	public Cargador() throws SQLException{
		bd= new BaseDeDatos();
                cn = new Connect();
                
	}
	
	public boolean validarAdmin(String usua, String pass) throws SQLException{ 
		
		
                
                  s = cn.getConnection().createStatement();
                rs = s.executeQuery ("select * from usuarios");          
                           while (rs.next()) 
{ 
if (rs.getString(2).toLowerCase().trim().equalsIgnoreCase(usua)&&rs.getString(3).toLowerCase().trim().equalsIgnoreCase(pass)){
return true;
}
} 
           
		return false;
	}
	
	public void cargarAdmin(Administrador a){
		bd.addAdministrador(a);
	}
	
	public BaseDeDatos getBase(){
		return bd;
	}
	
	public ArrayList<Integer> listarLibres(int id){
		HashMap<Integer,FuncionesCine> m=bd.getMapFuncion();
		FuncionesCine f= m.get(id);
		ArrayList<Integer> asientos= new ArrayList<Integer>();
		for(int i=0;i<f.getNAsientos();i++){
			if(f.getDesocupados()[i]==true){
				asientos.add(i);
			}	
		}
		return asientos;
	}


	public ArrayList<FuncionesCine> listarFunciones(){
		HashMap<Integer,FuncionesCine> m=bd.getMapFuncion();
		Collection<FuncionesCine> f;
		ArrayList<FuncionesCine> a= new ArrayList<FuncionesCine>();
		f=m.values();
		a=(ArrayList<FuncionesCine>) f;
		return a;
	}
	
	
	public void iniciaCompra(){
		Compra c1= new Compra();
		this.getBase().addCompra(c1);
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
        public void quitarStock (String prodNom,int cant) throws SQLException{
        cs= cn.getConnection().prepareCall("{call RestaStock(?,?)}");
        cs.setString("nombreProd", prodNom);
        cs.setInt("Cantidad", cant);
        cs.executeUpdate();
        System.out.println("c borro");
        }
        public void agregarStock (String prodNom,int cant) throws SQLException{
        cs= cn.getConnection().prepareCall("{call SumaStock(?,?)}");
        cs.setString("nombreProd", prodNom);
        cs.setInt("Cantidad", cant);
        cs.executeUpdate();
        System.out.println("c agrego");
        }
	
}

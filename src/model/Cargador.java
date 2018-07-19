package model;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import resources.*;
import view.ViewObserver;

import java.util.ArrayList;
import java.util.Collection;
//import java.util.Collection;
import java.util.HashMap;

public class Cargador implements ModelSubject{
	//Compra c1;
	private ArrayList<ViewObserver> observers;
	CallableStatement cs;
	private BaseDeDatos bd;
	Connect cn;
    ResultSet rs ;
    PreparedStatement ps;
    Statement s ;
	public Cargador() throws SQLException{
		observers= new ArrayList<ViewObserver>();
		bd= new BaseDeDatos();
        cn = new Connect();
                
	}
	
	public boolean validarAdmin(String usua, String pass) throws SQLException{ 
		s = cn.getConnection().createStatement();
                rs = s.executeQuery ("select * from usuarios where UsuTipo='a'");          
              
                while (rs.next()){
                 if (rs.getString(2).toLowerCase().trim().equalsIgnoreCase(usua)&&rs.getString(3).toLowerCase().trim().equalsIgnoreCase(pass)){
                 return true;
                }
        }  
           
		return false;
	}
	public boolean validarEmpleado(String usua, String pass) throws SQLException{ 
		s = cn.getConnection().createStatement();
                rs = s.executeQuery ("select * from usuarios where UsuTipo='e'");          
              
                while (rs.next()){
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
        System.out.println("c quito");
        }
    
    public void agregarStock(String prodNom,int cant) throws SQLException{
        cs= cn.getConnection().prepareCall("{call SumaStock(?,?)}");
        cs.setString("nombreProd", prodNom);
        cs.setInt("Cantidad", cant);
        cs.executeUpdate();
        System.out.println("c agrego");
        }
        
	public void creaUser (String user,String pass, String tipo) throws SQLException{
        cs = cn.getConnection().prepareCall("{call CreaUsuario(?,?,?)}");
        cs.setString("username", user);
        cs.setString("pass", pass);
        cs.setString("tipouser", tipo);
        cs.executeUpdate();
        System.out.println("c creo");
        }
	
    public void borraUser (String user) throws SQLException{
        cs = cn.getConnection().prepareCall("{call BorraUsuario(?)}");
        cs.setString("username", user);
        cs.executeUpdate();
        System.out.println("c borro");  
        }
    
    public void creaProducto (int prodid,String prodnom,double prodprecio,String prodtipo, String prodcoment) throws SQLException{
        cs = cn.getConnection().prepareCall("{call CreaProducto(?,?,?,?,?)}");
        cs.setInt("prodid", prodid);
        cs.setString("prodnom", prodnom);
        cs.setDouble("prodprecio", prodprecio);
        cs.setString("prodtipo", prodtipo);
        cs.setString("prodcoment", prodcoment);
        cs.executeUpdate();
                System.out.println("c creo");
        }
    
    public void borraProducto (String prodnom) throws SQLException{
        cs = cn.getConnection().prepareCall("{call BorraProducto(?)}");
        cs.setString("prodnom", prodnom);
        cs.executeUpdate();
                System.out.println("c borro");
        }
        
    public int getIdProd() throws SQLException{
        s = cn.getConnection().createStatement();
        rs = s.executeQuery ("SELECT ProdId FROM productos ORDER BY ProdId DESC limit 1;");          
        while (rs.next()){return rs.getInt(1)+1;}
        return 0;        
        }
        
    public int getCantidad(int idProd) throws SQLException {
        	ps = cn.getConnection().prepareStatement("select ProdCant from productos where ProdId=? limit 1");
        	ps.setInt(1, idProd);
        	rs = ps.executeQuery();
        	int cant = 0;
        	while (rs.next()){
        		cant=rs.getInt(1);
        		}
        	return cant;
        }
        
    public void agregaItem(String codigoCompra,int idProd,String descProd,int cantidad,double prodPrecio,double precFinal) throws SQLException{
        cs = cn.getConnection().prepareCall("{call agregaItem(?,?,?,?,?,?)}");
        cs.setString("codigoCompra", codigoCompra);
        cs.setInt("idProd", idProd);
        cs.setString("descProd", descProd);
        cs.setInt("cantidad", cantidad);
        cs.setDouble("prodPrecio", prodPrecio);
        cs.setDouble("precFinal", precFinal);
        cs.executeUpdate();
        }
        
    public ResultSet obtenerCompra(String codigoCompra) throws SQLException{
        ps = cn.getConnection().prepareStatement("select * from compras where codigoCompra = ?");
        ps.setString(1, codigoCompra);
        rs = ps.executeQuery();
        return rs;
        }
        
    public int getIdRs(ResultSet rs, String ProdNom) throws SQLException {
        while (rs.next()){
            if (rs.getString(2).equalsIgnoreCase(ProdNom))
            {
            return rs.getInt(1);
            }
        }
        return 0;
    }
        
    public double getPrecio(int idProd) throws SQLException{
        ps = cn.getConnection().prepareStatement("select prodPrecio from productos where ProdId = ?");
                ps.setDouble(1, idProd);
               rs = ps.executeQuery();
               while (rs.next()){
               return rs.getDouble(1);
               } 
            return 0;
        }
        
    public ResultSet stockProd(String s) {
        	try {
				Statement sta= cn.getConnection().createStatement();
				return sta.executeQuery (s);
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
        }
        
        @Override
	public void registerObserver(ViewObserver o) {
			observers.add(o);			
		}

		@Override
	public void removeObserver(ViewObserver o) {
			int i= observers.indexOf(o);
			if(i>=0) {
				observers.remove(i);
			}
		}

		@Override
	public void notifyObserver() {
			for(int i=0; i<observers.size(); i++) {
				ViewObserver observer = (ViewObserver) observers.get(i);
				observer.update();
			}
		}
}

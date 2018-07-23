package main.java.model;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import main.java.resources.*;

import java.util.Date;
import java.util.ArrayList;

import java.util.HashMap;

import main.java.resources.Compra;
import main.java.resources.Generador;
import main.java.view.ViewObserver;

public class Cargador implements ModelSubject{

	private ArrayList<ViewObserver> observers;
	CallableStatement cs;
	Connect cn;
    ResultSet rs ;
    PreparedStatement ps;
    Statement s ;
    ArrayList<Compra> compraEmpleado;
    ArrayList<Compra> compraCliente;
    CargaBox cb;
    
	public Cargador() throws SQLException{
		observers= new ArrayList<ViewObserver>();
		compraEmpleado=new ArrayList<Compra>();
		compraCliente=new ArrayList<Compra>();
        cn = new Connect();
        cb= new CargaBox();           
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
		     if (rs.getString(2).equalsIgnoreCase(usua)&&rs.getString(3).equalsIgnoreCase(pass)){
		    	 return true;
		     }
	    }          
		return false;
	}
	
	public void cargarAdmin(String user, String pass) throws SQLException{
		cs=cn.getConnection().prepareCall("call crearAdmin(?,?)");
		cs.setString(1, user);
		cs.setString(2, pass);
		cs.executeUpdate();
	}
	
//	public void crearCode(Compra c){
//		Generador g= new Generador();
//		c.setCodigo(g.creaCode());
//	}
	
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
        while (rs.next()){
        	return rs.getInt(1)+1;
        	}
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
        
    public void agregaItem(int idProd,String descProd,int cantidad,double prodPrecio,double precFinal, String codigoCompra) throws SQLException{
        cs = cn.getConnection().prepareCall("{call agregaItem(?,?,?,?,?,?)}");
        cs.setInt("idProd", idProd);
        cs.setString("descProd", descProd);
        cs.setInt("cantidad", cantidad);
        cs.setDouble("prodPrecio", prodPrecio);
        cs.setDouble("precFinal", precFinal);
        cs.setString("codigoCompra", codigoCompra);
        cs.executeUpdate();
        }
        
    public ResultSet obtenerCompra(String codigoCompra) throws SQLException{
        ps = cn.getConnection().prepareStatement("select * from compraactual where codigoCompra = ?");
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
    
    public CargaBox getCargaBox(){
    	return cb;
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
		
	public ResultSet getAsientos(int idPelicula) throws SQLException{
		s = cn.getConnection().createStatement();
        rs = s.executeQuery("select * from entradasPelicula where ocupado = 0");
        return rs;
   }
	
   public ResultSet getPeliculas() throws SQLException{//OK!
       s = cn.getConnection().createStatement();
       rs = s.executeQuery("select * from peliculas");
       return rs;
   }
   
   public int getIdPelicula(String nomPelicula)throws SQLException{
	   int id=0;
	   ps=cn.getConnection().prepareStatement("select idPelicula from peliculas where nomPelicula= ?");
	   ps.setString(1, nomPelicula);
	   rs=ps.executeQuery();
	   while(rs.next()){
		   id=rs.getInt(1);
	   }
	   return id;
   }
      
   public ResultSet getRecibo(String codCompra) throws SQLException{
       ps = cn.getConnection().prepareStatement("select * from compraactual where codCompra = ?");
       ps.setString(0,codCompra);
       rs = ps.executeQuery();
       return rs;
   }
      
   public void setOcupado(int idPelicula,int idAsiento) throws SQLException{
       //int idAsiento= this.getIdAsiento(fila, columna);
       cs = cn.getConnection().prepareCall("call setOcupado(?,?)");
       cs.setInt("p_idPelicula",idPelicula);
       cs.setInt("p_idAsiento",idAsiento);
       cs.executeUpdate();
   }
      
   public ResultSet CargarStock() throws SQLException{
		s = cn.getConnection().createStatement();
		rs = s.executeQuery("select * from productos");
		return rs;
   }

	public ResultSet CargarCompra(String codigoCompra) throws SQLException {
		ps = cn.getConnection().prepareStatement("select * from compraactual where codigoCompra = ?") ;
		ps.setString(1, codigoCompra);
		rs = ps.executeQuery();
		return rs;
	}
	
	public void GuardarCompra(Compra objCompra){
		compraCliente.add(objCompra);
	}
	public void GuardarCompraEmpleado(Compra objCompra){
		compraEmpleado.add(objCompra);
	}
	
	public Compra getObjCompra(){
		return compraCliente.get(0);
	}
	public Compra getObjCompraEmpleado(){
		return compraEmpleado.get(0);
	}
	
	public ResultSet getUsuarios() throws SQLException{
		s = cn.getConnection().createStatement();
		rs =s.executeQuery("select * from usuarios");
		return rs;
	}
	
	public void imprimirUsers() throws SQLException{
		ResultSet users=getUsuarios();
		while(users.next()){
			System.out.println("user:"+users.getString(2)+" || pass: "+users.getString(3));
       }
	}
       public void comprarEntrada(int idPelicula,String codCompra,String Fila,int Columna) throws SQLException{
       cs = cn.getConnection().prepareCall("call comprarPelicula(?,?,?,?)");
       cs.setInt("idPelicula", idPelicula);
       cs.setString("codCompra", codCompra);
       cs.setString("fila", Fila);
       cs.setInt("columna", Columna);
       cs.executeUpdate();
       
       }
        
        public int getIdAsiento(String Fila, int Columna){
        if(Fila.equalsIgnoreCase("A")) return 0*8+Columna ;
        if(Fila.equalsIgnoreCase("B")) return 1*8+Columna ;
        if(Fila.equalsIgnoreCase("C")) return 2*8+Columna ;
        if(Fila.equalsIgnoreCase("D")) return 3*8+Columna ;
        if(Fila.equalsIgnoreCase("E")) return 4*8+Columna ;
        if(Fila.equalsIgnoreCase("F")) return 5*8+Columna ;
        if(Fila.equalsIgnoreCase("G")) return 6*8+Columna ;
        if(Fila.equalsIgnoreCase("H")) return 7*8+Columna ;
        if(Fila.equalsIgnoreCase("I")) return 8*8+Columna ;
        if(Fila.equalsIgnoreCase("J")) return 9*8+Columna ;
        return 0;
        }
        
        public boolean estaOcupado(int idPelicula,int idAsiento) throws SQLException{
        	System.out.println(idPelicula+"---"+idAsiento);
        ps = cn.getConnection().prepareStatement("select ocupado from entradasPelicula where idPelicula = ? and idAsiento = ?");
        ps.setInt(1, idPelicula);
        ps.setInt(2, idAsiento);
        rs= ps.executeQuery();
        int ocupado=0;
        while(rs.next()){
        ocupado=rs.getInt(1);
        }
        if (ocupado == 0)
            return false;
                    else 
            return true;
        }
        
        //metodos de finalizar compra
        //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
        
        
        public void finalizarCompra(String codCompra) throws SQLException{
            cs = cn.getConnection().prepareCall("call finalizarCompra(?,?,?,?)");
            cs.setString("codCompra",codCompra);
            cs.setString("descCompra", this.getDescVenta(codCompra));
            cs.setDouble("totalPrecio", this.getPrecioFinal(codCompra));
            cs.setDate("fechasys",(java.sql.Date) getFecha());
            cs.executeUpdate();
        }
        
        public ResultSet GenerarRecibo(String codCompra) throws SQLException{
    		ps = cn.getConnection().prepareStatement("select * from recibos where codCompra = ?");
    		ps.setString(1, codCompra);
    		rs= ps.executeQuery();
    		return rs;
    	}
        
        public ResultSet getCompraFinalizada(String codCompra) throws SQLException{
            ps = cn.getConnection().prepareStatement("select * from comprasfinalizadas where codigoCompra = ?");
            ps.setString(1,codCompra);
            rs = ps.executeQuery();
            return rs;
        }
        public String getDescVenta(String codCompra) throws SQLException{
			ps = cn.getConnection().prepareStatement("select descProd from compraactual where codigoCompra = ?");
	        ps.setString(1,codCompra);
	        rs = ps.executeQuery();
	        String text="";
	        while(rs.next()){
	        	text= text + rs.getString(1);	        	
	        }
        	return text;
        	}
        
        public double getPrecioFinal(String codCompra) throws SQLException{
        double preciofinal=0.0;
        ps = cn.getConnection().prepareStatement("select precFinal from compraactual where codigoCompra=?");
        ps.setString(1,codCompra);
        rs = ps.executeQuery();
        while(rs.next()){
        	preciofinal = preciofinal + rs.getDouble(1)    ;    	
        }
        	return preciofinal;
        }
        
        public Date getFecha()throws SQLException{
        	Date fec=null;
        	s = cn.getConnection().createStatement();
        	rs = s.executeQuery("select SYSDATE()");
        	while(rs.next()){
        		fec = rs.getDate(1);
        	}
        	return fec;
        }
        public Date getFechaCompra(String codCompra)throws SQLException{
        	Date fec=null;
        	ps = cn.getConnection().prepareStatement("select HoraVenta from comprasfinalizadas where codigoCompra = ?");
        	ps.setString(1, codCompra);
        	rs = ps.executeQuery();
        	while(rs.next()){
        		fec = rs.getDate(1);
        	}
        	return fec;
        	}
        public void setEmpleado(int empleado,String formaPago,String codCompra) throws SQLException{
        	cs = cn.getConnection().prepareCall("call setTipoCompra(?,?,?)");
        	cs.setInt(1, empleado);
        	cs.setString(2, formaPago);
        	cs.setString(3, codCompra);
        	cs.executeUpdate();
                notifyObserver();
        }
        public ResultSet getTablaObserver() throws SQLException{
        s = cn.getConnection().createStatement();
        rs = s.executeQuery("select codigoCompra,formaPago,horaVenta,montoVenta from comprasfinalizadas where empleado = 1");
        return rs;
        }
        
        public void renovarClave(int idUsuario, String newPass) throws SQLException{
        cs = cn.getConnection().prepareCall("call newPass(?,?)");
        cs.setInt("idUsuario", idUsuario);
        cs.setString("newPass", newPass);
        cs.executeUpdate();
        }
        public int getIdUsuario(String user, String pass) throws SQLException{
        ps = cn.getConnection().prepareStatement("select idUsuarios from usuarios where UsuNombre=? and UsuClave=?");
        ps.setString(1, user);
        ps.setString(2, pass);
        rs=ps.executeQuery();
        int id=0;
        while(rs.next()){
        id = rs.getInt(1);
        }
        return id;
        }
      
            
            
	
}

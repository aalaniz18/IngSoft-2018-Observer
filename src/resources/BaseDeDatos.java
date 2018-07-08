package resources;
import java.util.HashMap;

public class BaseDeDatos {
	HashMap<String,String> admin;
	HashMap<String, String> empleados;
	HashMap<String,Compra> compras;
	HashMap<Integer,FuncionesCine> funciones;
        HashMap<String,String> productos;

	
	public BaseDeDatos(){
	admin= new HashMap<String, String>(1);
	empleados= new HashMap<String,String>();
	compras= new HashMap<String,Compra>();
	funciones= new HashMap<Integer,FuncionesCine>();
        productos= new HashMap<String,String>();
	}
	
	public void addEmpleado(Empleado e){
		empleados.put(e.getUsuario(),e.getPass());}
	
	public void addAdministrador(Administrador a){
		admin.put(a.getUsuario(),a.getPass());}
	
	public void addCompra(Compra c){
		compras.put(c.getCod(), c);}
	
	public void addFuncion(FuncionesCine f){
		funciones.put(f.getID(),f);}
       
	
	public HashMap<String,String> getMapAdmin(){
		return admin;}
	
	public HashMap<String,String> getMapEmpl(){
		return empleados;}
	
	public HashMap<String, Compra> getMapCompra(){
		return compras;}
	
	public HashMap<Integer, FuncionesCine> getMapFuncion(){
		return funciones;}
        public HashMap<String, String> getMapProductos(){
        return productos;
        }
}

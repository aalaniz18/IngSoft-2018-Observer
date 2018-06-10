import java.util.HashMap;

public class BaseDeDatos {
	HashMap<String,String> admin;
	HashMap<String, String> empleados;
	
	public BaseDeDatos(){
	admin= new HashMap<String, String>(1);
	empleados= new HashMap<String,String>();
	}
	
	public void addEmpleado(Empleado e){
		empleados.put(e.getUsuario(),e.getPass());}
	
	public void addAdministrador(Administrador a){
		admin.put(a.getUsuario(),a.getPass());}
	
	public HashMap<String,String> getMapAdmin(){
		return admin;
	}
	
	public HashMap<String,String> getMapEmpl(){
		return empleados;
	}
}

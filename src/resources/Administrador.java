package resources;

public class Administrador {
	private String usuario;
	private String contrasena;
	private String nombre;
	private static int contadorInstancia;
	private static Administrador instancia;
	
	public Administrador(String u, String c, String n){
		usuario=u;
		contrasena=c;
		nombre=n;
		contadorInstancia=0;
	}
	
	public Administrador(){
		contadorInstancia=0;
	}
	
	public static void crearInstancia(){
		if(instancia==null){
			instancia= new Administrador();
		}
	}
	
	public static Administrador getInstancia(){
		contadorInstancia++;
		if(instancia==null){
			crearInstancia();
		}
		return instancia;
	}
	
	public void setUsuario(String a, String b, String c){
		usuario=a;
		contrasena=b;
		nombre=c;
	}
	
	public void setPass(String c){
		contrasena=c;}
	
	public String getUsuario(){
		return usuario;
	}
	
	public String getPass(){
		return contrasena;}
}

package model;
import resources.*;

import java.util.ArrayList;
import java.util.Collection;
//import java.util.Collection;
import java.util.HashMap;

public class Cargador {
	//Compra c1;
	private BaseDeDatos bd;
	
	public Cargador(){
		bd= new BaseDeDatos();
	}
	
	public boolean validarAdmin(String usua, String pass){ 
		boolean exito = false;
		HashMap<String,String> m=bd.getMapAdmin();
		if(m.containsKey(usua)){
			exito = pass == m.get(usua);
		}
		return exito;
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

	
}

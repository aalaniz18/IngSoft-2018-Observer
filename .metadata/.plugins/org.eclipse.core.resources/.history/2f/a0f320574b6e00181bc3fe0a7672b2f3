package test.java;
import resources.*;
import model.*;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class PruebaAsientosDisp {

	@Test
	public void testTrue() {
		Cargador c= new Cargador();
		FuncionesCine f= new FuncionesCine(20);
		f.setID(5);
		f.cargarDisponibles();
		int res=new Random().nextInt(f.getNAsientos());
		for(int i=0;i<res;i++){
			f.setOcupado(i);
		}
		c.getBase().addFuncion(f);
		
		assertTrue (f.getNAsientos()-res==c.listarLibres(5).size());
	}

}

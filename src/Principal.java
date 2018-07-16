import java.sql.SQLException;

import controller.*;
import view.*;
import model.*;
import resources.Administrador;


public class Principal {
	
	public static void main (String[] args) {
		Administrador A=Administrador.getInstancia("admin", "admin");
		Home h= new Home();
		Cargador c;
		try {
			c = new Cargador();
		} catch (SQLException e) {
			c=null;
			e.printStackTrace();
		}			//Tira error porque no se especifico el throw del mysql exception
		ControllerInterface controller = new ControllerCine(c,h);
		h.cambiarController(controller);
		controller.iniciar();
		}

}

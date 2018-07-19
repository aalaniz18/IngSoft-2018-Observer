package main.java;

import java.sql.SQLException;

import main.java.controller.*;
import main.java.controller.ControllerCine;
import main.java.controller.ControllerInterface;
import main.java.model.Cargador;
import main.java.resources.Administrador;
import main.java.view.Home;
import main.java.view.*;
import main.java.model.*;


public class Principal {
	
	public static void main (String[] args) throws SQLException {
		Administrador A=Administrador.getInstancia("pepito", "1234");
		Home h= new Home();
		Cargador c= new Cargador();
			//Tira error porque no se especifico el throw del mysql exception
		c.cargarAdmin(A.getUsuario(),A.getPass());
		ControllerInterface controller = new ControllerCine(c,h);
		h.cambiarController(controller);
		controller.iniciar();
		}

}

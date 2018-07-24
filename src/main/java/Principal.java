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
		Administrador a=Administrador.getInstancia("pepito", "1234");
		//Administrador B=Administrador.getInstancia("alvaro", "alaniz");
		Home h= new Home();
		Cargador c=new Cargador();
		c.cargarAdmin(a.getUsuario(),a.getPass());
		ControllerInterface controller = new ControllerCine(c,h);
		h.cambiarController(controller);
		controller.iniciar();
		}

}

package main.java.controller;

import java.sql.SQLException;

import main.java.model.Cargador;
import main.java.model.Login;
import main.java.view.Home;
import main.java.view.Pago;
import main.java.view.FormaPago;


public class ControladorLogin{
	Cargador c;

	public ControladorLogin() throws SQLException{
		c = new Cargador();
		}
	
	public Login cCreaObjetoLogin(String user,String pass,String tipo){
		Login login = new Login(user,pass,tipo);
		return login;
	}
//	
//	public void cValidarLoginAdmin(Login l) throws SQLException{
//		c.validarAdmin(l.getUser(), l.getPass());
//	}
//
//	public void cValidarLoginEmpleado(Login l) throws SQLException{
//		c.validarEmpleado(l.getUser() , l.getPass());
//	}
}

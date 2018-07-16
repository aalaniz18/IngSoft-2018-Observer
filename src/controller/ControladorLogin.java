package controller;

import java.sql.SQLException;
import model.Cargador;
import model.Login;
import view.Home;
import view.PAGO;
import view.formaPago;


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

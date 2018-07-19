package main.java.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.model.Cargador;
import main.java.view.CargaStock;
import main.java.view.Compra;
import main.java.view.CompraTickets_v1;
import main.java.view.ConsultaStock;
import main.java.view.GenerarCompra;
import main.java.view.Home;
import main.java.view.HomeAdmin;
import main.java.view.HomeCliente;
import main.java.view.Login;
import main.java.view.PAGO;
import main.java.view.RecibirTiket;
import main.java.view.formaPago;
import main.java.view.recibo;
import main.java.view.*;

public class ControllerAdmin implements ControllerInterface{
	Cargador model;
    Home view;
	
	public ControllerAdmin(Cargador model, Home view){
		this.model=model;
		this.view=view;
	}

	@Override
	public void iniciar() { //OK!
	}

	@Override
	public void cambiarALogin(Home v) {//OK!
		v.setVisible(false);
		Login l = new Login(this);
        l.setVisible(true);
	}

	@Override
	public void cambiarAHome2(Home v) {	//OK!
	}

	@Override
	public void cambiarAHome(Login l) { //OK!
		l.setVisible(false);
		Home h= new Home();
		h.cambiarController(this);
		//h.initComponents();
		h.setVisible(true);
	}

	@Override
	public void cambiarAPago(formaPago fp) {//OK!
	}

	@Override
	public void cambiarAFormaPago(PAGO p) {//OK!
	}

	@Override
	public Cargador getModel() {//OK!
		return model;
	}

	@Override
	public void cambiarAHome2(Login l) {//OK!
		l.setVisible(false);
		HomeAdmin cs =new HomeAdmin(this);
		cs.setVisible(true);
	}

	@Override
	public boolean esValido(String a, String b){
		try{
			return model.validarAdmin(a,b);}
		catch (SQLException e){
			return false;
		}
		//return true;
	}

	@Override
	public void cambiarALogin(HomeAdmin h) {//OK!
		h.setVisible(false);
    	Login l = new Login(this);
    	l.setVisible(true);
	}

	@Override
	public void cambiarACargaStock(HomeAdmin h) {//OK!
		h.setVisible(false);
    	CargaStock cs = new CargaStock(this);
    	cs.setVisible(true);
	}

	@Override
	public void cambiarAConsultaStock(HomeAdmin h) {//OK!
		h.setVisible(false);
    	ConsultaStock cs = new ConsultaStock(this);
    	cs.setVisible(true);
	}

	@Override
	public void cambiarAHomeAdmin(ConsultaStock cs) {//OK!
		cs.setVisible(false);
    	HomeAdmin h = new HomeAdmin(this);
    	h.setVisible(true);	
	}

	@Override
	public void cambiarAHomeAdmin(CargaStock cs) {//OK!
		cs.setVisible(false);
    	HomeAdmin h = new HomeAdmin(this);
    	h.setVisible(true);
	}

	@Override
	public void cambiarAPelicula(GenerarCompra gc) {//OK!
	}

	@Override
	public void cambiarAHome(GenerarCompra gc) {//OK!
	}

	@Override
	public void cambiarAFormaPago(Compra c) {//OK!
	}

	@Override
	public void cambiarACompraTickets(Compra c) {//OK!
	}

	@Override
	public void cambiarACompra(formaPago fp) {//OK!
	}

	@Override
	public void cambiarAHome2(CompraTickets_v1 compraTickets_v1) {//OK!
	}

	@Override
	public void cambiarACompra(CompraTickets_v1 ct) {//OK!
	}

	@Override
	public void cambiarAConfirma(formaPago fp) {//OK!	
	}

	@Override
	public void cambiarAConfirma(PAGO p) {//OK!
	}

	@Override
	public void cambiarAFormaPago(recibo r) {//OK!
	}

	@Override
	public void cambiarAHome2(recibo r) {//OK!
	}
	
	@Override
	public void cambiarAPelicula(HomeCliente hc) {//OK!
	}
	
	@Override
	public void cambiarARecTick(GenerarCompra gc) {//OK!
	}
	
	@Override
	public void cambiarAHomeEmpleado(RecibirTiket rt) {
	}
	
	@Override
	public ResultSet getRSProd(String s) {
		try {
			return model.CargarStock();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean agregarStock(String prodNom,int cant){
		try {
			model.agregarStock(prodNom,cant);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			}
	}
	
	@Override
	public boolean quitarStock(String nombre, int cant) {
		try {
			model.quitarStock(nombre, cant);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean addProducto(String nombre, double precio, String string, String string2) {
		int id;
		try {
			id = model.getIdProd();
			model.creaProducto(id, nombre, precio, string, string2);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean clearProducto(String text) {
		try{
			model.borraProducto(text);
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ResultSet getRSStock() {//OK!!
		return null;
	}
	
}

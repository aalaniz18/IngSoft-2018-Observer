package main.java.controller;
import main.java.view.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.model.Cargador;
import main.java.model.Connect;
import main.java.resources.Compra;
import main.java.view.CargaStock;
import main.java.view.CompraView;
import main.java.view.CompraTickets_v1;
import main.java.view.ConsultaStock;
import main.java.view.HomeEmpleado;
import main.java.view.Home;
import main.java.view.HomeAdmin;
import main.java.view.HomeCliente;
import main.java.view.Login;
import main.java.view.Pago;
import main.java.view.RecibirTiket;
import main.java.view.FormaPago;
import main.java.view.Recibo;
import main.java.model.*;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;

public class ControllerCine implements ControllerInterface{
	Cargador model;
    Home view;
    String args = "iniciar";
    Connect c;
	
	public ControllerCine(Cargador model, Home view){
		this.model=model;
		this.view=view;
		//iniciar();
	}
	
	public void iniciar(){
//            try {	
//                c = new Connect();
//            } catch (SQLException ex) {
//                Logger.getLogger(ControllerCine.class.getName()).log(Level.SEVERE, null, ex);
//            }
            //Home h = new Home();
            view.initComponents();
            view.setVisible(true);     
	}

	public void cambiarAHome2(Home v) {//OK!
		v.setVisible(false);
		HomeCliente hc= new HomeCliente(this);
		hc.setVisible(true);
	}
	
	@Override
	public void cambiarACompra(CompraTickets_v1 ct) {//OK!
		ct.setVisible(false);
		CompraView c;
		try {
			c = new CompraView(this);
		} catch (SQLException e) {
			c=null;
			e.printStackTrace();
		}
		c.setVisible(true);
	}
	
	@Override
	public void cambiarAFormaPago(CompraView c) {//OK!
		c.setVisible(false);
		FormaPago fp= new FormaPago(this);
		fp.setVisible(true);
	}
	
	public void cambiarAPago(FormaPago fp) {//OK!
		fp.setVisible(false);
		Pago p= new Pago(this);
		p.setVisible(true);
	}
	
	public void	cambiarAFormaPago(Pago p) {//OK!
		p.setVisible(false);
		FormaPago fp=new FormaPago(this);
		fp.setVisible(true);
	}
	
	@Override
	public void cambiarACompra(FormaPago fp) {//OK!
		fp.setVisible(false);
		CompraView c;
		try {
			c = new CompraView(this);
		} catch (SQLException e) {
			c=null;
			e.printStackTrace();
		}
		c.setVisible(true);
	}
	
	@Override
	public void cambiarACompraTickets(CompraView c) {//OK!
		c.setVisible(false);
		CompraTickets_v1 ct;
		try {
			ct = new CompraTickets_v1(this);
		} catch (SQLException e) {
			e.printStackTrace();
			ct=null;
		}
		ct.setVisible(true);
	}
	
	@Override
	public void cambiarAHome2(CompraTickets_v1 ct) {//OK!
		ct.setVisible(false);
		HomeCliente hc= new HomeCliente(this);
		hc.setVisible(true);
	}
	
	public void cambiarAHome(Login l) {//OK!
	}
	
	public void	cambiarALogin(Home v) {//OK!
	}
	
	public Cargador getModel(){//OK!
		return model;
	}

	@Override
	public void cambiarAHome2(Login l) {//OK!
	}

	@Override
	public boolean esValido(String a, String b) {//OK!
		return false;
	}

	@Override
	public void cambiarALogin(HomeAdmin home) {//OK!	
	}

	@Override
	public void cambiarACargaStock(HomeAdmin h) {//OK!	
	}

	@Override
	public void cambiarAConsultaStock(HomeAdmin h) {//OK!
	}

	@Override
	public void cambiarAHomeAdmin(ConsultaStock cs) {//OK!	
	}

	@Override
	public void cambiarAHomeAdmin(CargaStock cs) {//OK!
	}
	
	@Override
	public void cambiarAPelicula(HomeEmpleado gc) {//OK!
	}

	@Override
	public void cambiarAHome(HomeEmpleado gc) {//OK!
	}

	@Override
	public void cambiarAConfirma(FormaPago fp) {
		fp.setVisible(false);
		Recibo r=new Recibo(this);
		r.setVisible(true);
	}

	@Override
	public void cambiarAConfirma(Pago p) {//OK!
		p.setVisible(false);
		Recibo r=new Recibo(this);
		r.setVisible(true);
	}
	
	@Override
	public void cambiarAFormaPago(Recibo r) {//OK!
		r.setVisible(false);
		FormaPago fp=new FormaPago(this);
		fp.setVisible(true);
	}

	@Override
	public void cambiarAHome2(Recibo r) {//OK!
		r.setVisible(false);
		HomeCliente hc= new HomeCliente(this);
		hc.setVisible(true);
	}

	@Override
	public void cambiarAPelicula(HomeCliente hc) {
		hc.setVisible(false);
		CompraTickets_v1 ct;
		try {
			ct = new CompraTickets_v1(this);
		} catch (SQLException e) {
			e.printStackTrace();
			ct=null;
		}
		ct.setVisible(true);
	}	
	
	@Override
	public void cambiarARecTick(HomeEmpleado gc) {//OK!
	}
	
	@Override
	public void cambiarAHomeEmpleado(RecibirTiket rt) {
	}

	@Override
	public ResultSet getRSProd(String s) {
		return null;
	}

	@Override
	public boolean agregarStock(String nombre, int cant) {
		return false;
	}
	
	@Override
	public boolean quitarStock(String nombre, int cant) {
		return false;
	}

	@Override
	public boolean addProducto(String nombre, double precio, String string, String string2) {
		return false;
	}
	
	@Override
	public boolean clearProducto(String text) {
		return false;
	}

	@Override
	public ResultSet getRSStock() {
		try {
			return model.getCargaBox().CargarStock();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ResultSet setPelisBox() {
		try {
			return model.getPeliculas();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public boolean esDisponible(int idPelicula, int idAsiento) {
		try {
			return model.estaOcupado(idPelicula,idAsiento);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void iniciarCompra(int idPelicula,String fila, int columna) {
		String codigoCompra= model.getObjCompra().getCodigo();
		try {
			model.comprarEntrada(idPelicula, codigoCompra,fila,columna);
			
			model.setOcupado(idPelicula, model.getIdAsiento(fila, columna));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Compra getCompraActual() {
		return model.getObjCompraEmpleado();
	}
	
}

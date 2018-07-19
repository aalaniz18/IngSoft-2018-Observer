package controller;
import view.*;
import view.Login;

import java.sql.ResultSet;

import model.*;
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
		Compra c= new Compra(this);
		c.setVisible(true);
	}
	
	@Override
	public void cambiarAFormaPago(Compra c) {//OK!
		c.setVisible(false);
		formaPago fp= new formaPago(this);
		fp.setVisible(true);
	}
	
	public void cambiarAPago(formaPago fp) {//OK!
		fp.setVisible(false);
		PAGO p= new PAGO(this);
		p.setVisible(true);
	}
	
	public void	cambiarAFormaPago(PAGO p) {//OK!
		p.setVisible(false);
		formaPago fp=new formaPago(this);
		fp.setVisible(true);
	}
	
	@Override
	public void cambiarACompra(formaPago fp) {//OK!
		fp.setVisible(false);
		Compra c=new Compra(this);
		c.setVisible(true);
	}
	
	@Override
	public void cambiarACompraTickets(Compra c) {//OK!
		c.setVisible(false);
		CompraTickets_v1 ct= new CompraTickets_v1(this);
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
	public void cambiarAPelicula(GenerarCompra gc) {//OK!
	}

	@Override
	public void cambiarAHome(GenerarCompra gc) {//OK!
	}

	@Override
	public void cambiarAConfirma(formaPago fp) {
		fp.setVisible(false);
		recibo r=new recibo(this);
		r.setVisible(true);
	}

	@Override
	public void cambiarAConfirma(PAGO p) {//OK!
		p.setVisible(false);
		recibo r=new recibo(this);
		r.setVisible(true);
	}
	
	@Override
	public void cambiarAFormaPago(recibo r) {//OK!
		r.setVisible(false);
		formaPago fp=new formaPago(this);
		fp.setVisible(true);
	}

	@Override
	public void cambiarAHome2(recibo r) {//OK!
		r.setVisible(false);
		HomeCliente hc= new HomeCliente(this);
		hc.setVisible(true);
	}

	@Override
	public void cambiarAPelicula(HomeCliente hc) {
		hc.setVisible(false);
		CompraTickets_v1 ct=new CompraTickets_v1(this);
		ct.setVisible(true);
	}	
	
	@Override
	public void cambiarARecTick(GenerarCompra gc) {//OK!
	}
	
	@Override
	public void cambiarAHomeEmpleado(RecibirTiket rt) {
	}

	@Override
	public ResultSet getRSProd(String s) {
		return null;
	}

	@Override
	public void agregarStock(String nombre, int cant) {
	}
	
}

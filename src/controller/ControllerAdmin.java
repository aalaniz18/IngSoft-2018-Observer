package controller;

import java.sql.SQLException;

import model.Cargador;
import view.*;

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
	public void cambiarAFormaPago(Confirma c) {//OK!
	}

	@Override
	public void cambiarAHome2(Confirma c) {//OK!
	}
	
	@Override
	public void cambiarAPelicula(HomeCliente hc) {//OK!
	}

}

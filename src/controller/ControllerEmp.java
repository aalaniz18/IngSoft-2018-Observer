package controller;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Cargador;
import view.*;

public class ControllerEmp implements ControllerInterface{
	Cargador model;
    Home view;
	
	public ControllerEmp(Cargador model, Home view){
		this.model=model;
		this.view=view;
	}

	@Override
	public void iniciar() {//OK!
	}

	@Override
	public void cambiarALogin(Home v) {//OK!
		v.setVisible(false);
		Login l = new Login(this);
        l.setVisible(true);
        //setborn("a");
	}
	
	@Override
	public void cambiarAHome(Login l) {//OK!
		l.setVisible(false);
		Home h= new Home();
		h.cambiarController(this);
		//h.initComponents();
		h.setVisible(true);
	}

	@Override
	public void cambiarAHome2(Login l) {//OK!
		l.setVisible(false);
		GenerarCompra gc =new GenerarCompra(this,this.getModel());
		gc.setVisible(true);	
	}
	
	@Override
	public void cambiarAHome(GenerarCompra gc) {//OK!
		gc.setVisible(false);
		Home h= new Home();
		h.cambiarController(this);
		//h.initComponents();
		h.setVisible(true);
	}
	
	@Override
	public void cambiarAHome2(CompraTickets_v1 ct) {
		ct.setVisible(false);
		GenerarCompra gc =new GenerarCompra(this,this.getModel());
		gc.setVisible(true);
	}

	@Override
	public void cambiarAHome2(Home v) {//OK!
	}

	@Override
	public void cambiarACompraTickets(Compra c) {//OK!
		c.setVisible(false);
		CompraTickets_v1 ct= new CompraTickets_v1(this);
		ct.setVisible(true);
	}

	@Override
	public void cambiarAPago(formaPago fp) {//OK!
		fp.setVisible(false);
		PAGO p= new PAGO(this);
		p.setVisible(true);
	}

	@Override
	public void cambiarAFormaPago(PAGO p) {//OK!
		p.setVisible(false);
		formaPago fp=new formaPago(this);
		fp.setVisible(true);
	}

	@Override
	public Cargador getModel() {//OK!
		return model;
	}

	@Override
	public boolean esValido(String a, String b) {
		try{
			return model.validarEmpleado(a,b);}
		catch (SQLException e){
			return false;
		}
		//return true;
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
	public void cambiarAFormaPago(Compra c) {//OK!
		c.setVisible(false);
		formaPago fp= new formaPago(this);
		fp.setVisible(true);
	}

	@Override
	public void cambiarACompra(formaPago fp) {//OK!
		fp.setVisible(false);
		Compra c=new Compra(this);
		c.setVisible(true);
	}

	@Override
	public void cambiarACompra(CompraTickets_v1 ct) {//OK!
		ct.setVisible(false);
		Compra c= new Compra(this);
		c.setVisible(true);
	}

	@Override
	public void cambiarAPelicula(GenerarCompra gc) {
		gc.setVisible(false);
		CompraTickets_v1 ct= new CompraTickets_v1(this);
		ct.setVisible(true);
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
		GenerarCompra gc= new GenerarCompra(this,this.getModel());
		gc.setVisible(true);
	}
	
	@Override
	public void cambiarAPelicula(HomeCliente hc) {//OK!
	}

	@Override
	public void cambiarARecTick(GenerarCompra gc) {
		gc.setVisible(false);
		RecibirTiket rt= new RecibirTiket(this);
		rt.setVisible(true);
	}

	@Override
	public void cambiarAHomeEmpleado(RecibirTiket rt) {
		rt.setVisible(false);
		GenerarCompra gc= new GenerarCompra(this,this.getModel());
		gc.setVisible(true);
	}

	@Override
	public ResultSet getRSProd(String s) {
		return null;
	}
	
	@Override
	public void agregarStock(String nombre, int cant) {
	}
	
}

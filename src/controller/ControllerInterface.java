package controller;

import model.Cargador;
import view.*;

public interface ControllerInterface {
	
	void iniciar();

	void cambiarALogin(Home home);
	
	void cambiarALogin(HomeAdmin home);
	
	void cambiarAHome2(Home v);
	
	void cambiarAPelicula(GenerarCompra gc);
	
	void cambiarAHome(Login l);
	
	void cambiarAHome(GenerarCompra gc);
	
	void cambiarACompraTickets(Compra c);
	
	void cambiarACompra(formaPago fp);
	
	void cambiarAFormaPago(PAGO p);
	
	void cambiarAFormaPago(Compra c);
	
	void cambiarACargaStock(HomeAdmin h);
	
	void cambiarAConsultaStock(HomeAdmin h);
	
	void cambiarAHomeAdmin(ConsultaStock cs);
	
	void cambiarAHomeAdmin(CargaStock cs);
	
	void cambiarAHome2(Login l);
	
	void cambiarAPago(formaPago fp);
	
	public Cargador getModel();
	
	boolean esValido(String a,String b);

	void cambiarAHome2(CompraTickets_v1 ct);

	void cambiarACompra(CompraTickets_v1 ct);

	void cambiarAConfirma(formaPago fp);

	void cambiarAConfirma(PAGO p);

	void cambiarAFormaPago(Confirma c);

	void cambiarAHome2(Confirma c);

	void cambiarAPelicula(HomeCliente hc);
	
}

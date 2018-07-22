package main.java.controller;

import java.sql.ResultSet;

import main.java.model.Cargador;
import main.java.view.CargaStock;
import main.java.view.CompraView;
import main.java.view.CompraTickets_v1;
import main.java.view.ConsultaStock;
import main.java.view.HomeEmpleado;
import main.java.view.Home;
import main.java.view.HomeAdmin;
import main.java.view.HomeCliente;
import main.java.view.Login;
import main.java.view.PAGO;
import main.java.view.RecibirTiket;
import main.java.view.FormaPago;
import main.java.view.Recibo;
import main.java.view.*;

public interface ControllerInterface {
	
	void iniciar();

	void cambiarALogin(Home home);
	
	void cambiarALogin(HomeAdmin home);
	
	void cambiarAHome2(Home v);
	
	void cambiarAPelicula(HomeEmpleado gc);
	
	void cambiarAHome(Login l);
	
	void cambiarAHome(HomeEmpleado gc);
	
	void cambiarACompraTickets(CompraView c);
	
	void cambiarACompra(FormaPago fp);
	
	void cambiarAFormaPago(PAGO p);
	
	void cambiarAFormaPago(CompraView c);
	
	void cambiarACargaStock(HomeAdmin h);
	
	void cambiarAConsultaStock(HomeAdmin h);
	
	void cambiarAHomeAdmin(ConsultaStock cs);
	
	void cambiarAHomeAdmin(CargaStock cs);
	
	void cambiarAHome2(Login l);
	
	void cambiarAPago(FormaPago fp);
	
	public Cargador getModel();
	
	boolean esValido(String a,String b);

	void cambiarAHome2(CompraTickets_v1 ct);

	void cambiarACompra(CompraTickets_v1 ct);

	void cambiarAConfirma(FormaPago fp);

	void cambiarAConfirma(PAGO p);

	void cambiarAFormaPago(Recibo r);

	void cambiarAHome2(Recibo r);

	void cambiarAPelicula(HomeCliente hc);
	
	void cambiarARecTick(HomeEmpleado gc);
	
	void cambiarAHomeEmpleado(RecibirTiket rt);
	
	ResultSet getRSProd(String s);

	boolean agregarStock(String nombre, int cant);

	boolean quitarStock(String nombre, int cant);

	boolean addProducto(String nombre, double precio, String string, String string2);

	boolean clearProducto(String text);

	ResultSet getRSStock();

	ResultSet setPelisBox();
	
	public boolean esDisponible(int idPelicula, int idAsiento);
	
	void iniciarCompra(int idPelicula, String fila, int columna);
	
	
}

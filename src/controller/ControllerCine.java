package controller;
import model.*;
import interfazJPANEL.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerCine implements ControllerInterface{
	Cargador model;
        Home view;
        String args = "iniciar";
        Connect c;
	public ControllerCine(){
        iniciar();
        }
	public ControllerCine(Cargador model, Home view){
		this.model=model;
		this.view=view;
	}
	
	public void iniciar(){
            try {	
                c = new Connect();
            } catch (SQLException ex) {
                Logger.getLogger(ControllerCine.class.getName()).log(Level.SEVERE, null, ex);
            }
            Home h = new Home();
                h.setVisible(true);
                
	}

}

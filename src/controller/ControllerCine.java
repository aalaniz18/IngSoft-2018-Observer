package controller;
import model.*;
import interfazJPANEL.*;

public class ControllerCine implements ControllerInterface{
	Cargador model;
        Home view;
        String args = "iniciar";
	public ControllerCine(){
        iniciar();
        }
	public ControllerCine(Cargador model, Home view){
		this.model=model;
		this.view=view;
	}
	
	public void iniciar(){
		Home h = new Home();
                h.setVisible(true);
	}

}

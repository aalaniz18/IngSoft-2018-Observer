/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author perez
 */
public class Login {
String user;
String pass;
String tipo;
       
    public Login(String user, String pass, String tipo){
    this.user = user;
    this.pass = pass;
    this.tipo = tipo;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getTipo() {
        return tipo;
    }
    
}

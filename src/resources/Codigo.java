package resources;

import java.util.Date;

public class Codigo {
	private String code;
	private Date inicial;
	
	public Codigo(String code){
		this.code=code;
		inicial= null;
	}
	
	public void setCode(String s){
		code=s;
	}

	public String getCode(){
		return code;
	}
	
	public void iniciar(){
		inicial= new Date();
	}
	
	public Date getInicio(){
		return inicial;
	}
	
}

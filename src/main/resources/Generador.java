package resources;

public class Generador {
	
	private char[] elementos={'0','1','2','3','4','5','6','7','8','9' ,'a',
			'b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t',
			'u','v','w','x','y','z'};
	private char[] conjunto = new char[8];
	
	public Generador(){
	}
	
	public String creaPass(){
		for(int i=0;i<8;i++){
			int el = (int)(Math.random()*37);
			conjunto[i] = (char)elementos[el];
			}
		return new String(conjunto);
		}
	
}
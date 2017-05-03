package CapaDomini;

import java.util.HashMap;
import java.util.Map;

public class Venda {

	private Map<Producte,Integer> venda;
	
	public Venda() {
		this.venda = new HashMap<Producte,Integer>();
	}
	
	public void afegirArticle(Producte p, int q) throws IllegalArgumentException{
		if(p == null) throw new IllegalArgumentException("Producte null");
		if(q < 0) throw new IllegalArgumentException("Quantitat no vàlida");
		
		if(venda.containsKey(p)) venda.put(p, venda.get(p) + q);
		else this.venda.put(p, q);
	}

	public float importTotal(){
		float total = 0;
		for (float f : venda.values()) total += f;
		return total;
	}
	
	public int numArticlesVenuts(){return this.venda.size();}
	
}

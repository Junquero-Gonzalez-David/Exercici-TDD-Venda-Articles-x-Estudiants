package CapaDomini;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Venda {

	private Map<Producte,Integer> venda;
	
	public Venda() {
		this.venda = new HashMap<Producte,Integer>();
	}
	
	public void afegirArticle(Producte p, int q) throws IllegalArgumentException{
		if(p == null) throw new IllegalArgumentException("Error afegir article: el producte no pot ser nul");
		if(q <= 0) throw new IllegalArgumentException("Error afegir article: La quantitat ha de ser un enter positiu");
		
		if(venda.containsKey(p)) venda.put(p, venda.get(p) + q);
		else this.venda.put(p.clone(), q);
	}

	public float importTotal(){
		float total = 0;
		for (Entry<Producte, Integer> e : venda.entrySet()){
			total += e.getKey().getPreu() * e.getValue();
		}
		return total;
	}
	
	public String numArticlesVenuts(){
		System.out.println(String.valueOf(this.venda.keySet().size()));
		return String.valueOf(this.venda.keySet().size());
		}
	
}

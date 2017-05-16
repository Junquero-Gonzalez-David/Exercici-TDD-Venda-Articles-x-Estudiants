package CapaDomini;

import java.util.HashSet;

public class Producte implements Cloneable{
	private int id;
	private String nom;
	private float preu;
	private static HashSet<Integer> ids = new HashSet<Integer>();
	
	public Producte(int id, String nom, float preu) throws Exception {
		
		if (nom == null ) throw new Exception("Error Producte: La descripció ha de tenir com a mínim 3 caracters.");
		else if (nom.trim() == "" || nom.length() < 3)
			throw new Exception("Error Producte: La descripció ha de tenir com a mínim 3 caracters.");
		else
			this.nom = nom;

		if (preu > 0)
			this.preu = preu;
		else
			throw new Exception("Error Producte: El preu ha de ser més gran que zero.");
		
		if (id <= 0) throw new Exception("Error Producte: l'identificador ha de ser un enter més gran que zero");
		else if (!(ids.contains(id))){ 
			this.id = id;
			ids.add(id);
		}
		else
			throw new Exception("Error Producte: Ja existeix un producte amb aquest identificador.");
	}
	
	public Producte(int id, String nom, float preu,boolean bool) { // Constructor used by the Clone method
		this.id=id;
		this.nom=nom;
		this.preu=preu;	
	}
	
	
	public String toString(){
		return "Article: "+nom+". Preu = "+preu+". ID Article = "+id;
	}
	
	public int getId(){
		return this.id;
	}
	public String getNom(){
		return this.nom;
	}
	public float getPreu(){
		return this.preu;
	}
	
	public void setId(int nouId) throws Exception{
		if(nouId>0){
			this.id = nouId;
		}
		else {
			throw new Exception("Error Producte: Ja existeix un producte amb aquest identificador.");
		}
	}	
	public void setNom(String nouNom) throws Exception{
		if (nouNom == null || nouNom.trim() == "" || nouNom.length() < 3)
			throw new Exception("Error Producte: La descripció ha de tenir com a mínim 3 caracters.");
		else
			this.nom = nouNom;
	}	
	public void canviarPreu(float nouPreu) throws Exception{
		if (preu > 0)
			this.preu = nouPreu;
		else
			throw new Exception("Error Producte: El preu ha de ser més gran que zero.");
	}
	
	@Override
	public boolean equals(Object o){
		if(!(o instanceof Producte)) throw new IllegalArgumentException("Attempted to compare Producte with non-producte  type");
		return ((Producte)o).id == this.id;
	}
	
	@Override
	public Producte clone(){
		return new Producte(id,nom,preu,true);
	}
	
    @Override
    public int hashCode() {
        return id;
    }
}

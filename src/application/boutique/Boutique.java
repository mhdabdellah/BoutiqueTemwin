package application.boutique;
import application.testuser.*;

public class Boutique {
	
	private int id; 
	private String emplacement;
	private int vendeur ;
	private String  moughataa;
	public String getMoughataa() {
		return moughataa;
	}
	public void setMoughataa(String moughataa) {
		this.moughataa = moughataa;
	}
	public Boutique() {
			super();
			// TODO Auto-generated constructor stub
		}
	public Boutique(int id, String emplacement, int vendeur,String moughataa) {
		super();
		this.id = id;
		this.emplacement = emplacement;
		this.vendeur = vendeur;
		this.moughataa = moughataa;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmplacement() {
		return emplacement;
	}
	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}
	public int getVendeur() {
		return vendeur;
	}
	public void setVendeur(int vendeur) {
		this.vendeur = vendeur;
	}
	
	


}

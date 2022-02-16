package application.produit;

public class produits {
	private int id ,remise,prix,quantite,quantite_pour_client;
	private String code_produit,deseignation,fournisseur;
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public int getRemise() {
		return remise;
	}
	public void setRemise(int remise) {
		this.remise = remise;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeseignation() {
		return deseignation;
	}
	public void setDeseignation(String deseignation) {
		this.deseignation = deseignation;
	}
	public String getCode_produit() {
		return code_produit;
	}
	public void setCode_produit(String code_produit) {
		this.code_produit = code_produit;
	}
	public int getQuantite_pour_client() {
		return quantite_pour_client;
	}
	public void setQuantite_pour_client(int quantite_pour_client) {
		this.quantite_pour_client = quantite_pour_client;
	}
	public String getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}
	
	public produits( int id,String code_produit,String deseignation,int quantite_pour_client,String fournisseur,int remise,int prix,int quantite) {
		this.id=id;
		this.code_produit=code_produit;
		this.deseignation=deseignation;
		this.quantite_pour_client=quantite_pour_client;
		this.fournisseur=fournisseur;
		this.remise=remise;
		this.prix=prix;
		this.quantite=quantite;
		
	}

}

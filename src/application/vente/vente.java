package application.vente;

public class vente {
   private int id,idclient,quantite_vendues,idvendeur;
   private String datevente,produit;

   public vente(int id,int idclient,int quantite_vendues,int idvendeur,String datevente,String produit) {
	   this.id=id;
	   this.idclient=idclient;
	   this.quantite_vendues=quantite_vendues;
	   this.idvendeur=idvendeur;
	   this.datevente=datevente;
	   this.produit=produit;
   }
   
public int getIdvendeur() {
	return idvendeur;
}
public void setIdvendeur(int idvendeur) {
	this.idvendeur = idvendeur;
}
public int getQuantite_vendues() {
	return quantite_vendues;
}
public void setQuantite_vendues(int quantite_vendues) {
	this.quantite_vendues = quantite_vendues;
}
public int getIdclient() {
	return idclient;
}
public void setIdclient(int idclient) {
	this.idclient = idclient;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDatevente() {
	return datevente;
}
public void setDatevente(String datevente) {
	this.datevente = datevente;
}

public String getProduit() {
	return produit;
}

public void setProduit(String produit) {
	this.produit = produit;
}

}

package application.megazin;

public class magazin {
	   private int id,idmagazinieur;
	   private String lieu,moughataa;

public magazin(int id, int idmagazinieur, String lieu, String moughataa) 
       {
		   this.id=id;
		   this.idmagazinieur=idmagazinieur;
		   this.lieu=lieu;
		   this. moughataa= moughataa;
		   
	   }
	   
//public magazin(int int1, int int2, String string, String string2) {
//	// TODO Auto-generated constructor stub
//	this.id=int1;
//	   this.idmagazinieur=int2;
//	   this.lieu=string;
//	   this. moughataa= string2;
//}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdmagazinieur() {
		return idmagazinieur;
	}

	public void setIdmagazinieur(int idmagazinieur) {
		this.idmagazinieur = idmagazinieur;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getMoughataa() {
		return moughataa;
	}

	public void setMoughataa(String moughataa) {
		this.moughataa = moughataa;
	}
	   


}

package application.client;

public class client {
	private int id ,idvendeur;
    private String username, lastname, nni , qrcode;
    
    public client(int id,String username,String lastname,String nni,String qrcode,int idvendeur) {
    	this.id=id;
    	this.username=username;
    	this.lastname=lastname;
    	this.nni= nni;
    	this.qrcode= qrcode;
    	this.idvendeur=idvendeur;
    }
    
	public int getIdvendeur() {
		return idvendeur;
	}
	public void setIdvendeur(int idvendeur) {
		this.idvendeur = idvendeur;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQrcode() {
		return qrcode;
	}
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNni() {
		return nni;
	}
	public void setNni(String nni) {
		this.nni = nni;
	}

}

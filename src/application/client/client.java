package application.client;

public class client {
	private int id;
    private String username, lastname, nni , qrcode,qrimage;
    
    public client(int id,String username,String lastname,String nni,String qrcode,String qrimage) {
    	this.id=id;
    	this.username=username;
    	this.lastname=lastname;
    	this.nni= nni;
    	this.qrcode= qrcode;
    	this.qrimage = qrimage;
    }
    
	public String getQrimage() {
		return qrimage;
	}

	public void setQrimage(String qrimage) {
		this.qrimage = qrimage;
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

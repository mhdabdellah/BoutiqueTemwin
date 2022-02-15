package application;

public class Users {
	private int id;
	private String name,password,email,type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Users(int id,String name,String password,String email,String type){
		this.id=id;
		this.name= name;
		this.password = password;
		this.email = email;
		this.type =type;
		
	}

}

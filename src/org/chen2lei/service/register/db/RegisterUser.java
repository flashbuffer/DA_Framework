package org.chen2lei.service.register.db;

public class RegisterUser {
	private long id;
	private String name;
	private String telNumber;
	private String email;
	private String password;
	private long companyId;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	
	@Override
	public String toString(){
		return "id="+id+";name="+name+";telNumber="+telNumber+";email="+email;
		
	}
	
	
	
	
}

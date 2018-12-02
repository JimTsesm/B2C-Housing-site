package model;


import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name="user")
@XmlAccessorType (XmlAccessType.FIELD)
public class XMLUser {
	
	private int idUser;
	
	private String username;
	
	private String password;
	
	private String name;

	private String surname;

	private String mail;

	private String phone;
	
	private int hasReview;
	
	private ListListing listings;
	
	public XMLUser() {
	}
	
	public XMLUser(int id,String username,String password,String name,String surname,String email,String phone) {
		this.setIdUser(id);
		this.setUsername(username);
		this.setPassword(password);
		this.setName(name);
		this.setSurname(surname);
		this.setMail(email);
		this.setPhone(phone);		
	}
	
	public int getIdUser() {
		return this.idUser;
	}

	
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	public void setListing(ListListing listings){
		this.listings = listings;
	}

	public String getMail() {
		return this.mail;
	}

	
	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return this.name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSurname() {
		return this.surname;
	}

	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public int getHasReview() {
		return this.hasReview;
	}

	
	public void setHasReview(int hasReview) {
		this.hasReview = hasReview;
	}

	public String getUsername() {
		return this.username;
	}

	
	public void setUsername(String username) {
		this.username = username;
	}

}

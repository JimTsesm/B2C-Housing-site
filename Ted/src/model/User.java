package model;

import java.util.*;


import java.io.Serializable;
import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUser;
	
	private String username;
	
	private String password;
	
	private String name;

	private String surname;

	private String mail;

	private String phone;

	private byte[] photo;

	private int hasReview;

	//bi-directional many-to-one association to Role
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Role> roles;
	
	//bi-directional one-to-one association to Request
	@OneToOne(mappedBy="user",cascade = CascadeType.ALL, orphanRemoval = true)
	private Request requests;
	
	//bi-directional many-to-one association to Reservation
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Reservation> reservation;
	
	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="sender",fetch = FetchType.EAGER)
	private Set<Message> sender_message;
	
	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="receiver",fetch = FetchType.EAGER)
	private Set<Message> receiver_message;
	
	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="hostIds",fetch = FetchType.EAGER)
	private Set<Listing> listing;
	
	//bi-directional many-to-one association to Deletedmessage
	@OneToMany(mappedBy="user",fetch = FetchType.EAGER)
	private Set<Deletedmessage> deleted_message;

	public User() {
	}
	
	public User(String username,String password,String name,String surname,String email,String phone,byte[] photo) {
		roles = new HashSet<Role>();
		sender_message = new HashSet<Message>();
		receiver_message = new HashSet<Message>();
		//requests = new Request();
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.mail = email;
		this.phone = phone;
		this.photo = photo;
		this.hasReview = -1;
	}	
	
	public void init_params(){
		sender_message = new HashSet<Message>();
		receiver_message = new HashSet<Message>();
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
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

	public byte[] getPhoto() {
		return this.photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
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

	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Role addRole(Role role) {
		getRoles().add(role);
		role.setUser(this);

		return role;
	}

	public Role removeRole(Role role) {
		getRoles().remove(role);
		role.setUser(null);

		return role;
	}
	
	public Set<Reservation> getReservation() {
		return this.reservation;
	}

	public void setReservation(Set<Reservation> reservation) {
		this.reservation = reservation;
	}
	
	public Reservation addReservation(Reservation reservation) {
		getReservation().add(reservation);
		reservation.setUser(this);

		return reservation;
	}

	public Reservation removeReservation(Reservation reservation) {
		getRoles().remove(reservation);
		reservation.setUser(null);

		return reservation;
	}
	
	public Request getRequest() {
		return this.requests;
	}

	public void setRequest(Request requests) {
		this.requests = requests;
	}
	
	public Set<Message> getSenderMessage() {
		return this.sender_message;
	}

	public void setSenderMessage(Set<Message> sender_message) {
		this.sender_message = sender_message;
	}
	
	public Message addSenderMessage(Message sender_message) {
		getSenderMessage().add(sender_message);
		sender_message.setSender(this);

		return sender_message;
	}

	public Message removeSenderMessage(Message sender_message) {
		getRoles().remove(sender_message);
		sender_message.setSender(null);

		return sender_message;
	}
	
	public Set<Message> getReceiverMessage() {
		return this.receiver_message;
	}

	public void setReceiverMessage(Set<Message> receiver_message) {
		this.receiver_message = receiver_message;
	}
	
	public Message addgetReceiverMessage(Message receiver_message) {
		getReceiverMessage().add(receiver_message);
		receiver_message.setReceiver(this);

		return receiver_message;
	}

	public Message removegetReceiverMessage(Message receiver_message) {
		getRoles().remove(receiver_message);
		receiver_message.setReceiver(null);

		return receiver_message;
	}
	
	public Listing addListing(Listing reservation) {
		getListing().add(reservation);
		reservation.setHostIds(this);

		return reservation;
	}

	public Listing removeListing(Listing reservation) {
		getRoles().remove(reservation);
		reservation.setHostIds(null);

		return reservation;
	}
	
	public Set<Listing> getListing() {
		return this.listing;
	}

	public void setListing(Set<Listing> requests) {
		this.listing = requests;
	}
	
	public Set<Deletedmessage> getDeletedmessage() {
		return this.deleted_message;
	}
	
	public void setDeletedmessage(Set<Deletedmessage> messages) {
		this.deleted_message = messages;
	}

	public Deletedmessage addDeletedmessage(Deletedmessage message) {
		getDeletedmessage().add(message);
		message.setUser(this);

		return message;
	}

	public Deletedmessage removeDeletedmessage(Deletedmessage message) {
		getDeletedmessage().remove(message);
		message.setUser(null);

		return message;
	}
}
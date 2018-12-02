package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the request database table.
 * 
 */
@Entity
@NamedQuery(name="Request.findAll", query="SELECT r FROM Request r")
public class Request implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idUser;

	@Temporal(TemporalType.DATE)
	private Date date;

	private int pending;

	//bi-directional one-to-one association to User
	//@OneToOne
	//@JoinColumn(name="idHost",insertable=false, updatable=false)
	//private User user;
	
	//bi-directional many-to-one association to User
	@OneToOne()
	@JoinColumn(name="idUser",insertable=false, updatable=false)
	private User user;

	public Request() {
		this.date = new Date();
		setPending(1);
	}

	public int getIdHost() {
		return this.idUser;
	}

	public void setIdHost(int idUser) {
		this.idUser = idUser;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getPending() {
		return this.pending;
	}

	public void setPending(int pending) {
		this.pending = pending;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
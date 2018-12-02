package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the deletedmessage database table.
 * 
 */
@Entity
@NamedQuery(name="Deletedmessage.findAll", query="SELECT d FROM Deletedmessage d")
public class Deletedmessage implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DeletedmessagePK id;
	
	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idMessage")
	private Message message;
	
	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;

	public Deletedmessage() {
	}

	public DeletedmessagePK getId() {
		return this.id;
	}

	public void setId(DeletedmessagePK id) {
		this.id = id;
	}
	
	public Message getDeletedmessage() {
		return this.message;
	}

	public void setDeletedmessage(Message message) {
		this.message = message;
	}
	
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
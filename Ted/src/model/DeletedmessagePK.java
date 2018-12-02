package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the deletedmessage database table.
 * 
 */
@Embeddable
public class DeletedmessagePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idMessage;

	@Column(insertable=false, updatable=false)
	private int idUser;

	public DeletedmessagePK() {
	}
	public int getIdMessage() {
		return this.idMessage;
	}
	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}
	public int getIdUser() {
		return this.idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DeletedmessagePK)) {
			return false;
		}
		DeletedmessagePK castOther = (DeletedmessagePK)other;
		return 
			(this.idMessage == castOther.idMessage)
			&& (this.idUser == castOther.idUser);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idMessage;
		hash = hash * prime + this.idUser;
		
		return hash;
	}
}
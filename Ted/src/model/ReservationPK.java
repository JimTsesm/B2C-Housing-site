package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the reservation database table.
 * 
 */
@Embeddable
public class ReservationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idUser;

	@Column(insertable=false, updatable=false)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="check_in_date")
	private java.util.Date checkInDate;

	public ReservationPK() {
	}
	public int getIdTenant() {
		return this.idUser;
	}
	public void setIdTenant(int idTenant) {
		this.idUser = idTenant;
	}
	public int getIdProperty() {
		return this.id;
	}
	public void setIdProperty(int idProperty) {
		this.id = idProperty;
	}
	public java.util.Date getCheckInDate() {
		return this.checkInDate;
	}
	public void setCheckInDate(java.util.Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ReservationPK)) {
			return false;
		}
		ReservationPK castOther = (ReservationPK)other;
		return 
			(this.idUser == castOther.idUser)
			&& (this.id == castOther.id)
			&& this.checkInDate.equals(castOther.checkInDate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idUser;
		hash = hash * prime + this.id;
		hash = hash * prime + this.checkInDate.hashCode();
		
		return hash;
	}
}
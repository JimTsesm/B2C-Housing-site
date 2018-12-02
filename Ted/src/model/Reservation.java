package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the reservation database table.
 * 
 */
@Entity
@NamedQuery(name="Reservation.findAll", query="SELECT r FROM Reservation r")
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ReservationPK reservation_id;

	@Temporal(TemporalType.DATE)
	@Column(name="check_out_date")
	private Date checkOutDate;

	//bi-directional many-to-one association to Listing
	@ManyToOne
	@JoinColumn(name="id")
	private Listing listing;
	
	//bi-directional many-to-one association to Listing
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;

	public Reservation() {
		
	}

	public Reservation(ReservationPK id, Date date) {
		this.reservation_id = new ReservationPK();
		setId(id);
		setCheckOutDate(date);
	}

	public ReservationPK getId() {
		return this.reservation_id;
	}

	public void setId(ReservationPK id) {
		this.reservation_id = id;
	}

	public Date getCheckOutDate() {
		return this.checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public Listing getListing() {
		return this.listing;
	}

	public void setListing(Listing listing) {
		this.listing = listing;
	}
	
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
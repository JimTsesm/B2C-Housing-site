package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the calendar database table.
 * 
 */
@Entity
@NamedQuery(name="Calendar.findAll", query="SELECT c FROM Calendar c")
public class Calendar implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CalendarPK id;

	private String available;

	private String price;
	
	//bi-directional many-to-one association to Listing
	@ManyToOne
	@JoinColumn(name="idProperty")
	private Listing listing;

	public Calendar() {
	}

	public CalendarPK getId() {
		return this.id;
	}

	public void setId(CalendarPK id) {
		this.id = id;
	}

	public String getAvailable() {
		return this.available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Listing getListing() {
		return this.listing;
	}

	public void setListing(Listing listing) {
		this.listing = listing;
	}
	
}
package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the reviews database table.
 * 
 */
@Entity
@Table(name="reviews")
@NamedQuery(name="Review.findAll", query="SELECT r FROM Review r")
public class Review implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String comments;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name="`id(???????)`")
	private String id_________;

	@Column(name="reviewer_name")
	private String reviewerName;

	//bi-directional many-to-one association to Listing
	@ManyToOne
	private Listing listing;

	public Review() {
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getId_________() {
		return this.id_________;
	}

	public void setId_________(String id_________) {
		this.id_________ = id_________;
	}

	public String getReviewerName() {
		return this.reviewerName;
	}

	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}

	public Listing getListing() {
		return this.listing;
	}

	public void setListing(Listing listing) {
		this.listing = listing;
	}

}
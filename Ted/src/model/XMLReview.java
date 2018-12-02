package model;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name="review")
@XmlAccessorType (XmlAccessType.FIELD)

public class XMLReview {
	
	private int id;
	private String date;
	private String reviewer_name;
	private String comment;
	
	public XMLReview() {
	}
	
	public XMLReview(int id,String date,String reviewer_name,String comment) {
		this.setId(id);
		this.setDate(date);
		this.setReviewer_name(reviewer_name);
		this.setComment(comment);		
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setReviewer_name(String reviewer_name) {
		this.reviewer_name = reviewer_name;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	

}

package model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="reviews")
@XmlAccessorType (XmlAccessType.FIELD)
public class ListingReview {

	@XmlElement(name = "review")	
	private List<XMLReview> listreview = null;

	public List<XMLReview> getList() {
	    return this.listreview;
	}

	public void setList(List<XMLReview> listreview) {
	    this.listreview = listreview;
	}
}

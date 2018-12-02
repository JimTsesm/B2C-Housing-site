package model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlRootElement(name="listings")
@XmlAccessorType (XmlAccessType.FIELD)
public class ListListing {
	
	@XmlElement(name = "listing")	
	private List<XMLListing> listlisting = null;

	public List<XMLListing> getList() {
	    return this.listlisting;
	}

	public void setList(List<XMLListing> listlisting) {
	    this.listlisting = listlisting;
	}

}
